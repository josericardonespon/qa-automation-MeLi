package com.salesforce.tesa.tasks;

import com.salesforce.tesa.interactions.*;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.salesforce.tesa.userintefaces.salesforce.Global.*;
import static com.salesforce.tesa.userintefaces.salesforce.SolicitudesPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class ResolverSolicitudTask {

    public static class IngresarSolicitudPreviamenteCreada implements Task {

        @Override
        @Step("el usuario asignado ingresa a la solicitud previamente creada")
        public <T extends Actor> void performAs(T actor) {
            String url_solicitud_meli = actor.recall("url_solicitud_creada");
            actor.attemptsTo(
                    NavegarUrlInteraction.navegarUrl(url_solicitud_meli),
                    EsperarInteraction.por(3000),
                    WaitUntil.the(LABEL_SOLICITUD_COMPLETA, WebElementStateMatchers.isVisible())
                            .forNoMoreThan(30).seconds()
            );
        }
    }

    public static class ResolverSolicitud implements Task {

        private String tipoSolicitud;
        public ResolverSolicitud(String tipoSolicitud) {
            this.tipoSolicitud = tipoSolicitud;
        }

        @Override
        @Step("el Usuario Asignado resuelve la solicitud de tipo {string}")
        public <T extends Actor> void performAs(T actor) {

            switch (tipoSolicitud.toLowerCase()) {
                case "corrección registro":
                    actor.attemptsTo(
                            HacerClickInteraction.on(BOTON_MODIFICAR_SOLICITUD_COMPLETA).withOptions(30, false),
                            InsertarInteraction.theValue("TEST OK").into(TXT_INFORMACION_FALTANTE).withOptions(30, true),
                            HacerClickInteraction.on(COMBOBOX_SOLICITUD_COMPLETA).withOptions(30, false),
                            HacerClickInteraction.on(OPTION_NO_SOLICITUD_COMPLETA).withOptions(30, true),
                            HacerClickInteraction.on(CHECKBOX_COMPLETADO).withOptions(30, true),
                            HacerScrollInteraction.to(BTN_GUARDAR_MODIF_SOLICITUD),
                            HacerClickInteraction.on(BTN_GUARDAR_MODIF_SOLICITUD).withOptions(30, true)
                    );
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de Solicitud no reconocido: " + tipoSolicitud);
            }
        }
    }

    public static class ValidarSolicitudCompletada implements Task {

        @Override
        @Step("la solicitud se resuelve exitosamente")
        public <T extends Actor> void performAs(T actor) {
            String estadoSolicitud;
            actor.attemptsTo(
                    //NavegarUrlInteraction.navegarUrl(url_solicitud_meli),
                    EsperarInteraction.por(3000),
                    WaitUntil.the(ESTADO_TAREA, WebElementStateMatchers.isVisible())
                            .forNoMoreThan(30).seconds()
                    //btenerTextoInteraction.desde(ESTADO_TAREA,"estado",10)
            );
            actor.should(
                    seeThat(
                            "el estado de la tarea",
                            Text.of(ESTADO_TAREA).asString().map(String::trim),
                            equalToIgnoringCase("Completado")
                    )
            );


        }
    }

    public static Task validarSolicitudCompletada() {
        return Tasks.instrumented(ResolverSolicitudTask.ValidarSolicitudCompletada.class);
    }
    public static Task ingresarSolicitudPreviamenteCreada() {
        return Tasks.instrumented(ResolverSolicitudTask.IngresarSolicitudPreviamenteCreada.class);
    }
    public static Task resolverSolicitud(String tipoSolicitud) {
        return Tasks.instrumented(ResolverSolicitud.class, tipoSolicitud);
    }
}
