package com.salesforce.tesa.userintefaces.salesforce;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AcuerdosPage {


    public static final Target RADIO_ACUERDO= Target.the("radio acuerdo")
            .located(By.xpath("//label[.//span[normalize-space(text())='Acuerdo']]//span[contains(@class,'slds-radio_faux')]"));

    public static final Target COMBO_RESULT_AGREEMENT = Target.the("COMBO result agreement")
            .located(By.xpath("//select[@name='AgreementResult']"));

    public static final Target OPTION_PAGA_LEGALES = Target.the("option paga legales")
            .located(By.xpath("//select[@name='AgreementResult']/option[normalize-space(text())='Paga Legales - MELI']"));
    public static final Target INPUT_FILE = Target.the("input file")
            .located(By.xpath("//input[@type='file' and contains(@id,'input-file')]"));

    public static final Target IR_EVENTO_ACUERDO = Target.the("link Acuerdo createdo")
            .located(By.xpath("//span[contains(normalize-space(.),'Ir al nuevo evento')]//a[normalize-space(text())='Acuerdo']"));
    public static final Target VISTA_ACUERDO = Target.the("Vista de acuerdos")
            .located(By.xpath("(//div[@class='slds-grid slds-col slds-has-flexi-truncate' and contains(.,'Evento') and contains(.,'Acuerdo')])[last()]"));









}
