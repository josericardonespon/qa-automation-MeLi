package com.salesforce.tesa.stepdefinitions;

import com.salesforce.tesa.tasks.GestionarEventosTask;
import com.salesforce.tesa.tasks.VerificarEventosCreadosTask;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Cuando;
import net.serenitybdd.screenplay.actors.OnStage;

public class CrearEventosStep {

    @Cuando("el usuario crea un nuevo evento de tipo {string}")
    public void elUsuarioCreaUnNuevoEvento(String tipoEvento) {
        OnStage.theActorInTheSpotlight().attemptsTo(GestionarEventosTask.para(tipoEvento));
    }

    @Entonces("el evento de tipo {string} se crea exitosamente")
    public void verificarEventoCreado(String tipoEvento) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerificarEventosCreadosTask.deTipo(tipoEvento)
        );
    }
    @Dado("Que el evento de tipo {string} ha sido creado exitosamente")
    public void eventoCreadoExitosamente(String tipoEvento) {
        elUsuarioCreaUnNuevoEvento(tipoEvento);
        verificarEventoCreado(tipoEvento);
    }


}
