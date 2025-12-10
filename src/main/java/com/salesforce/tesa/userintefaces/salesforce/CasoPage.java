package com.salesforce.tesa.userintefaces.salesforce;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CasoPage {

    public static final Target LABEL_CASES = Target.the("tag cases")
            .located(By.xpath("//span[text()='Casos']"));

    public static final Target COMBO_CASES = Target.the("combo cases")
            .located(By.xpath("//button[@title='Seleccionar una vista de lista: Casos']"));

    public static final Target DEMAND_CASES = Target.the("demand cases")
            .located(By.xpath("//span[text()='Demandas']"));

    public static final Target PRINCIPAL_CASE_QA = Target.the("principal case")
            .located(By.xpath("//span[text()='00001008']"));

    public static final Target TAG_CASE_QA = Target.the("tag principal case")
            .located(By.xpath("//span[contains(@class,'test-id__field-value')]//*[contains(text(),'00001008')]"));

    public static final Target PRINCIPAL_CASE_UAT = Target.the("principal case")
            .located(By.xpath("//span[text()='00001066']"));

    public static final Target TAG_CASE_UAT = Target.the("tag principal case")
            .located(By.xpath("//span[contains(@class,'test-id__field-value')]//*[contains(text(),'00001066')]"));

    public static final Target BTN_NUEVO_CASO = Target.the("Botón Nuevo caso")
            .located(By.xpath("//div[@title='Nuevo caso']"));

    public static final Target IFRAME_NUEVO_CASO = Target.the("Botón Nuevo caso")
            .located(By.xpath("//iframe[@title='accessibility title']"));

    public static final Target COMBO_TIPO_DOCUMENTO = Target.the("Combo Tipo de documento")
            .located(By.xpath("//select[@name='ML_IncomingDocumentType']"));

    public static final Target OPCION_TIPO_DOCUMENTO = Target.the("Opción Demanda del Tipo de Documento")
            .located(By.xpath("//option[@value='ML_IncomingDocumentTypePicklist.Demanda']"));

    public static final Target INPUT_NUMERO_EXPEDIENTE = Target.the("Campo Número Expediente")
            .located(By.xpath("//input[@name='ML_LegalNumber']"));

    public static final Target INPUT_CARATULA = Target.the("Campo Caratula")
            .located(By.xpath("//input[@name='ML_CaseTitleBR']"));

    public static final Target INPUT_FECHA_RECEPCION = Target.the("Campo Fecha de Recepción")
            .located(By.xpath("//input[@name='ML_ReceptionDate']"));

    public static final Target INPUT_FECHA_ANTE_AUTORIDAD = Target.the("Campo Fecha ante la autoridad")
            .located(By.xpath("//input[@name='ML_StartDateBeforeAuthority']"));

    public static final Target INPUT_FECHA_CONOCIMIENTO_DEMANDADO = Target.the("Campo Fecha de Conocimiento por el demandado")
            .located(By.xpath("//input[@name='ML_DefendantAwarenessDate']"));

    public static final Target INPUT_FECHA_ENVIO_ESTUDIO = Target.the("Campo Fecha de Envío al estudio")
            .located(By.xpath("//input[@name='ML_SentToLawFirmDate']"));

    public static final Target COMBO_PAIS = Target.the("Combobox de País")
            .located(By.xpath("//button[@name='country' and @role='combobox']"));

    public static final Target COMBO_PAIS_ARGENTINA = Target.the("Combo país con Argentina seleccionada")
            .located(By.xpath("//lightning-base-combobox-item//span[@title='Argentina']"));

    public static final Target COMBO_ESTADO = Target.the("Combobox Seleccioná un estado")
            .located(By.xpath("//span[@class='slds-truncate' and normalize-space()='Seleccioná un estado']"));

    public static final Target OPCION_ESTADO = Target.the("Opción Buenos Aires del combobox Estado")
            .located(By.xpath("//span[@title='Buenos Aires' and not(ancestor::button)]"));

    public static final Target INPUT_MUNICIPIO = Target.the("Campo Ingresá el municipio")
            .located(By.xpath("//input[@placeholder='Ingresá el municipio…']"));

    public static final Target OPCION_MUNICIPIO = Target.the("Opción San Fernando")
            .located(By.xpath("//span[@class='slds-truncate' and normalize-space()='San Fernando' and not(ancestor::button)]"));

    public static final Target INPUT_CIUDAD = Target.the("Campo Ingresá la ciudad")
            .located(By.xpath("//input[@placeholder='Ingresá la ciudad…']"));

    public static final Target OPCION_CIUDAD = Target.the("Opción Victoria")
            .located(By.xpath("//span[@class='slds-truncate' and normalize-space()='Victoria' and not(ancestor::button)]"));

    public static final Target COMBO_JUSTICIA = Target.the("Combobox de Justicia")
            .located(By.xpath("//button[@name='justice' and @role='combobox']"));

    public static final Target OPCION_JUSTICIA_ADMINISTRATIVA = Target.the("Opción Administrativa del combobox Justicia")
            .located(By.xpath("//lightning-base-combobox-item[@data-value='Administrativa' and not(ancestor::button)]"));

    public static final Target INPUT_AUTORIDAD = Target.the("Campo Ingresá la autoridad")
            .located(By.xpath("//input[@placeholder='Ingresá la autoridad…']"));

    public static final Target OPCION_AUTORIDAD_RIO_CUARTO = Target.the("Opción Municipalidad de Rio Cuarto")
            .located(By.xpath("//span[@class='slds-truncate' and normalize-space()='Municipalidad de Rio Cuarto' and not(ancestor::button)]"));

    public static final Target INPUT_BUSCAR_EMPRESA = Target.the("Campo Buscar empresa")
            .located(By.xpath("//input[@placeholder='Buscar empresa…']"));

    public static final Target OPCION_MERCADO_PAGO =
            Target.the("Opción Mercado Pago")
                    .located(By.xpath("(//span[@class='slds-truncate' and @title='Mercado Pago Asset Management S.A.'])[1]"));

    public static final Target COMBO_ROL_EMPRESA = Target.the("Combo Rol de la empresa")
            .located(By.xpath("//select[@name='ML_MercadoLibreCompany[0]__Role']"));

    public static final Target OPCION_ROL = Target.the("Opción Demandante del Rol")
            .located(By.xpath("//option[normalize-space(text())='Demandante' and not(ancestor::button)]"));

    public static final Target COMBO_TIPO_DOCUMENTO_PARTES_CONTRARIAS = Target.the("Combo Tipo de documento de partes contrarias")
            .located(By.xpath("//span[@class='slds-truncate' and normalize-space()='Seleccione una opción']"));

    public static final Target OPTION_TIPO_IDENTIFICACION_DNI = Target.the("Opción DNI del combobox")
            .located(By.xpath("//span[@title='DNI' and normalize-space()='DNI' and not(ancestor::button)]"));

    public static final Target INPUT_NUMERO_DOCUMENTO_PARTE_CONTRARIA = Target.the("Campo número de documento")
            .located(By.xpath("//input[@placeholder='Escribí el número de documento…']"));

    public static final Target OPCION_DOCUMENTO_PTE_CONT = Target.the("Primer resultado del lookup")
            .locatedBy("(//ul[@role='listbox']//li[@role='option'])[1]");


    public static final Target INPUT_NOMBRE_PARTE_CONTRARIA = Target.the("Campo Nombre de Parte Contraria")
            .located(By.xpath("//input[@name='PartesContarias[0]__ML_NamePartyCounter']"));

    public static final Target COMBO_ROL_PARTE_CONTRARIA = Target.the("Combo Rol de Parte Contraria")
            .located(By.xpath("//select[@name='PartesContarias[0]__ML_Role']"));

    public static final Target OPTION_ROL_PARTE_CONTRARIA = Target.the("Opción Rol No involucrado")
            .located(By.xpath("//option[@value='ML_RolPicklist.No involucrado']"));

    public static final Target COMBO_TIENE_ABOGADO = Target.the("Combo Tiene Abogado")
            .located(By.xpath("//select[@name='ML_HasLawyer']"));

    public static final Target OPTION_ABOGADO_SI = Target.the("Opción Sí en Tiene Abogado")
            .located(By.xpath("//select[@name='ML_HasLawyer']//option[@value='ML_HasLawyerPicklist.Sí']"));

    public static final Target INPUT_NOMBRE_ABOGADO = Target.the("Campo Nombre del Abogado")
            .located(By.xpath("//input[@name='Lawyer[0]__ML_LawyerName']"));

    public static final Target INPUT_MATRICULA_ABOGADO = Target.the("Campo Matrícula del Abogado")
            .located(By.xpath("//input[@name='Lawyer[0]__ML_LawyerLicense']"));

    public static final Target INPUT_ESTUDIO_JURIDICO = Target.the("Campo Estudio Jurídico del Abogado")
            .located(By.xpath("//input[@name='Lawyer[0]__ML_LawFirm']"));

    public static final Target COMBO_TIENE_OTRAS_PARTES = Target.the("Combo Tiene Otras Partes")
            .located(By.xpath("//select[@name='ML_HasOtherParties']"));

    public static final Target OPTION_OTRAS_PARTES_SI = Target.the("Opción Sí en Tiene Otras Partes")
            .located(By.xpath("//select[@name='ML_HasOtherParties']//option[@value='ML_HasLawyerPicklist.Sí']"));

    public static final Target OPTION_OTRAS_PARTES_NO = Target.the("Opción No en Tiene Otras Partes")
            .located(By.xpath("//select[@name='ML_HasOtherParties']//option[@value='ML_HasLawyerPicklist.No']"));

    public static final Target COMBO_TIPO_DOC_OTRA_PTE_CONT = Target.the("Segunda Combobox Tipo de Documento parte contraria")
            .located(By.xpath("(//button[@role='combobox' and @aria-label='Tipo de documento'])[2]"));

    public static final Target OPTION_DNI_COMBO_OTRA_PTE_CONT = Target.the("Opción DNI del segundo combo 'Tipo de documento'")
            .located(By.xpath("(//button[@role='combobox' and @aria-label='Tipo de documento'])[2]" +
                    "    /following::lightning-base-combobox-item[.//span[@title='DNI']][1]"));

    public static final Target INPUT_NUMERO_DOCUMENTO_OTRA_PRT_CONT = Target.the("Campo número de documento otra parte contraria")
            .located(By.xpath("(//input[@placeholder='Escribí el número de documento…'])[2]"));

    public static final Target OPCION_DOC_OTRA_PTE_CONT = Target.the("Campo número de documento otra parte contraria")
            .located(By.xpath("(//ul[@role='listbox']//li[@role='option'])"));


    public static final Target INPUT_NOMBRE_OTRA_PARTE = Target.the("Campo Nombre de Otra Parte")
            .located(By.xpath("//input[@name='Ml_OtherPartys[0]__ML_NameOtherPartys']"));

    public static final Target COMBO_ROL_OTRA_PARTE = Target.the("Combo Rol de Otra Parte")
            .located(By.xpath("//select[@name='Ml_OtherPartys[0]__Rol']"));

    public static final Target OPTION_ROL_OTRA_PARTE_INTERESADO = Target.the("Opción Interesado (Otra Parte)")
            .located(By.xpath("//select[@name='Ml_OtherPartys[0]__Rol']//option[@value='ML_RolPicklist.Interesado']"));

    public static final Target COMBO_AREA_DERECHO = Target.the("Combobox Área de Derecho")
            .located(By.xpath("//button[@name='lawArea' and @role='combobox' and @aria-label='Área de derecho']"));

    public static final Target OPTION_AREA_DERECHO_CIVIL = Target.the("Opción Civil del combobox Área de Derecho")
            .located(By.xpath("//span[@title='Civil' and not(ancestor::button)]"));

    public static final Target COMBO_SUBAREA_DERECHO = Target.the("Combobox de Subárea de derecho")
            .located(By.xpath("//button[@name='lawSubArea' and @role='combobox']"));

    public static final Target OPTION_SUBAREA_JUDICIAL = Target.the("Opción Judicial del combo Subárea de derecho")
            .located(By.xpath("//span[@title='Judicial' and not(ancestor::button)]"));

    public static final Target COMBO_TIPO_ACCION = Target.the("Combobox Tipo de acción")
            .located(By.xpath("//button[@name='actionType' and @role='combobox']"));

    public static final Target OPTION_TIPO_ACCION_EJECUCION_FISCAL = Target.the("Opción Ejecución fiscal del combobox Tipo de acción")
            .located(By.xpath("//lightning-base-combobox-item[.//span[@title='Ejecución fiscal'] and not(ancestor::button)]"));

    public static final Target COMBO_TIPO_PROCEDIMIENTO = Target.the("Combobox Tipo de procedimiento")
            .located(By.xpath("//button[@name='procedureType' and @role='combobox']"));

    public static final Target OPTION_TIPO_PROCEDIMIENTO_ORDINARIO = Target.the("Opción Ordinario del Tipo de Procedimiento")
            .located(By.xpath("//lightning-base-combobox-item[@data-value='Ordinario' and not(ancestor::button)]"));

    public static final Target COMBO_UNIDAD_NEGOCIO = Target.the("Combo Unidad de negocio")
            .located(By.xpath("(//div[@class='slds-select_container']/select[@class='slds-select'])[1]"));

    public static final Target OPTION_MARKETPLACE = Target.the("Opción Marketplace dentro del combo Área de negocio")
            .located(By.xpath("//option[@value='Marketplace']"));

    public static final Target COMBO_OBJETO = Target.the("Combo objeto")
            .located(By.xpath("(//div[@class='slds-select_container']/select[@class='slds-select'])[2]"));

    public static final Target OPTION_OBJETO_DATOS_PERSONALES = Target.the("Opción Datos personales")
            .located(By.xpath("//option[@value='Datos personales']"));

    public static final Target COMBO_CAUSA_RAIZ = Target.the("Combo Causa")
            .located(By.xpath("(//div[@class='slds-select_container']/select[@class='slds-select'])[3]"));

    public static final Target OPTION_CAUSA_RAIZ = Target.the("Opción Causa")
            .located(By.xpath("//option[@value='Información, modificación o eliminación de sus datos']"));

    public static final Target COMBO_OBJETO_Y_CAUSA= Target.the("Combo Objeto y Causa")
            .located(By.xpath("(//div[@class='slds-select_container']/select[@class='slds-select'])[4]"));

    public static final Target OPTION_OBJETO_CAUSA = Target.the("Opción Objeto y Causa")
            .located(By.xpath("//option[@value='ML_HasLawyerPicklist.Sí']"));

    public static final Target COMBO_RUBRO = Target.the("Combobox Rubro")
            .located(By.xpath("//button[@name='category' and @role='combobox']"));

    public static final Target OPTION_RUBRO_DANO_MATERIAL = Target.the("Opción Rubro Daño material")
            .located(By.xpath("//lightning-base-combobox-item[.//span[@title='Daño material'] and not(ancestor::button)]"));

    public static final Target INPUT_VALOR_INICIAL = Target.the("Campo Valor inicial")
            .located(By.xpath("//input[@name='initialValue']"));

    public static final Target COMBO_EMPRESA_RUBRO = Target.the("Combobox Empresa relacionada al Rubro")
            .located(By.xpath("//button[@name='company' and @role='combobox']"));

    public static final Target OPTION_EMPRESA = Target.the("Opción empresa en combobox Rubro")
            .locatedBy("//span[@title='{0}']");

    public static final Target COMBO_VALOR_RECLAMADO= Target.the("Combobox Valor reclamado igual al valor de la causa")
            .located(By.xpath("//button[@role='combobox' and @aria-label='Valor reclamado igual al valor de la causa?']"));

    public static final Target OPTION_VALOR_RECLAMADO_SI = Target.the("Opción Sí del combo Valor reclamado igual al valor de la causa")
            .located(By.xpath(
                            "//button[@aria-label='Valor reclamado igual al valor de la causa?']" +
                                    "/following::lightning-base-combobox-item[.//span[@title='Sí']][1]"));

    public static final Target COMBO_CASO_RELACIONADO = Target.the("Combo Caso relacionado")
            .located(By.xpath("//button[@name='duplicateSelector' and @role='combobox']"));

    public static final Target OPCION_CASO_RELACIONADO = Target.the("Opcion caso relacionado")
            .located(By.xpath("//lightning-base-combobox-item[@role='option']"));

    public static final Target LINK_IR_AL_CASO = Target.the("Link Ir al caso")
            .located(By.xpath("//a[normalize-space(text())='Ir al caso']"));

}
