package com.salesforce.tesa.tasks;

import com.salesforce.tesa.interactions.*;
import com.salesforce.tesa.utils.CargarArchivoUtil;
import com.salesforce.tesa.utils.FechaUtil;
import com.salesforce.tesa.utils.Users;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitOnQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;
import java.util.Random;

import java.time.Duration;

import static com.salesforce.tesa.userintefaces.InicioSesionPage.IFRAME_LOGIN_AS;
import static com.salesforce.tesa.userintefaces.salesforce.AcuerdosPage.INPUT_FILE;
import static com.salesforce.tesa.userintefaces.salesforce.CasoPage.*;
import static com.salesforce.tesa.userintefaces.salesforce.Global.*;
import static com.salesforce.tesa.utils.Constants.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class CrearCasoTask {

    public static class AbrirCasos implements Task {
        @Override
        @Step("{0} abre la sección de Casos en MeLi")
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    HacerClickInteraction.on(LABEL_CASES).withOptions(30, true)
            );
        }
    }

    public static class SeleccionarVistaDemandas implements Task {
        @Override
        @Step("{0} selecciona la vista de Demandas en la lista de Casos")
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    EsperarInteraction.por(2000),
                    WaitUntil.the(COMBO_CASES, WebElementStateMatchers.isClickable()).forNoMoreThan(30).seconds(),
                    HacerClickInteraction.on(COMBO_CASES).withOptions(30, true),
                    HacerClickInteraction.on(DEMAND_CASES).withOptions(30, true)
            );
        }
    }

    public static class CrearCasos implements Task {
        private final Users users = new Users();
        private final String rutaArchivo = CargarArchivoUtil.obtenerRutaArchivo("PRUEBA.txt");
        //String numeroExpediente = String.valueOf(System.currentTimeMillis()).substring(8);
        Random rand = new Random();
        String numeroExpediente = String.format("%08d", rand.nextInt(100000000));
        @Override
        @Step("{0} Crear caso principal en MeLi")
        public <T extends Actor> void performAs(T actor) {
            String ambiente = users.getEnvironment();
            switch (ambiente.toLowerCase()) {
                case "qa":
                    actor.attemptsTo(
                            EsperarInteraction.por(2000),
                            HacerClickInteraction.on(BTN_NUEVO_CASO).withOptions(30, true),
                            //WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(java.time.Duration.ofSeconds(30)),
                            Switch.toFrame(IFRAME_NUEVO_CASO.resolveFor(actor)),
                            HacerClickInteraction.on(COMBO_TIPO_DOCUMENTO).withOptions(30, false),
                            HacerClickInteraction.on(OPCION_TIPO_DOCUMENTO).withOptions(30, false),
                            InsertarInteraction.theValue(numeroExpediente).into(INPUT_NUMERO_EXPEDIENTE).withOptions(30, true),
                            InsertarInteraction.theValue("Cierre Sucursal").into(INPUT_CARATULA).withOptions(30, true),
                            EscribirFechaInteraction.en(INPUT_FECHA_RECEPCION, FechaUtil.obtenerFechaPosterior(3)),
                            EscribirFechaInteraction.en(INPUT_FECHA_ANTE_AUTORIDAD, FechaUtil.obtenerFechaPosterior(3)),
                            EscribirFechaInteraction.en(INPUT_FECHA_CONOCIMIENTO_DEMANDADO, FechaUtil.obtenerFechaPosterior(3)),
                            EscribirFechaInteraction.en(INPUT_FECHA_ENVIO_ESTUDIO, FechaUtil.obtenerFechaPosterior(4)),
                            HacerScrollInteraction.to(COMBO_PAIS),
                            HacerClickInteraction.on(COMBO_PAIS).withOptions(30, false),
                            HacerClickInteraction.on(COMBO_PAIS_ARGENTINA).withOptions(30, false),
                            HacerClickInteraction.on(COMBO_ESTADO).withOptions(30, true),
                            HacerClickInteraction.on(OPCION_ESTADO).withOptions(30, true),
                            InsertarInteraction.theValue("San Fernando").into(INPUT_MUNICIPIO).withOptions(30, true),
                            HacerClickInteraction.on(OPCION_MUNICIPIO).withOptions(30, true),
                            InsertarInteraction.theValue("Victoria").into(INPUT_CIUDAD).withOptions(30, true),
                            HacerClickInteraction.on(OPCION_CIUDAD).withOptions(30, true),
                            HacerClickInteraction.on(COMBO_JUSTICIA).withOptions(30, true),
                            HacerClickInteraction.on(OPCION_JUSTICIA_ADMINISTRATIVA).withOptions(30,true),
                            InsertarInteraction.theValue("Municipalidad de Rio Cuarto").into(INPUT_AUTORIDAD).withOptions(30,true),
                            HacerClickInteraction.on(OPCION_AUTORIDAD_RIO_CUARTO).withOptions(30, true),
                            InsertarInteraction.theValue(EMPRESA).into(INPUT_BUSCAR_EMPRESA).withOptions(30,true),
                            HacerClickInteraction.on(COMBO_ROL_EMPRESA).withOptions(30, true),
                            HacerClickInteraction.on(OPCION_ROL).withOptions(30, false),
                            HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, false),
                            EsperarInteraction.por(4000),
                            WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(java.time.Duration.ofSeconds(30)),
                            HacerClickInteraction.on(COMBO_TIPO_DOCUMENTO_PARTES_CONTRARIAS).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_TIPO_IDENTIFICACION_DNI).withOptions(30, false),
                            InsertarInteraction.theValue("18798777").into(INPUT_NUMERO_DOCUMENTO_PARTE_CONTRARIA).withOptions(30, true),
                            HacerClickInteraction.on(OPCION_DOCUMENTO_PTE_CONT).withOptions(30, true),
                            HacerScrollInteraction.to(COMBO_TIENE_ABOGADO),
                            HacerClickInteraction.on(COMBO_TIENE_ABOGADO).withOptions(30,false),
                            HacerClickInteraction.on(OPTION_ABOGADO_SI).withOptions(30,false),
                            InsertarInteraction.theValue("ANGELES, PEDRO").into(INPUT_NOMBRE_ABOGADO).withOptions(30,true),
                            InsertarInteraction.theValue("312312TES").into(INPUT_MATRICULA_ABOGADO).withOptions(30,true),
                            InsertarInteraction.theValue("NUS").into(INPUT_ESTUDIO_JURIDICO).withOptions(30,true),
                            HacerScrollInteraction.to(COMBO_TIENE_OTRAS_PARTES),
                            HacerClickInteraction.on(COMBO_TIENE_OTRAS_PARTES).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_OTRAS_PARTES_SI).withOptions(30,false),
                            HacerClickInteraction.on(COMBO_TIPO_DOC_OTRA_PTE_CONT).withOptions(30,true),
                            HacerClickInteraction.on(OPTION_DNI_COMBO_OTRA_PTE_CONT).withOptions(30,true),
                            InsertarInteraction.theValue("38479345").into(INPUT_NUMERO_DOCUMENTO_OTRA_PRT_CONT).withOptions(30, true),
                            HacerClickInteraction.on(OPCION_DOC_OTRA_PTE_CONT).withOptions(30, true),
                            HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, true),
                            EsperarInteraction.por(2000),
                            //WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(java.time.Duration.ofSeconds(30)),
                            HacerClickInteraction.on(COMBO_CASO_RELACIONADO).withOptions(30, false),
                            HacerClickInteraction.on(OPCION_CASO_RELACIONADO).withOptions(30, false),
                            HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, true),
                            EsperarInteraction.por(2000),
                            //WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(java.time.Duration.ofSeconds(30)),
                            HacerClickInteraction.on(COMBO_AREA_DERECHO).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_AREA_DERECHO_CIVIL).withOptions(30, false),
                            HacerClickInteraction.on(COMBO_SUBAREA_DERECHO).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_SUBAREA_JUDICIAL).withOptions(30, false),
                            HacerClickInteraction.on(COMBO_TIPO_ACCION).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_TIPO_ACCION_EJECUCION_FISCAL).withOptions(30, false),
                            HacerClickInteraction.on(COMBO_TIPO_PROCEDIMIENTO).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_TIPO_PROCEDIMIENTO_ORDINARIO).withOptions(30, false),
                            HacerClickInteraction.on(COMBO_UNIDAD_NEGOCIO).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_MARKETPLACE).withOptions(30, false),
                            HacerClickInteraction.on(COMBO_OBJETO).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_OBJETO_DATOS_PERSONALES).withOptions(30, false),
                            HacerClickInteraction.on(COMBO_CAUSA_RAIZ).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_CAUSA_RAIZ).withOptions(30, false),
                            HacerScrollInteraction.to(COMBO_OBJETO_Y_CAUSA),
                            HacerClickInteraction.on(COMBO_OBJETO_Y_CAUSA).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_OBJETO_CAUSA).withOptions(30, false),
                            HacerClickInteraction.on(COMBO_RUBRO).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_RUBRO_DANO_MATERIAL).withOptions(30, false),
                            InsertarInteraction.theValue("100000").into(INPUT_VALOR_INICIAL).withOptions(30, true),
                            HacerClickInteraction.on(COMBO_EMPRESA_RUBRO).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_EMPRESA.of(EMPRESA)).withOptions(30, false),
                            HacerClickInteraction.on(COMBO_VALOR_RECLAMADO).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_VALOR_RECLAMADO_SI).withOptions(30, false),
                            HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, true),
                            EsperarInteraction.por(2000),
                            //WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(java.time.Duration.ofSeconds(30)),
                            CargarArchivoInteraction.from(rutaArchivo, INPUT_FILE),
                            HacerClickInteraction.on(BTN_ARCHIVO_LISTO).withOptions(30, true),
                            EsperarInteraction.por(2000),
                            HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, true)

                    );
                    break;
                case "uat":
                    actor.attemptsTo(
                            EsperarInteraction.por(4000),
                            HacerClickInteraction.on(BTN_NUEVO_CASO).withOptions(30, true),
                            //WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(java.time.Duration.ofSeconds(30)),
                            Switch.toFrame(IFRAME_NUEVO_CASO.resolveFor(actor)),
                            HacerClickInteraction.on(COMBO_TIPO_DOCUMENTO).withOptions(30, false),
                            HacerClickInteraction.on(OPCION_TIPO_DOCUMENTO).withOptions(30, false),
                            InsertarInteraction.theValue(numeroExpediente).into(INPUT_NUMERO_EXPEDIENTE).withOptions(30, true),
                            InsertarInteraction.theValue("Cierre Sucursal").into(INPUT_CARATULA).withOptions(30, true),
                            EscribirFechaInteraction.en(INPUT_FECHA_RECEPCION, FechaUtil.obtenerFechaPosterior(3)),
                            EscribirFechaInteraction.en(INPUT_FECHA_ANTE_AUTORIDAD, FechaUtil.obtenerFechaPosterior(3)),
                            EscribirFechaInteraction.en(INPUT_FECHA_CONOCIMIENTO_DEMANDADO, FechaUtil.obtenerFechaPosterior(3)),
                            EscribirFechaInteraction.en(INPUT_FECHA_ENVIO_ESTUDIO, FechaUtil.obtenerFechaPosterior(4)),
                            HacerScrollInteraction.to(COMBO_PAIS),
                            HacerClickInteraction.on(COMBO_PAIS).withOptions(30, false),
                            HacerClickInteraction.on(COMBO_PAIS_ARGENTINA).withOptions(30, false),
                            HacerClickInteraction.on(COMBO_ESTADO).withOptions(30, true),
                            HacerClickInteraction.on(OPCION_ESTADO).withOptions(30, true),
                            InsertarInteraction.theValue("San Fernando").into(INPUT_MUNICIPIO).withOptions(30, true),
                            HacerClickInteraction.on(OPCION_MUNICIPIO).withOptions(30, true),
                            InsertarInteraction.theValue("Victoria").into(INPUT_CIUDAD).withOptions(30, true),
                            HacerClickInteraction.on(OPCION_CIUDAD).withOptions(30, true),
                            HacerClickInteraction.on(COMBO_JUSTICIA).withOptions(30, true),
                            HacerClickInteraction.on(OPCION_JUSTICIA_ADMINISTRATIVA).withOptions(30,true),
                            InsertarInteraction.theValue("Municipalidad de Rio Cuarto").into(INPUT_AUTORIDAD).withOptions(30,true),
                            HacerClickInteraction.on(OPCION_AUTORIDAD_RIO_CUARTO).withOptions(30, true),
                            EsperarInteraction.por(1000),
                            InsertarInteraction.theValue(EMPRESA).into(INPUT_BUSCAR_EMPRESA).withOptions(30,true),
                            EsperarInteraction.por(1000),
                            HacerClickInteraction.on(COMBO_ROL_EMPRESA).withOptions(30, true),
                            HacerClickInteraction.on(OPCION_ROL).withOptions(30, false),
                            HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, false),
                            EsperarInteraction.por(8000),
                            //WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(java.time.Duration.ofSeconds(60)),
                            WaitUntil.the(COMBO_TIPO_DOCUMENTO_PARTES_CONTRARIAS,isEnabled()).forNoMoreThan(Duration.ofSeconds(30)),
                            HacerClickInteraction.on(COMBO_TIPO_DOCUMENTO_PARTES_CONTRARIAS).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_TIPO_IDENTIFICACION_DNI).withOptions(30, true),
                            InsertarInteraction.theValue("38414814").into(INPUT_NUMERO_DOCUMENTO_PARTE_CONTRARIA).withOptions(30, true),
                            HacerClickInteraction.on(OPCION_DOCUMENTO_PTE_CONT).withOptions(30, true),
                            HacerScrollInteraction.to(COMBO_TIENE_ABOGADO),
                            HacerClickInteraction.on(COMBO_TIENE_ABOGADO).withOptions(30,false),
                            HacerClickInteraction.on(OPTION_ABOGADO_SI).withOptions(30,false),
                            InsertarInteraction.theValue("ANGELES, PEDRO").into(INPUT_NOMBRE_ABOGADO).withOptions(30,true),
                            InsertarInteraction.theValue("312312TES").into(INPUT_MATRICULA_ABOGADO).withOptions(30,true),
                            InsertarInteraction.theValue("NUS").into(INPUT_ESTUDIO_JURIDICO).withOptions(30,true),
                            HacerScrollInteraction.to(COMBO_TIENE_OTRAS_PARTES),
                            HacerClickInteraction.on(COMBO_TIENE_OTRAS_PARTES).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_OTRAS_PARTES_SI).withOptions(30,false),
                            HacerClickInteraction.on(COMBO_TIPO_DOC_OTRA_PTE_CONT).withOptions(30,true),
                            HacerClickInteraction.on(OPTION_DNI_COMBO_OTRA_PTE_CONT).withOptions(30,true),
                            InsertarInteraction.theValue("38101300").into(INPUT_NUMERO_DOCUMENTO_OTRA_PRT_CONT).withOptions(30, true),
                            HacerClickInteraction.on(OPCION_DOC_OTRA_PTE_CONT).withOptions(30, true),
                            /*
                            HacerScrollInteraction.to(COMBO_TIENE_OTRAS_PARTES),
                            HacerClickInteraction.on(COMBO_TIENE_OTRAS_PARTES).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_OTRAS_PARTES_NO).withOptions(30,false),
                             */
                            HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, true),
                            EsperarInteraction.por(4000),
                            //WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(java.time.Duration.ofSeconds(30)),
                            //HacerClickInteraction.on(COMBO_CASO_RELACIONADO).withOptions(30, false),
                            //HacerClickInteraction.on(OPCION_CASO_RELACIONADO).withOptions(30, false),
                            HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, true),
                            EsperarInteraction.por(2000),
                            //WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(java.time.Duration.ofSeconds(30)),
                            HacerClickInteraction.on(COMBO_AREA_DERECHO).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_AREA_DERECHO_CIVIL).withOptions(30, false),
                            HacerClickInteraction.on(COMBO_SUBAREA_DERECHO).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_SUBAREA_JUDICIAL).withOptions(30, false),
                            HacerClickInteraction.on(COMBO_TIPO_ACCION).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_TIPO_ACCION_EJECUCION_FISCAL).withOptions(30, false),
                            HacerClickInteraction.on(COMBO_TIPO_PROCEDIMIENTO).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_TIPO_PROCEDIMIENTO_ORDINARIO).withOptions(30, false),
                            HacerClickInteraction.on(COMBO_UNIDAD_NEGOCIO).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_MARKETPLACE).withOptions(30, false),
                            HacerClickInteraction.on(COMBO_OBJETO).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_OBJETO_DATOS_PERSONALES).withOptions(30, false),
                            HacerClickInteraction.on(COMBO_CAUSA_RAIZ).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_CAUSA_RAIZ).withOptions(30, false),
                            HacerScrollInteraction.to(COMBO_OBJETO_Y_CAUSA),
                            HacerClickInteraction.on(COMBO_OBJETO_Y_CAUSA).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_OBJETO_CAUSA).withOptions(30, false),
                            HacerClickInteraction.on(COMBO_RUBRO).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_RUBRO_DANO_MATERIAL).withOptions(30, false),
                            InsertarInteraction.theValue("100000").into(INPUT_VALOR_INICIAL).withOptions(30, true),
                            HacerClickInteraction.on(COMBO_EMPRESA_RUBRO).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_EMPRESA.of(EMPRESA)).withOptions(30, false),
                            HacerClickInteraction.on(COMBO_VALOR_RECLAMADO).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_VALOR_RECLAMADO_SI).withOptions(30, false),
                            HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, true),
                            EsperarInteraction.por(4000),
                            //WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(java.time.Duration.ofSeconds(30)),
                            CargarArchivoInteraction.from(rutaArchivo, INPUT_FILE),
                            EsperarInteraction.por(4000),
                            HacerClickInteraction.on(BTN_ARCHIVO_LISTO).withOptions(30, true),
                            EsperarInteraction.por(2000),
                            HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, true)

                    );
                    break;
            }

        }
    }

    public static class IngresarCasoCreado implements Task {
        @Override
        @Step("{0} ingresa al caso creado en MeLi")
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    EsperarInteraction.por(2000),
                    HacerClickInteraction.on(LINK_IR_AL_CASO).withOptions(30, true),
                    Switch.toParentFrame()
            );
        }
    }

    public static Task abrirCasos() {
        return Tasks.instrumented(AbrirCasos.class);
    }
    public static Task seleccionarVistaDemandas() {
        return Tasks.instrumented(SeleccionarVistaDemandas.class);
    }
    public static Task crearCasos() {
        return Tasks.instrumented(CrearCasos.class);
    }
    public static Task ingresarCasoCreado() {
        return Tasks.instrumented(IngresarCasoCreado.class);
    }
}
