package com.salesforce.tesa.userintefaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InicioSesionPage {
    public static final Target INPUT_USER= Target.the("input user")
            .located(By.xpath("//input[@id='username']"));
    public static final Target INPUT_PASSWORD= Target.the("input user")
            .located(By.xpath("//input[@id='password']"));
    public static final Target BTN_LOGIN_SALESFORCE= Target.the("button login salesforce")
            .located(By.xpath("//input[@id='Login']"));
    public static final Target INPUT_SEARCH= Target.the("Quick search input")
            .located(By.xpath("//input[@placeholder='Search Setup']"));
    public static final Target SEARCH_RESULT= Target.the("Quick search input")
                    .locatedBy("//span[@title='{0}']");
    public static final Target IFRAME_LOGIN_AS = Target.the("iframe para login-as")
                    .locatedBy("//iframe[contains(@title, 'User: {0} ~ Salesforce')]");
    public static final Target BTN_LOGIN= Target.the("button login")
            .located(By.xpath("(//input[@title='Login'])[1]"));
    public static final Target BARRA_CERRAR_SESION = Target.the("barra cerrar sesion")
            .located(By.xpath("//*[@id=\"oneHeader\"]/div[1]/div"));
    public static final Target BTN_CERRAR_SESION = Target.the("Boton cerrar sesión")
            .located(By.xpath("//a[contains(normalize-space(), 'Cerrar sesión')]"));


}

