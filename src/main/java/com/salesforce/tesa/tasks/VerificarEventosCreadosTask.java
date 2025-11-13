package com.salesforce.tesa.tasks;

import com.salesforce.tesa.interactions.HacerClickInteraction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.salesforce.tesa.userintefaces.salesforce.AcuerdosPage.*;
import static com.salesforce.tesa.userintefaces.salesforce.AudienciaPage.*;
import static com.salesforce.tesa.userintefaces.salesforce.DecisionPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerificarEventosCreadosTask implements Task {

    private final String tipoEvento;

    public VerificarEventosCreadosTask(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public static VerificarEventosCreadosTask deTipo(String tipoEvento) {
        return Tasks.instrumented(VerificarEventosCreadosTask.class, tipoEvento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        switch (tipoEvento.toLowerCase()) {

            case "acuerdos":
                actor.attemptsTo(
                        HacerClickInteraction.on(IR_EVENTO_ACUERDOS).withOptions(30, true),
                        WaitUntil.the(VISTA_ACUERDOS, isVisible()).forNoMoreThan(java.time.Duration.ofSeconds(30))
                );
                break;


            case "audiencia":
                actor.attemptsTo(
                        HacerClickInteraction.on(IR_EVENTO_AUDIENCIA).withOptions(30, true),
                        WaitUntil.the(VISTA_AUDIENCIA, isVisible()).forNoMoreThan(java.time.Duration.ofSeconds(30))
                );
                break;

            case "decisión":
                actor.attemptsTo(
                        HacerClickInteraction.on(IR_EVENTO_DECISION).withOptions(30, true),
                        WaitUntil.the(VISTA_DECISION, isVisible()).forNoMoreThan(java.time.Duration.ofSeconds(30))
                );
                break;

            default:
                throw new IllegalArgumentException("Tipo de evento no reconocido: " + tipoEvento);
        }
    }
}
