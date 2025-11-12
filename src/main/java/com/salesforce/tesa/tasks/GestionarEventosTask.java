package com.salesforce.tesa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class GestionarEventosTask implements Task {

    private final String tipoEvento;


    public GestionarEventosTask(String tipoEvento) {
        this.tipoEvento = tipoEvento;

    }

    public static GestionarEventosTask para(String tipoEvento) {
        return Tasks.instrumented(GestionarEventosTask.class, tipoEvento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(CrearEventosTask.deTipo(tipoEvento));

    }
}
