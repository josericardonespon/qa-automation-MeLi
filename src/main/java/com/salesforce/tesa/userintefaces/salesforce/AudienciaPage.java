package com.salesforce.tesa.userintefaces.salesforce;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AudienciaPage {

    public static final Target RADIO_AUDIENCIA= Target.the("radio audiencia")
            .located(By.xpath("//label[.//span[normalize-space(text())='Audiencia']]//span[contains(@class,'slds-radio_faux')]"));

    public static final Target IR_EVENTO_AUDIENCIA = Target.the("link Audiencia created")
            .located(By.xpath("//span[contains(normalize-space(.),'Ir al nuevo evento')]//a[normalize-space(text())='Audiencia']"));
    public static final Target VISTA_AUDIENCIA = Target.the("Vista de audiencia")
            .located(By.xpath("(//div[@class='slds-grid slds-col slds-has-flexi-truncate' and contains(.,'Evento') and contains(.,'Audiencia')])[last()]"));
}
