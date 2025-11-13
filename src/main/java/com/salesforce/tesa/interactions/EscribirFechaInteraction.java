package com.salesforce.tesa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EscribirFechaInteraction implements Interaction {

    private final Target campo;
    private final String fecha;

    public EscribirFechaInteraction(Target campo, String fecha) {
        this.campo = campo;
        this.fecha = fecha;
    }

    public static EscribirFechaInteraction en(Target campo, String fecha) {
        return Tasks.instrumented(EscribirFechaInteraction.class, campo, fecha);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = ThucydidesWebDriverSupport.getDriver();
        WebElement input = campo.resolveFor(actor);

        input.click();
        input.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE); // limpia
        input.sendKeys(fecha);

        try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }


        ((JavascriptExecutor) driver).executeScript("arguments[0].blur();", input);
    }
}
