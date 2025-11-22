package com.salesforce.tesa.tasks;

import com.salesforce.tesa.interactions.HacerClickInteraction;
import com.salesforce.tesa.utils.Users;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.salesforce.tesa.userintefaces.salesforce.CasoPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearCasoTask {

    public static class AbrirCasos implements Task {
        @Override
        @Step("{0} abre la sección de Casos en MeLi")
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    HacerClickInteraction.on(LABEL_CASES).withOptions(30, true)
            );
        }
    }

    public static class SeleccionarVistaDemandas implements Task {
        @Override
        @Step("{0} selecciona la vista de Demandas en la lista de Casos")
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    HacerClickInteraction.on(COMBO_CASES).withOptions(30, true),
                    HacerClickInteraction.on(DEMAND_CASES).withOptions(30, true)
            );
        }
    }

    public static class IngresarCaso implements Task {
        private final Users users = new Users();
        @Override
        @Step("{0} ingresa al caso principal '00001008'")
        public <T extends Actor> void performAs(T actor) {
            String ambiente = users.getEnvironment();
            switch (ambiente.toLowerCase()) {
                case "qa":
                    actor.attemptsTo(
                            HacerClickInteraction.on(PRINCIPAL_CASE_QA).withOptions(30, true),
                            WaitUntil.the(TAG_CASE_QA, isPresent()).forNoMoreThan(java.time.Duration.ofSeconds(30)),
                            WaitUntil.the(TAG_CASE_QA, isVisible()).forNoMoreThan(java.time.Duration.ofSeconds(30))
                    );
                    break;
                case "uat":
                    actor.attemptsTo(
                            HacerClickInteraction.on(PRINCIPAL_CASE_UAT).withOptions(30, true),
                            WaitUntil.the(TAG_CASE_UAT, isPresent()).forNoMoreThan(java.time.Duration.ofSeconds(30)),
                            WaitUntil.the(TAG_CASE_UAT, isVisible()).forNoMoreThan(java.time.Duration.ofSeconds(30))
                    );
                    break;
            }

        }
    }


    public static Task abrirCasos() {
        return Tasks.instrumented(AbrirCasos.class);
    }

    public static Task seleccionarVistaDemandas() {
        return Tasks.instrumented(SeleccionarVistaDemandas.class);
    }

    public static Task ingresarCaso() {
        return Tasks.instrumented(IngresarCaso.class);
    }
}
