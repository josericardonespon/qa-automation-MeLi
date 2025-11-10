package com.salesforce.tesa.tasks;

import com.salesforce.tesa.interactions.HacerClickInteraction;
import com.salesforce.tesa.interactions.InsertarInteraction;
import com.salesforce.tesa.interactions.NavegarUrlInteraction;
import com.salesforce.tesa.utils.Constants;
import com.salesforce.tesa.utils.Users;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.model.util.EnvironmentVariables;

import java.time.Duration;

import static com.salesforce.tesa.userintefaces.InicioSesionPage.*;
import static com.salesforce.tesa.utils.Constants.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class InicioSesionTask implements Task {
    private final Users users = new Users();
    @Override
    @Step("{0} Login con credenciales validas")
    public <T extends Actor> void performAs(T actor) {
        String username = users.getUsername();
        String password = users.getPassword();
        actor.attemptsTo(
                Open.url(Constants.URL),
                WaitUntil.the(INPUT_USER, isVisible()).forNoMoreThan(Duration.ofSeconds(60)),
                InsertarInteraction.theValue(username).into(INPUT_USER),
                InsertarInteraction.theValue(password).into(INPUT_PASSWORD),
                HacerClickInteraction.on(BTN_LOGIN_SALESFORCE),
                NavegarUrlInteraction.navegarUrl(URL_SETUP),
                WaitUntil.the(INPUT_SEARCH, isVisible()).forNoMoreThan(Duration.ofSeconds(15)),
                InsertarInteraction.theValue("Abogado Externo").into(INPUT_SEARCH),
                HacerClickInteraction.on(SEARCH_RESULT).withOptions(60,true),
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
        return instrumented(InicioSesionTask.class);
    }
}
