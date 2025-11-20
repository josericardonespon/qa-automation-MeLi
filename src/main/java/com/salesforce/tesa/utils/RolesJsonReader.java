package com.salesforce.tesa.utils;

import com.jayway.jsonpath.JsonPath;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class RolesJsonReader {

    private static final String ROLES_FILE_PATH = "dataSet/users.json";

    public static boolean existeRol(String rol) {
        try {
            String jsonData = readJson();

            // Buscar si el rol existe en el array "roles"
            List<String> rolesEncontrados =
                    JsonPath.read(jsonData, "$.roles[?(@ == '" + rol + "')]");

            return !rolesEncontrados.isEmpty();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error leyendo roles.json: " + e.getMessage());
        }
    }

    private static String readJson() throws Exception {
        try (InputStream is = RolesJsonReader.class.getClassLoader().getResourceAsStream(ROLES_FILE_PATH)) {
            if (is == null) {
                throw new IllegalStateException("No se pudo encontrar el archivo");
            }
            return IOUtils.toString(is, StandardCharsets.UTF_8);
        }
    }
}
