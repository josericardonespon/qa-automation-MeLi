package com.salesforce.tesa.userintefaces.salesforce;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CasoPage {
    public static final Target LABEL_CASES= Target.the("tag cases")
            .located(By.xpath("//span[text()='Casos']"));

    public static final Target COMBO_CASES= Target.the("combo cases")
            .located(By.xpath("//button[@title='Seleccionar una vista de lista: Casos']"));
    public static final Target DEMAND_CASES= Target.the("demand cases")
            .located(By.xpath("//span[text()='Demandas']"));
    public static final Target PRINCIPAL_CASE= Target.the("principal case")
            .located(By.xpath("//span[text()='00001008']"));
    public static final Target TAG_CASE= Target.the("tag principal case")
            .located(By.xpath("//lightning-formatted-text[normalize-space(.)='00001008']"));



}
