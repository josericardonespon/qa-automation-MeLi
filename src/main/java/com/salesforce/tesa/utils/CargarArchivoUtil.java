package com.salesforce.tesa.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CargarArchivoUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CargarArchivoUtil.class);

    // Directorio base donde se almacenan los archivos de prueba
    private static final String BASE_PATH = Paths.get(
            System.getProperty("user.dir"),
            "src", "test", "resources", "files"
    ).toString();

    public static String obtenerRutaArchivo(String nombreArchivo) {
        Path rutaArchivo = Paths.get(BASE_PATH, nombreArchivo).toAbsolutePath();

        if (!Files.exists(rutaArchivo)) {
            String mensajeError = "Archivo no encontrado: " + rutaArchivo;
            LOGGER.error(mensajeError);
            throw new IllegalArgumentException(mensajeError);
        }

        LOGGER.info("📁 Archivo localizado correctamente: {}", rutaArchivo);
        return rutaArchivo.toString();
    }


    public static boolean existeArchivo(String nombreArchivo) {
        File archivo = new File(BASE_PATH, nombreArchivo);
        boolean existe = archivo.exists();

        if (existe) {
            LOGGER.debug("El archivo '{}' existe.", archivo.getAbsolutePath());
        } else {
            LOGGER.warn("El archivo '{}' no fue encontrado.", archivo.getAbsolutePath());
        }

        return existe;
    }

    public static String obtenerDirectorioBase() {
        return BASE_PATH;
    }
}
