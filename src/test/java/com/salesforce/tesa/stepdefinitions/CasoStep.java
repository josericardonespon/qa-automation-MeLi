package com.salesforce.tesa.stepdefinitions;

import com.salesforce.tesa.tasks.CasoTask;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CasoStep {

    @Dado("que el usuario desea ingresar a los casos creados en MeLi")
    public void queElUsuarioDeseaIngresarALosCasosCreadosEnMeLi() {
        theActorInTheSpotlight().attemptsTo(
                CasoTask.abrirCasos()
        );
    }

    @Cuando("selecciona la vista de Demandas")
    public void seleccionaLaVistaDeDemandas() {
        theActorInTheSpotlight().attemptsTo(
                CasoTask.seleccionarVistaDemandas()
        );
    }

    @Entonces("deberá visualizar los casos creados en MeLi e ingresar a un caso")
    public void deberaVisualizarLosCasosCreadosEnMeLiEIngresarAUnCaso() {
        theActorInTheSpotlight().attemptsTo(
                CasoTask.ingresarCaso()
        );
    }
}
