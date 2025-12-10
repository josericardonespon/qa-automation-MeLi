package com.salesforce.tesa.tasks;

import com.salesforce.tesa.interactions.EsperarInteraction;
import com.salesforce.tesa.interactions.HacerClickInteraction;
import com.salesforce.tesa.interactions.InsertarInteraction;
import com.salesforce.tesa.interactions.NavegarUrlInteraction;
import com.salesforce.tesa.utils.RolesJsonReader;
import com.salesforce.tesa.utils.Users;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static com.salesforce.tesa.userintefaces.InicioSesionPage.*;
import static com.salesforce.tesa.userintefaces.salesforce.CasoPage.COMBO_CASES;
import static com.salesforce.tesa.userintefaces.salesforce.Global.SPINNER;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;


public class CambiarRolTask implements Task {
    private final Users users = new Users();

    private final String rol;

    public CambiarRolTask(String rol) {
        this.rol = rol;
    }
    public static CambiarRolTask a(String rol) {
        return Tasks.instrumented(CambiarRolTask.class, rol);
    }
    @Override
    @Step("{0} cambia el usuario al rol #rol mediante Login-As")
    public <T extends Actor> void performAs(T actor) {
        String urlSetup = users.getUrlSetup();
        if (!RolesJsonReader.existeRol(rol)) {
            throw new IllegalArgumentException("El rol no existe en roles.json: " + rol);
        }
        actor.attemptsTo(
                NavegarUrlInteraction.navegarUrl(urlSetup),
                EsperarInteraction.por(2000),
                WaitUntil.the(SPINNER, isNotPresent()).forNoMoreThan(java.time.Duration.ofSeconds(30)),
                HacerClickInteraction.on(INPUT_SEARCH).withOptions(30,true),
                InsertarInteraction.theValue(rol).into(INPUT_SEARCH),
                HacerClickInteraction.on(SEARCH_RESULT.of(rol)).withOptions(30,true),
                WaitUntil.the(IFRAME_LOGIN_AS.of(rol), isPresent()).forNoMoreThan(Duration.ofSeconds(60)),
                Switch.toFrame(IFRAME_LOGIN_AS.of(rol).resolveFor(actor)),
                HacerClickInteraction.on(BTN_LOGIN).withOptions(30,true),
                Switch.toParentFrame()

        );
    }
}
