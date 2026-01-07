package com.salesforce.tesa.tasks;

import com.salesforce.tesa.interactions.*;
import com.salesforce.tesa.utils.CargarArchivoUtil;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.salesforce.tesa.userintefaces.salesforce.AcuerdosPage.INPUT_FILE;
import static com.salesforce.tesa.userintefaces.salesforce.CasoPage.*;
import static com.salesforce.tesa.userintefaces.salesforce.Global.*;
import static com.salesforce.tesa.userintefaces.salesforce.SolicitudesPage.*;

public class CrearSolicitudesTask{



    public static class IngresarCasoPreviamenteCreado implements Task {

        @Override
        @Step("{0} con rol {1} ingresa a un caso previamente creado en MELI")
        public <T extends Actor> void performAs(T actor) {
            String url_caso_meli = actor.recall("url_caso_meli");
            actor.attemptsTo(
                    NavegarUrlInteraction.navegarUrl(url_caso_meli),
                    EsperarInteraction.por(3000),
                    WaitUntil.the(NUMERO_CASO, WebElementStateMatchers.isVisible())
                            .forNoMoreThan(60).seconds()
            );
        }
    }

    public static class CrearNuevaSolicitud implements Task {

        private String tipoSolicitud;
        private final String rutaArchivo = CargarArchivoUtil.obtenerRutaArchivo("PRUEBA.txt");

        public CrearNuevaSolicitud(String tipoSolicitud) {
            this.tipoSolicitud = tipoSolicitud;
        }

        private <T extends Actor> void crearSolicitudBase(T actor, Target radioButton) {
            actor.attemptsTo(
                    HacerClickInteraction.on(BTN_NUEVA_SOLICITUD).withOptions(30, true),
                    HacerClickInteraction.on(radioButton).withOptions(30, true),
                    HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, true)

            );
        }

        @Override
        @Step("{0} crea una nueva solicitud de tipo {1}")
        public <T extends Actor> void performAs(T actor) {

            switch (tipoSolicitud.toLowerCase()) {
                case "corrección registro":
                    crearSolicitudBase(actor, RADIO_CORRECCION_RG);
                    actor.attemptsTo(
                            HacerClickInteraction.on(COMBO_OPCION_NUEVA_SOLICITUD).withOptions(30, false),
                            HacerClickInteraction.on(COMBO_OPCION_SI).withOptions(30, false),
                            HacerScrollInteraction.to(OPCION_AREA_INTERNA_MELI),
                            HacerClickInteraction.on(OPCION_AREA_INTERNA_MELI).withOptions(30, false),
                            HacerClickConControlInteraction.on(OPCION_ESTUDIO_EXTERNO_RESP_INT).withOptions(30),
                            InsertarInteraction.theValue("TEST AUTOMATIZADO").into(INPUT_CAMPOS_A_CORREGIR).withOptions(30, true),
                            HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, true),
                            EsperarInteraction.por(4000),
                            CargarArchivoInteraction.from(rutaArchivo, INPUT_FILE),
                            HacerClickInteraction.on(BTN_ARCHIVO_LISTO).withOptions(30, true),
                            HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, true),
                            //HacerClickInteraction.on(LINK_NUEVA_SOLICITUD.of(tipoSolicitud)).withOptions(30, true),
                            HacerClickInteraction.on(BUTTON_FINALIZAR).withOptions(30, true)
                    );
                    break;

                case "complementación información":
                    crearSolicitudBase(actor, RADIO_COMPLEMENTACION_INF);

                    break;

                case "actuación":
                    crearSolicitudBase(actor, RADIO_ACTUACION);

                    break;
                case "validación escritos":
                    crearSolicitudBase(actor, RADIO_VALIDACION_ESCRITOS);

                    break;
                    /*
                case "pericia":
                    crearEventoBase(actor, RADIO_PERICIA);
                    actor.attemptsTo(
                            InsertarInteraction.theValue("PRUEBA, AUTOMATIZADA").into(PERITO_DE_LA_AUTORIDAD).withOptions(true),
                            InsertarInteraction.theValue("PRUEBA, ABOGADO").into(PERITO_TECNICO).withOptions(true),
                            HacerClickInteraction.on(OPTION_FAVORABLE_MELI_PERICIA).withOptions(30, false),
                            HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, false),
                            CargarArchivoInteraction.from(rutaArchivo, INPUT_FILE),
                            EsperarInteraction.por(4000),
                            HacerClickInteraction.on(BTN_ARCHIVO_LISTO).withOptions(30, true),
                            HacerClickInteraction.on(BUTTON_GUARDAR).withOptions(30, true)
                    );
                    break;
                case "recurso":
                    crearEventoBase(actor, RADIO_RECURSO);
                    actor.attemptsTo(
                            HacerClickInteraction.on(COMBO_ACTOR_RECURSO).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_MELI).withOptions(30, false),
                            HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, false),
                            CargarArchivoInteraction.from(rutaArchivo, INPUT_FILE),
                            HacerClickInteraction.on(BTN_ARCHIVO_LISTO).withOptions(30, true),
                            EsperarInteraction.por(4000),
                            HacerClickInteraction.on(BUTTON_GUARDAR).withOptions(30, true)
                    );
                    break;

                     */

                default:
                    throw new IllegalArgumentException("Tipo de Solicitud no reconocido: " + tipoSolicitud);
            }
        }
    }

        public static class VisualizarSolicitudCreada implements Task {

            private String tipoSolicitud;

            public VisualizarSolicitudCreada(String tipoSolicitud) {
                this.tipoSolicitud = tipoSolicitud;
            }

            @Override
            @Step("{0} visualiza la solicitud de tipo {1} creada exitosamente")
            public <T extends Actor> void performAs(T actor) {
                String nombreTareaABuscar;

                if ("Corrección Registro".equalsIgnoreCase(tipoSolicitud)) {
                    nombreTareaABuscar = "Ajuste de Registro";
                    System.out.println("▶ Tipo: Corrección de Registro → Buscando tarea: Ajuste de Registro");
                } else {
                    nombreTareaABuscar = tipoSolicitud;
                    System.out.println("▶ Buscando tarea: " + nombreTareaABuscar);
                }

                actor.attemptsTo(
                        EsperarInteraction.por(2000),
                        WaitUntil.the(TAREA_POR_TITULO.of(nombreTareaABuscar), WebElementStateMatchers.isVisible())
                                .forNoMoreThan(30).seconds(),
                        HacerClickInteraction.on(TAREA_POR_TITULO.of(nombreTareaABuscar)).withOptions(30, true),
                        WaitUntil.the(LABEL_SOLICITUD_COMPLETA, WebElementStateMatchers.isVisible())
                                .forNoMoreThan(30).seconds(),
                        ObtenerUrlInteraction.obtenerUrl("url_solicitud_creada"),
                        ObtenerTextoInteraction.desde(USUARIO_ASIGNADO_A, "usuario_asignado", 10)

                );
                String usuario_asignado = actor.recall("usuario_asignado");
                System.out.println("▶ Usuario Asignado a solicitud: " + usuario_asignado);


            }
        }

        public static Task ingresarCasoPreviamenteCreado() {
            return Tasks.instrumented(IngresarCasoPreviamenteCreado.class);
        }

        public static Task crearNuevaSolicitud(String tipoSolicitud) {
            return Tasks.instrumented(CrearNuevaSolicitud.class, tipoSolicitud);
        }

        public static Task visualizarSolicitudCreada(String tipoSolicitud) {
            return Tasks.instrumented(VisualizarSolicitudCreada.class, tipoSolicitud);
        }
    }


