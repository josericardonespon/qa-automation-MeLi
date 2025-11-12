package com.salesforce.tesa.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FechaUtil {

    private static final DateTimeFormatter DEFAULT_FORMAT =
            DateTimeFormatter.ofPattern("d MMM yyyy", new Locale("es", "ES"));

    public static String obtenerFechaPosterior(int diasPosteriores) {
        LocalDate fecha = LocalDate.now().plusDays(diasPosteriores);
        return fecha.format(DEFAULT_FORMAT);
    }

    public static String obtenerFechaAnterior(int diasAnteriores) {
        LocalDate fecha = LocalDate.now().minusDays(diasAnteriores);
        return fecha.format(DEFAULT_FORMAT);
    }

    public static String obtenerFechaActual() {
        return LocalDate.now().format(DEFAULT_FORMAT);
    }

    public static String obtenerFechaPersonalizada(int diasPosteriores, String formatoPersonalizado) {
        LocalDate fecha = LocalDate.now().plusDays(diasPosteriores);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern(formatoPersonalizado, new Locale("es", "ES"));
        return fecha.format(formato);

}
}
