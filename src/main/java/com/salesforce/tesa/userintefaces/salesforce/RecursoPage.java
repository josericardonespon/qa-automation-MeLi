package com.salesforce.tesa.userintefaces.salesforce;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RecursoPage {
    public static final Target RADIO_RECURSO= Target.the("radio recurso")
            .located(By.xpath("//label[.//span[normalize-space(text())='Recurso']]//span[contains(@class,'slds-radio_faux')]"));
    public static final Target IR_EVENTO_RECURSO = Target.the("link recurso created")
            .located(By.xpath("//span[contains(normalize-space(.),'Ir al nuevo evento')]//a[normalize-space(text())='Recurso']"));
    public static final Target VISTA_RECURSO = Target.the("Vista de recurso")
            .located(By.xpath("(//div[@class='slds-grid slds-col slds-has-flexi-truncate' and contains(.,'Evento') and contains(.,'Recurso')])[last()]"));
    public static final Target COMBO_ACTOR_RECURSO = Target.the("combo actor recurso")
            .located(By.xpath("//select[@name='ResourceActorPicklist']"));
    public static final Target OPTION_MELI = Target.the("option MELI")
            .located(By.xpath("//option[normalize-space()='MELI']"));
}
