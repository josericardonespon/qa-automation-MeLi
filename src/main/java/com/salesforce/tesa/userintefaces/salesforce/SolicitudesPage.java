package com.salesforce.tesa.userintefaces.salesforce;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SolicitudesPage {

    public static final Target BTN_NUEVA_SOLICITUD = Target.the("botón Nueva Solicitud")
            .located(By.xpath("//button[@name='Case.ML_NewTask']"));
    public static final Target RADIO_CORRECCION_RG = Target.the("Radio solicitud corrección de registro")
            .located(By.xpath("//label[.//span[contains(text(),'Corrección Registro')]]"));
    public static final Target RADIO_COMPLEMENTACION_INF = Target.the("Radio solicitud Complementación información")
            .located(By.xpath("//label[.//span[contains(text(),'Complementación información')]]"));
    public static final Target RADIO_ACTUACION = Target.the("Radio solicitud Actuación")
            .located(By.xpath("//label[.//span[contains(text(),'Actuación')]]"));
    public static final Target RADIO_VALIDACION_ESCRITOS = Target.the("Radio solicitud Validación escritos")
            .located(By.xpath("//label[.//span[contains(text(),'Validación escritos')]]"));
    public static final Target COMBO_OPCION_NUEVA_SOLICITUD = Target.the("opción Nueva Solicitud")
            .located(By.xpath("//select[@name='NewOrREiteration']/option[@value='PCS_NuevaOrReiteracion.Nueva Solicitud']"));
    public static final Target COMBO_OPCION_SI = Target.the("opción Sí")
            .located(By.xpath("//select[@name='SpecificField']/option[@value='PCS_SpecificField.Sí']"));
    public static final Target OPCION_AREA_INTERNA_MELI = Target.the("opción Área interna de MELI")
            .located(By.xpath("//select[@name='Campos_a_corregir']/option[@value='PCS_CamposCorregir.Área interna de MELI']"));
    public static final Target OPCION_ESTUDIO_EXTERNO_RESP_INT = Target.the("opción Estudio externo Responsables internos")
            .located(By.xpath("//select[@name='Campos_a_corregir']/option[@value='PCS_CamposCorregir.Estudio externo Responsables internos']"));
    public static final Target INPUT_CAMPOS_A_CORREGIR = Target.the("Text campos a corregir")
            .located(By.xpath("(//textarea[@part='textarea' and @class='slds-textarea'])[1]"));
    public static final Target LINK_NUEVA_SOLICITUD = Target.the("enlace a la nueva tarea '{0}'")
            .locatedBy("//a[normalize-space(text())='{0}']");
    public static final Target USUARIO_ASIGNADO_A = Target.the("usuario Asignado a")
            .located(By.xpath("(//div[@data-target-selection-name='sfdc:RecordField.Task.OwnerId']//span[contains(@class,'forceOutputLookup')])[1]"));
    public static final Target TAREA_POR_TITULO = Target.the("tarea '{0}'")
            .locatedBy("//a[@title='{0}' and contains(@class,'subjectLink')]");
    public static final Target TAREA_AJUSTE_REGISTRO = Target.the("tarea Ajuste de Registro")
            .located(By.xpath("//a[@title='Ajuste de Registro' and contains(@class,'subjectLink')]"));
    public static final Target LABEL_SOLICITUD_COMPLETA = Target.the("label ¿Solicitud completa?")
            .located(By.xpath("//span[contains(@class,'test-id__field-label') and text()='¿Solicitud completa?']"));
    public static final Target BOTON_MODIFICAR_SOLICITUD_COMPLETA = Target.the("botón modificar Solicitud Completa")
            .located(By.xpath("//button[@title='Modificar ¿Solicitud completa?']"));
    public static final Target COMBOBOX_SOLICITUD_COMPLETA = Target.the("combobox Solicitud Completa")
            .located(By.xpath("//a[@role='combobox' and text()='--Ninguno--']"));
    public static final Target OPTION_SI_SOLICITUD_COMPLETA = Target.the("opción Sí Solicitud Completa")
            .located(By.xpath("//li[@role='presentation']//a[text()='Sí']"));
    public static final Target CHECKBOX_COMPLETADO = Target.the("checkbox Completado")
            .located(By.xpath("//label[.//span[text()='Completado']]/following-sibling::input[@type='checkbox']"));
    public static final Target TXT_INFORMACION_FALTANTE = Target.the("textarea de información faltante")
            .located(By.xpath("//textarea[@role='textbox' and contains(@class,'textarea')]"));
    public static final Target ESTADO_TAREA = Target.the("Estado actual de la tarea")
            .locatedBy("//div[@data-target-selection-name='sfdc:RecordField.Task.Status']//span[contains(@class,'test-id__field-value')]//span");
    public static final Target OPTION_NO_SOLICITUD_COMPLETA = Target.the("opción Sí Solicitud Completa")
            .located(By.xpath("//li[@role='presentation']//a[text()='No']"));

}
