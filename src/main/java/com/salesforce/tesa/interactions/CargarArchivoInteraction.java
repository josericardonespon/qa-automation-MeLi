package com.salesforce.tesa.interactions;

import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CargarArchivoInteraction implements Interaction, IsHidden {

    private static final Logger LOGGER = LoggerFactory.getLogger(CargarArchivoInteraction.class);

    private final String filePath;
    private final Target fileInputTarget;

    /**
     * Constructor principal.
     *
     * @param filePath Ruta del archivo a subir (absoluta o relativa)
     * @param fileInputTarget Target del input[type='file']
     */
    public CargarArchivoInteraction(String filePath, Target fileInputTarget) {
        this.filePath = filePath;
        this.fileInputTarget = fileInputTarget;
    }

    /**
     * Método estático para instanciar la interacción de forma fluida.
     */
    public static CargarArchivoInteraction from(String filePath, Target fileInputTarget) {
        return Tasks.instrumented(CargarArchivoInteraction.class, filePath, fileInputTarget);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Path file = Paths.get(filePath).toAbsolutePath();

        String fileName = file.getFileName().toString();
        String fileNameWithoutExtension = fileName.contains(".")
                ? fileName.substring(0, fileName.lastIndexOf('.'))
                : fileName;

        LOGGER.info("📁 Subiendo archivo: {}", file);
        LOGGER.info("📎 Nombre sin extensión: {}", fileNameWithoutExtension);

        actor.attemptsTo(
                WaitUntil.the(fileInputTarget, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(30)),
                Upload.theFile(file).to(fileInputTarget)
        );

        actor.remember("nombreArchivo", fileNameWithoutExtension);
        LOGGER.info("✅ Archivo '{}' subido correctamente", fileName);
    }
}
