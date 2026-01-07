package com.salesforce.tesa.userintefaces.salesforce;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Global
{
    public static final Target BUTTON_SIGUIENTE= Target.the("button Siguiente")
            .located(By.xpath("//button[normalize-space(text())='Siguiente']"));
    public static final Target BUTTON_GUARDAR= Target.the("button GUARDAR")
            .located(By.xpath("//button[normalize-space(text())='Guardar']"));
    public static final Target INPUT_FECHA_INICIO = Target.the("input start date")
            .located(By.xpath("//input[@name='StartDate']"));
    public static final Target BUTTON_NEW_EVENT= Target.the("button new event")
            .located(By.xpath("//button[normalize-space(text())='Nuevo Evento']"));
    public static final Target BTN_ARCHIVO_LISTO = Target.the("Botón de archivo listo")
            .located(By.xpath("//button[.//span[normalize-space()='Listo']]"));
    public static final Target SPINNER = Target.the("Spinner de carga")
            .located(By.xpath("//span[contains(text(), 'Cargando')]/ancestor::lightning-spinner"));
    public static final Target BUTTON_FINALIZAR= Target.the("button Finalizar")
            .located(By.xpath("//button[normalize-space(text())='Finalizar']"));
    public static final Target BTN_GUARDAR_MODIF_SOLICITUD = Target.the("botón Guardar")
            .located(By.xpath("//button[@title='Guardar']"));

}
