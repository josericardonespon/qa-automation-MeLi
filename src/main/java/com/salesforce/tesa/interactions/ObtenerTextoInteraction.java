package com.salesforce.tesa.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class ObtenerTextoInteraction implements Interaction {

    private final Target target;
    private final String memoryKey;
    private final int waitSeconds;

    private ObtenerTextoInteraction(Target target, String memoryKey, int waitSeconds) {
        this.target = target;
        this.memoryKey = memoryKey;
        this.waitSeconds = waitSeconds;
    }

    @Override
    @Step("{0} extrae texto robusto de '#target' y lo guarda como '{memoryKey}'")
    public <T extends Actor> void performAs(T actor) {
        // Esperar que el elemento esté presente
        actor.attemptsTo(
                WaitUntil.the(target, isPresent())
                        .forNoMoreThan(java.time.Duration.ofSeconds(waitSeconds))
        );

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebElement element = target.resolveFor(actor);

        String texto = null;

        // ESTRATEGIA 1: getText() - Método estándar
        try {
            texto = element.getText();
            if (texto != null && !texto.trim().isEmpty()) {
                System.out.println("  ✓ Estrategia 1 (getText): " + texto.trim());
                actor.remember(memoryKey, texto.trim());
                return;
            }
        } catch (Exception e) {
            System.out.println("  ✗ Estrategia 1 falló: " + e.getMessage());
        }

        // ESTRATEGIA 2: textContent via JavaScript
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            texto = (String) js.executeScript("return arguments[0].textContent;", element);
            if (texto != null && !texto.trim().isEmpty()) {
                System.out.println("  ✓ Estrategia 2 (textContent): " + texto.trim());
                actor.remember(memoryKey, texto.trim());
                return;
            }
        } catch (Exception e) {
            System.out.println("  ✗ Estrategia 2 falló: " + e.getMessage());
        }

        // ESTRATEGIA 3: innerText via JavaScript
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            texto = (String) js.executeScript("return arguments[0].innerText;", element);
            if (texto != null && !texto.trim().isEmpty()) {
                System.out.println("  ✓ Estrategia 3 (innerText): " + texto.trim());
                actor.remember(memoryKey, texto.trim());
                return;
            }
        } catch (Exception e) {
            System.out.println("  ✗ Estrategia 3 falló: " + e.getMessage());
        }

        // ESTRATEGIA 4: getAttribute("title")
        try {
            texto = element.getAttribute("title");
            if (texto != null && !texto.trim().isEmpty()) {
                System.out.println("  ✓ Estrategia 4 (title): " + texto.trim());
                actor.remember(memoryKey, texto.trim());
                return;
            }
        } catch (Exception e) {
            System.out.println("  ✗ Estrategia 4 falló: " + e.getMessage());
        }

        // ESTRATEGIA 5: getAttribute("textContent")
        try {
            texto = element.getAttribute("textContent");
            if (texto != null && !texto.trim().isEmpty()) {
                System.out.println("  ✓ Estrategia 5 (getAttribute textContent): " + texto.trim());
                actor.remember(memoryKey, texto.trim());
                return;
            }
        } catch (Exception e) {
            System.out.println("  ✗ Estrategia 5 falló: " + e.getMessage());
        }

        // ESTRATEGIA 6: Buscar en hijos <span>
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            texto = (String) js.executeScript(
                    "var spans = arguments[0].querySelectorAll('span'); " +
                            "for(var i=0; i<spans.length; i++) { " +
                            "  if(spans[i].textContent.trim() !== '') return spans[i].textContent.trim(); " +
                            "} return '';",
                    element
            );
            if (texto != null && !texto.trim().isEmpty()) {
                System.out.println("  ✓ Estrategia 6 (span hijo): " + texto.trim());
                actor.remember(memoryKey, texto.trim());
                return;
            }
        } catch (Exception e) {
            System.out.println("  ✗ Estrategia 6 falló: " + e.getMessage());
        }

        // Si todas las estrategias fallan
        System.out.println("  ⚠ TODAS LAS ESTRATEGIAS FALLARON - Guardando vacío");
        actor.remember(memoryKey, "TEXTO NO ENCONTRADO");
    }

    // Factory methods
    public static ObtenerTextoInteraction desde(Target target, String memoryKey) {
        return new ObtenerTextoInteraction(target, memoryKey, 30);
    }

    public static ObtenerTextoInteraction desde(Target target, String memoryKey, int waitSeconds) {
        return new ObtenerTextoInteraction(target, memoryKey, waitSeconds);
    }
}