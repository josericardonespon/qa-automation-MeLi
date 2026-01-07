package com.salesforce.tesa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HacerScrollProgresivoInteraction implements Interaction {

    private final int step;        // píxeles por "salto"
    private final int delayMillis; // espera entre saltos

    public HacerScrollProgresivoInteraction(int step, int delayMillis) {
        this.step = step;
        this.delayMillis = delayMillis;
    }

    public static Performable hastaElFinalDeLaPagina() {
        // step = 300px, delay = 200ms entre cada movimiento
        return Tasks.instrumented(HacerScrollProgresivoInteraction.class, 300, 200);
    }

    public static Performable conPasoYEspera(int step, int delayMillis) {
        return Tasks.instrumented(HacerScrollProgresivoInteraction.class, step, delayMillis);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Altura total del documento
        long documentHeight = ((Number) js.executeScript(
                "return Math.max(document.body.scrollHeight, document.documentElement.scrollHeight);"
        )).longValue();

        // Posición inicial
        long currentScroll = ((Number) js.executeScript("return window.pageYOffset;")).longValue();

        int maxScrolls = 200; // seguridad para evitar loops infinitos
        int contador = 0;

        while (currentScroll + step < documentHeight && contador < maxScrolls) {
            js.executeScript("window.scrollBy(0, arguments[0]);", step);

            // Espera para que se vea el movimiento
            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

            // Actualizar posición y altura (por si se carga contenido dinámico)
            currentScroll = ((Number) js.executeScript("return window.pageYOffset;")).longValue();
            documentHeight = ((Number) js.executeScript(
                    "return Math.max(document.body.scrollHeight, document.documentElement.scrollHeight);"
            )).longValue();

            contador++;
        }

        // Asegurarnos de llegar al final
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
}
