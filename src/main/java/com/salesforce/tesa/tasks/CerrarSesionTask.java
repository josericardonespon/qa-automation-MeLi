package com.salesforce.tesa.tasks;

import com.salesforce.tesa.interactions.HacerClickInteraction;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.salesforce.tesa.userintefaces.InicioSesionPage.*;

public class CerrarSesionTask implements Task {
    @Override
    @Step("{0} logs out")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                HacerClickInteraction.on(BTN_CERRAR_SESION)
        );
    }
    public static CerrarSesionTask cerrarSesion() {
        return Tasks.instrumented(CerrarSesionTask.class);
    }
}
