package com.salesforce.tesa.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class HacerClickConControlInteraction implements Interaction {

    private final Target targetElement;
    private int waitSeconds;

    public HacerClickConControlInteraction(Target targetElement, int waitSeconds) {
        this.targetElement = targetElement;
        this.waitSeconds = waitSeconds;
    }

    public HacerClickConControlInteraction(Target targetElement) {
        this(targetElement, 30);
    }

    @Override
    @Step("{0} hace clic CON CONTROL en el elemento '#targetElement' (espera: {waitSeconds}s)")
    public <T extends Actor> void performAs(T actor) {
        try {
            // Esperar que el elemento sea clickeable
            actor.attemptsTo(
                    Check.whether(targetElement.resolveFor(actor).isClickable())
                            .otherwise(WaitUntil.the(targetElement, isClickable())
                                    .forNoMoreThan(Duration.ofSeconds(waitSeconds)))
            );

            // Obtener driver y elemento
            WebDriver driver = BrowseTheWeb.as(actor).getDriver();
            WebElement element = targetElement.resolveFor(actor);

            // Hacer click con CONTROL presionado
            Actions actions = new Actions(driver);
            actions.keyDown(Keys.CONTROL)
                    .click(element)
                    .keyUp(Keys.CONTROL)
                    .perform();

        } catch (Exception e) {
            throw new RuntimeException("Error al hacer clic con CONTROL en el elemento: " + targetElement, e);
        }
    }

    public static HacerClickConControlInteraction on(Target targetElement) {
        return new HacerClickConControlInteraction(targetElement);
    }

    public HacerClickConControlInteraction withOptions(int waitSeconds) {
        this.waitSeconds = waitSeconds;
        return this;
    }
}