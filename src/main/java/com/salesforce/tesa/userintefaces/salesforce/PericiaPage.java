package com.salesforce.tesa.userintefaces.salesforce;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PericiaPage {

    public static final Target RADIO_PERICIA= Target.the("radio multa")
            .located(By.xpath("//label[.//span[normalize-space(text())='Pericia']]//span[contains(@class,'slds-radio_faux')]"));
    public static final Target IR_EVENTO_PERICIA = Target.the("link pericia ")
            .located(By.xpath("//span[contains(normalize-space(.),'Ir al nuevo evento')]//a[normalize-space(text())='Pericia']"));
    public static final Target VISTA_PERICIA = Target.the("Vista de pericia creada")
            .located(By.xpath("(//div[@class='slds-grid slds-col slds-has-flexi-truncate' and contains(.,'Evento') and contains(.,'Pericia')])[last()]"));
    public static final Target PERITO_DE_LA_AUTORIDAD = Target.the("label perito de la autoridad")
            .located(By.xpath("//input[@name='AuthorityExpert']"));
    public static final Target PERITO_TECNICO = Target.the("label perito tecnico")
            .located(By.xpath("//input[@name='TechnicalAdvisor']"));
    public static final Target COMBO_RESULTADO_PERICIA = Target.the("COMBO result Decision")
            .located(By.xpath("//select[@name='AssessmentResultPicklist']"));
    public static final Target OPTION_FAVORABLE_MELI_PERICIA = Target.the("option Favorable para MELI")
            .located(By.xpath("//select[@name='AssessmentResultPicklist']/option[contains(.,'Favorable para MELI')]"));

}
