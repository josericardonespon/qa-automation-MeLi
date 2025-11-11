package com.salesforce.tesa.stepdefinitions;

import com.google.inject.Inject;
import com.salesforce.tesa.tasks.InicioSesionTask;
import com.salesforce.tesa.utils.Constants;
import com.salesforce.tesa.utils.Context;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.salesforce.tesa.userintefaces.InicioSesionPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class InicioSesionStep {



    @Cuando("el usuario inicia sesión como ADMINISTRADOR en MeLi")
    public void elUsuarioIniciaSesionComo() {
        OnStage.theActorInTheSpotlight().attemptsTo(InicioSesionTask.conCredencialesValidas());
    }

    @Entonces("el usuario accede a Salesforce")
    public void accedeALaPaginaPrincipalDeLaORG() {
        Ensure.that(BARRA_CERRAR_SESION).isDisplayed();
    }

    @Dado("que el usuario ADMINISTRADOR ha iniciado sesión como Abogado Externo")
    public void elUsuarioIniciaSesion() {
        elUsuarioIniciaSesionComo();
        accedeALaPaginaPrincipalDeLaORG();
    }

}

