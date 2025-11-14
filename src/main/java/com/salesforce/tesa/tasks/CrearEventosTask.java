package com.salesforce.tesa.tasks;

import com.salesforce.tesa.interactions.*;
import com.salesforce.tesa.userintefaces.salesforce.AcuerdosPage;
import com.salesforce.tesa.utils.CargarArchivoUtil;
import com.salesforce.tesa.utils.FechaUtil;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

import static com.salesforce.tesa.userintefaces.salesforce.AcuerdosPage.*;
import static com.salesforce.tesa.userintefaces.salesforce.AudienciaPage.*;
import static com.salesforce.tesa.userintefaces.salesforce.DecisionPage.*;
import static com.salesforce.tesa.userintefaces.salesforce.Global.*;
import static com.salesforce.tesa.userintefaces.salesforce.MultasPage.*;
import static com.salesforce.tesa.userintefaces.salesforce.PericiaPage.*;
import static com.salesforce.tesa.userintefaces.salesforce.RecursoPage.*;

public class CrearEventosTask implements Task {

    private final String tipoEvento;
    //private final String fechaInicio = FechaUtil.(3);
    private final String rutaArchivo = CargarArchivoUtil.obtenerRutaArchivo("PRUEBA.txt");

    public CrearEventosTask(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public static CrearEventosTask deTipo(String tipoEvento) {
        return Tasks.instrumented(CrearEventosTask.class, tipoEvento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (tipoEvento.toLowerCase()) {
            case "acuerdos":
                crearEventoBase(actor, RADIO_ACUERDOS);
                actor.attemptsTo(
                        HacerClickInteraction.on(COMBO_RESULT_AGREEMENT).withOptions(30, false),
                        HacerClickInteraction.on(OPTION_PAGA_LEGALES).withOptions(30, false),
                        HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, false),
                        CargarArchivoInteraction.from(rutaArchivo, INPUT_FILE),
                        HacerClickInteraction.on(BTN_ARCHIVO_LISTO).withOptions(30, true),
                        HacerClickInteraction.on(BUTTON_GUARDAR).withOptions(30, true)
                );
                break;

            case "audiencia":
                actor.attemptsTo(
                        HacerClickInteraction.on(BUTTON_NEW_EVENT).withOptions(30, true),
                        HacerClickInteraction.on(RADIO_AUDIENCIA).withOptions(30, true),
                        HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, true),
                        EscribirFechaInteraction.en(INPUT_FECHA_INICIO,FechaUtil.obtenerFechaPosterior(3)),
                        HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, true),
                        CargarArchivoInteraction.from(rutaArchivo, INPUT_FILE),
                        HacerClickInteraction.on(BTN_ARCHIVO_LISTO).withOptions(30, true),
                        HacerClickInteraction.on(BUTTON_GUARDAR).withOptions(30, true)
                );
                break;

            case "decisión":
                crearEventoBase(actor, RADIO_DECISION);
                actor.attemptsTo(
                        HacerClickInteraction.on(COMBO_RESULT_DECISION).withOptions(30, false),
                        HacerClickInteraction.on(OPTION_FAVORABLE_MELI).withOptions(30, false),
                        HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, false),
                        CargarArchivoInteraction.from(rutaArchivo, INPUT_FILE),
                        HacerClickInteraction.on(BTN_ARCHIVO_LISTO).withOptions(30, true),
                        HacerClickInteraction.on(BUTTON_GUARDAR).withOptions(30, true)
                );
                break;
            case "multas":
                crearEventoBase(actor, RADIO_MULTAS);
                actor.attemptsTo(
                        InsertarInteraction.theValue("1000").into(MONTO_MULTA).withOptions(true),
                        HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, false),
                        CargarArchivoInteraction.from(rutaArchivo, INPUT_FILE),
                        HacerClickInteraction.on(BTN_ARCHIVO_LISTO).withOptions(30, true),
                        HacerClickInteraction.on(BUTTON_GUARDAR).withOptions(30, true)
                );
                break;
            case "pericia":
                crearEventoBase(actor, RADIO_PERICIA);
                actor.attemptsTo(
                        InsertarInteraction.theValue("PRUEBA, AUTOMATIZADA").into(PERITO_DE_LA_AUTORIDAD).withOptions(true),
                        InsertarInteraction.theValue("PRUEBA, ABOGADO").into(PERITO_TECNICO).withOptions(true),
                        HacerClickInteraction.on(OPTION_FAVORABLE_MELI_PERICIA).withOptions(30, false),
                        HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, false),
                        CargarArchivoInteraction.from(rutaArchivo, INPUT_FILE),
                        HacerClickInteraction.on(BTN_ARCHIVO_LISTO).withOptions(30, true),
                        HacerClickInteraction.on(BUTTON_GUARDAR).withOptions(30, true)
                );
                break;
            case "recurso":
                crearEventoBase(actor, RADIO_RECURSO);
                actor.attemptsTo(
                        HacerClickInteraction.on(COMBO_ACTOR_RECURSO).withOptions(30, false),
                        HacerClickInteraction.on(OPTION_MELI).withOptions(30, false),
                        HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, false),
                        CargarArchivoInteraction.from(rutaArchivo, INPUT_FILE),
                        HacerClickInteraction.on(BTN_ARCHIVO_LISTO).withOptions(30, true),
                        HacerClickInteraction.on(BUTTON_GUARDAR).withOptions(30, true)
                );
                break;

            default:
                throw new IllegalArgumentException("Tipo de evento no reconocido: " + tipoEvento);
        }
    }

    private <T extends Actor> void crearEventoBase(T actor, Target radioButton){
        actor.attemptsTo(
                HacerClickInteraction.on(BUTTON_NEW_EVENT).withOptions(30, true),
                HacerClickInteraction.on(radioButton).withOptions(30, true),
                HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, true),
                EscribirFechaInteraction.en(INPUT_FECHA_INICIO, FechaUtil.obtenerFechaPosterior(3))

        );
    }
}
