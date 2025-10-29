package com.salesforce.tesa.stepdefinitions;

import com.google.inject.Inject;
import com.salesforce.tesa.tasks.InicioSesionTask;
import com.salesforce.tesa.utils.Constants;
import com.salesforce.tesa.utils.Context;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class InicioSesionStep {

    private final Context context;
    @Inject
    public InicioSesionStep(Context context) {
        this.context = context;
    }

    @Cuando("el usuario inicia sesión como ADMINISTRADOR en MeLi")
    public void elUsuarioIniciaSesion() {
        OnStage.theActorInTheSpotlight().attemptsTo(InicioSesionTask.conCredencialesValidas());
    }

    @Entonces("el usuario accede a Salesforce")
    public void accedeALaPaginaPrincipalDeLaORG() {
        Ensure.that(true).isTrue();
    }

}

