package com.salesforce.tesa.userintefaces.salesforce;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DecisionPage {

    public static final Target RADIO_DECISION= Target.the("radio decision")
            .located(By.xpath("//label[.//span[normalize-space(text())='Decisión']]//span[contains(@class,'slds-radio_faux')]"));

    public static final Target IR_EVENTO_DECISION = Target.the("link Decision created")
            .located(By.xpath("//span[contains(normalize-space(.),'Ir al nuevo evento')]//a[normalize-space(text())='Decisión']"));
    public static final Target VISTA_DECISION = Target.the("Vista de Decisión")
            .located(By.xpath("(//div[@class='slds-grid slds-col slds-has-flexi-truncate' and contains(.,'Evento') and contains(.,'Decisión')])[last()]"));
    public static final Target COMBO_RESULT_DECISION = Target.the("COMBO result Decision")
            .located(By.xpath("//select[@name='DecisionResultPicklist']"));
    public static final Target OPTION_FAVORABLE_MELI = Target.the("option Favorable para MELI")
            .located(By.xpath("//select[@name='DecisionResultPicklist']/option[contains(.,'Favorable para MELI')]"));

}
