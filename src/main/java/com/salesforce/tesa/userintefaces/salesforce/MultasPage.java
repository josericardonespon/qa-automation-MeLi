package com.salesforce.tesa.userintefaces.salesforce;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MultasPage {
    public static final Target RADIO_MULTAS= Target.the("radio multa")
            .located(By.xpath("//label[.//span[normalize-space(text())='Multas']]//span[contains(@class,'slds-radio_faux')]"));
    public static final Target IR_EVENTO_MULTAS = Target.the("link Multas created")
            .located(By.xpath("//span[contains(normalize-space(.),'Ir al nuevo evento')]//a[normalize-space(text())='Multas']"));
    public static final Target VISTA_MULTAS = Target.the("Vista de Multas")
            .located(By.xpath("(//div[@class='slds-grid slds-col slds-has-flexi-truncate' and contains(.,'Evento') and contains(.,'Multa')])[last()]"));
    public static final Target MONTO_MULTA = Target.the("Monto Multa")
            .located(By.xpath("//input[@name='Amount']"));

}
