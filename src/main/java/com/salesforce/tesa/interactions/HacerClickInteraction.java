package com.salesforce.tesa.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class HacerClickInteraction implements Interaction {

    private final Target targetElement;
    private int waitSeconds;
    private boolean useJavaScriptClick;
    private boolean withControl; // NUEVO

    public HacerClickInteraction(Target targetElement, int waitSeconds, boolean useJavaScriptClick, boolean withControl) {
        this.targetElement = targetElement;
        this.waitSeconds = waitSeconds;
        this.useJavaScriptClick = useJavaScriptClick;
        this.withControl = withControl;
    }

    public HacerClickInteraction(Target targetElement) {
        this(targetElement, 30, false, false);
    }

    @Override
    @Step("{0} hace clic en el elemento '#targetElement' (espera: {waitSeconds}s, JavaScript: {useJavaScriptClick}, CTRL: {withControl})")
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Check.whether(targetElement.resolveFor(actor).isClickable())
                            .otherwise(WaitUntil.the(targetElement, isClickable())
                                    .forNoMoreThan(Duration.ofSeconds(waitSeconds)))
            );

            // SI SE REQUIERE CLICK CON CONTROL
            if (withControl) {
                WebDriver driver = BrowseTheWeb.as(actor).getDriver();
                WebElement element = targetElement.resolveFor(actor);

                Actions actions = new Actions(driver);
                actions.keyDown(Keys.CONTROL)
                        .click(element)
                        .keyUp(Keys.CONTROL)
                        .perform();
            }
            // CLICK NORMAL
            else {
                actor.attemptsTo(
                        Check.whether(useJavaScriptClick)
                                .andIfSo(JavaScriptClick.on(targetElement))
                                .otherwise(Click.on(targetElement))
                );
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al hacer clic en el elemento: " + targetElement, e);
        }
    }

    public static HacerClickInteraction on(Target targetElement) {
        return new HacerClickInteraction(targetElement);
    }

    public HacerClickInteraction withOptions(int waitSeconds) {
        this.waitSeconds = waitSeconds;
        return this;
    }

    public HacerClickInteraction withOptions(boolean useJavaScriptClick) {
        this.useJavaScriptClick = useJavaScriptClick;
        return this;
    }

    public HacerClickInteraction withOptions(int waitSeconds, boolean useJavaScriptClick) {
        this.waitSeconds = waitSeconds;
        this.useJavaScriptClick = useJavaScriptClick;
        return this;
    }

    // NUEVO MÉTODO PARA CONTROL
    public HacerClickInteraction withControl(boolean withControl) {
        this.withControl = withControl;
        return this;
    }

    // NUEVO MÉTODO SOBRECARGADO
    public HacerClickInteraction withOptions(int waitSeconds, boolean useJavaScriptClick, boolean withControl) {
        this.waitSeconds = waitSeconds;
        this.useJavaScriptClick = useJavaScriptClick;
        this.withControl = withControl;
        return this;
    }
}