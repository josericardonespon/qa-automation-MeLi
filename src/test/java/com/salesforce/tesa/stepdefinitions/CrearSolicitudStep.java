package com.salesforce.tesa.stepdefinitions;
import com.salesforce.tesa.tasks.CrearSolicitudesTask;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;

public class CrearSolicitudStep {

    @Cuando("el rol {string} ingresa a un caso previamente creado")
    public void ingresarAlCaso(String rol) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CrearSolicitudesTask.ingresarCasoPreviamenteCreado()
        );
    }

    @Y("el usuario crea una solicitud de tipo {string}")
    public void creaUnaNuevaSolicitud(String tipoSolicitud) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CrearSolicitudesTask.crearNuevaSolicitud(tipoSolicitud)
        );
    }

    @Y("la solicitud de tipo {string} se visualiza exitosamente")
    public void deberaVisualizarLaSolicitudCreada(String tipoSolicitud) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CrearSolicitudesTask.visualizarSolicitudCreada(tipoSolicitud)
        );
    }

}
