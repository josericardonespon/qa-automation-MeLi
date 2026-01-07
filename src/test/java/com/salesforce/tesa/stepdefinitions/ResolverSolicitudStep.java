package com.salesforce.tesa.stepdefinitions;

import com.salesforce.tesa.tasks.CrearSolicitudesTask;
import com.salesforce.tesa.tasks.ResolverSolicitudTask;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;

public class ResolverSolicitudStep {

    @Y("el Usuario Asignado ingresa a la solicitud previamente creada")
    public void ingresarSolicitudPreviamenteCreada() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ResolverSolicitudTask.ingresarSolicitudPreviamenteCreada()
        );
    }

    @Y("el Usuario Asignado resuelve la solicitud de tipo {string}")
    public void resolverLaSolicitudDeTipo(String tipoSolicitud) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ResolverSolicitudTask.resolverSolicitud(tipoSolicitud)
        );

    }
    @Entonces("la solicitud se resuelve exitosamente")
    public void validarSolicitudCompletada() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ResolverSolicitudTask.validarSolicitudCompletada()
        );
    }
}


