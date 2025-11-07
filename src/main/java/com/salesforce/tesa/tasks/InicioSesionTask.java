package com.salesforce.tesa.tasks;

import com.salesforce.tesa.interactions.HacerClickInteraction;
import com.salesforce.tesa.interactions.InsertarInteraction;
import com.salesforce.tesa.utils.Constants;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static com.salesforce.tesa.userintefaces.InicioSesionPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class InicioSesionTask implements Task {

    @Override
    @Step("{0} Login con credenciales validas")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(Constants.URL),
                InsertarInteraction.theValue("Abogado Externo").into(INPUT_SEARCH),
                HacerClickInteraction.on(SEARCH_RESULT),
                WaitUntil.the(IFRAME_ABOGADO, isPresent()).forNoMoreThan(Duration.ofSeconds(60)),
                Switch.toFrame(IFRAME_ABOGADO.resolveFor(actor)),
                HacerClickInteraction.on(BTN_LOGIN),
                WaitUntil.the(BTN_LOGIN, isNotVisible()).forNoMoreThan(Duration.ofSeconds(15)),
                Switch.toParentFrame(),
                WaitUntil.the(WELCOME_ABOGADO, isVisible()).forNoMoreThan(Duration.ofSeconds(60))
        );
                ;
    }

    public static InicioSesionTask conCredencialesValidas() {
        return Tasks.instrumented(InicioSesionTask.class);
    }
}
