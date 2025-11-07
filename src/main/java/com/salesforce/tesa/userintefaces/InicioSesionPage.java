package com.salesforce.tesa.userintefaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InicioSesionPage {
    public static final Target INPUT_SEARCH= Target.the("Quick search input")
            .located(By.xpath("//input[@placeholder='Search Setup']"));
    public static final Target SEARCH_RESULT= Target.the("Quick search input")
            .located(By.xpath("//span[@title='Abogado Externo']"));
    public static final Target IFRAME_ABOGADO= Target.the("iframe abogado externo")
            .located(By.xpath("//iframe[@title='User: Abogado Externo ~ Salesforce - Unlimited Edition']"));
    public static final Target BTN_LOGIN= Target.the("button login")
            .located(By.xpath("(//input[@title='Login'])[1]"));
    public static final Target WELCOME_ABOGADO = Target.the("welcome abogado")
            .located(By.xpath("//span[contains(text(), 'Inicio de sesión como')]"));
    public static final Target BARRA_CERRAR_SESION = Target.the("barra cerrar sesion")
            .located(By.xpath("//*[@id=\"oneHeader\"]/div[1]/div"));

}

