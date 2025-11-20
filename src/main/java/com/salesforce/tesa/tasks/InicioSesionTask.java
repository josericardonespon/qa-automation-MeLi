package com.salesforce.tesa.tasks;

import com.salesforce.tesa.interactions.EsperarInteraction;
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
        String url = users.getUrl();
        actor.attemptsTo(
                Open.url(url),
                WaitUntil.the(INPUT_USER, isVisible()).forNoMoreThan(Duration.ofSeconds(60)),
                InsertarInteraction.theValue(username).into(INPUT_USER),
                InsertarInteraction.theValue(password).into(INPUT_PASSWORD),
                HacerClickInteraction.on(BTN_LOGIN_SALESFORCE)

        );

    }

    public static InicioSesionTask conCredencialesValidas() {
        return instrumented(InicioSesionTask.class);
    }
}
