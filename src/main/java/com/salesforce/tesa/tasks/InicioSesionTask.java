package com.salesforce.tesa.tasks;

import com.salesforce.tesa.utils.Constants;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class InicioSesionTask implements Task {

    @Override
    @Step("{0} Login con credenciales validas")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(Constants.URL_UAT)
        );
    }

    public static InicioSesionTask conCredencialesValidas() {
        return Tasks.instrumented(InicioSesionTask.class);
    }
}
