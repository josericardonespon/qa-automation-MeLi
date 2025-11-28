package com.salesforce.tesa.stepdefinitions;

import com.salesforce.tesa.tasks.CrearCasoTask;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CrearCasoStep {

    @Dado("que el usuario desea crear un caso en MeLi")
    public void queElUsuarioDeseaCrearCasosEnMeli() {
        theActorInTheSpotlight().attemptsTo(
                CrearCasoTask.abrirCasos()
        );
    }

    @Cuando("selecciona la vista de Demandas")
    public void seleccionaLaVistaDeDemandas() {
        theActorInTheSpotlight().attemptsTo(
                CrearCasoTask.seleccionarVistaDemandas()
        );
    }

    @Y("crea un nuevo caso")
    public void creaUnNuevoCaso() {
        theActorInTheSpotlight().attemptsTo(
                CrearCasoTask.crearCasos()
        );
    }

    @Entonces("deberá visualizar e ingresar al caso creado en MeLi correctamente")
    public void deberaVisualizarLosCasosCreadosEnMeLiEIngresarAUnCaso() {
        theActorInTheSpotlight().attemptsTo(
                CrearCasoTask.ingresarCasoCreado()
        );
    }

    @Dado("que el rol {string} ha creado un caso correctamente en MeLi")
    public void casoCreadoEnMeli(String rol) {
        queElUsuarioDeseaCrearCasosEnMeli();
        seleccionaLaVistaDeDemandas();
        creaUnNuevoCaso();
        deberaVisualizarLosCasosCreadosEnMeLiEIngresarAUnCaso();
    }

}
