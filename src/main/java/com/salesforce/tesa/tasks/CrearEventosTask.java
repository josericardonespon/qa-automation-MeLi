package com.salesforce.tesa.tasks;

import com.salesforce.tesa.interactions.CargarArchivoInteraction;
import com.salesforce.tesa.interactions.HacerClickInteraction;
import com.salesforce.tesa.interactions.InsertarInteraction;
import com.salesforce.tesa.utils.CargarArchivoUtil;
import com.salesforce.tesa.utils.FechaUtil;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.salesforce.tesa.userintefaces.salesforce.AcuerdosPage.*;
import static com.salesforce.tesa.userintefaces.salesforce.Global.*;

public class CrearEventosTask implements Task {

    private final String tipoEvento;
    private final String fechaInicio = FechaUtil.obtenerFechaPosterior(3);
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
                        HacerClickInteraction.on(BUTTON_SIGUIENTE),
                        InsertarInteraction.theValue(fechaInicio).into(INPUT_FECHA_INICIO),
                        HacerClickInteraction.on(COMBO_RESULT_AGREEMENT).withOptions(30, false),
                        HacerClickInteraction.on(OPTION_PAGA_LEGALES).withOptions(30, false),
                        HacerClickInteraction.on(BUTTON_SIGUIENTE),
                        CargarArchivoInteraction.from(rutaArchivo, INPUT_FILE),
                        HacerClickInteraction.on(BTN_ARCHIVO_LISTO).withOptions(30, true),
                        HacerClickInteraction.on(BUTTON_GUARDAR).withOptions(30, true)
                );
                break;

            // 💡 aquí podrías extender otros tipos de eventos
            case "audiencia":
                // lógica específica para crear audiencia
                break;

            case "decisión":
                // lógica específica para crear decisión
                break;

            default:
                throw new IllegalArgumentException("Tipo de evento no reconocido: " + tipoEvento);
        }
    }
}
