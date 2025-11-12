package com.salesforce.tesa.tasks;

import com.salesforce.tesa.interactions.*;
import com.salesforce.tesa.utils.CargarArchivoUtil;
import com.salesforce.tesa.utils.FechaUtil;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.salesforce.tesa.userintefaces.salesforce.AcuerdosPage.*;
import static com.salesforce.tesa.userintefaces.salesforce.AudienciaPage.*;
import static com.salesforce.tesa.userintefaces.salesforce.Global.*;

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
                actor.attemptsTo(
                        HacerClickInteraction.on(BUTTON_NEW_EVENT).withOptions(30, true),
                        HacerClickInteraction.on(RADIO_ACUERDOS).withOptions(30, true),
                        HacerClickInteraction.on(BUTTON_SIGUIENTE).withOptions(30, true),
                        EscribirFechaInteraction.en(INPUT_FECHA_INICIO,FechaUtil.obtenerFechaPosterior(3)),
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
                // lógica específica para crear decisión
                break;

            default:
                throw new IllegalArgumentException("Tipo de evento no reconocido: " + tipoEvento);
        }
    }
}
