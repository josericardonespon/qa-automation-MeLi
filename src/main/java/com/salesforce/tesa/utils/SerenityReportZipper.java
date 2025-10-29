package com.salesforce.tesa.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SerenityReportZipper {
    public static void main(String[] args) {
        try {
            File zipFile = zipSerenityReport();
            deleteZipFile(zipFile);
        } catch (IOException e) {
            System.err.println("Error al comprimir el reporte: " + e.getMessage());
        }
    }

    public static File zipSerenityReport() throws IOException {

        String serenityReportPath = "target/site/serenity";
        File reportFolder = new File(serenityReportPath);

        // Verifica si la carpeta existe y tiene archivos
        if (!reportFolder.exists() || !reportFolder.isDirectory()) {
            throw new IOException("La carpeta del reporte de Serenity no existe o no es un directorio.");
        }

        File[] files = reportFolder.listFiles();
        if (files == null || files.length == 0) {
            throw new IOException("La carpeta del reporte de Serenity está vacía.");
        }

        // Generar nombre con fecha y hora
        String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
        String zipFileName = "serenity-report-" + timestamp + ".zip";
        File zipFile = new File(zipFileName);

        try (FileOutputStream fos = new FileOutputStream(zipFile);
             ZipOutputStream zipOut = new ZipOutputStream(fos)) {

            Path sourceDirPath = Paths.get(serenityReportPath);

            // Asegura que todos los archivos dentro de la carpeta se agreguen al ZIP
            Files.walk(sourceDirPath)
                    .filter(Files::isRegularFile) // Solo archivos, no carpetas
                    .forEach(filePath -> {
                        try {
                            String entryName = sourceDirPath.relativize(filePath).toString();
                            zipOut.putNextEntry(new ZipEntry(entryName));
                            Files.copy(filePath, zipOut);
                            zipOut.closeEntry();
                        } catch (IOException e) {
                            throw new RuntimeException("Error al comprimir el archivo: " + filePath, e);
                        }
                    });

        } catch (Exception e) {
            throw new IOException("Error al crear el archivo ZIP.", e);
        }

        System.out.println("Archivo ZIP generado correctamente: " + zipFile.getAbsolutePath());
        return zipFile;
    }

    public static void deleteZipFile(File file) {
        if (file.exists()) {
            boolean deleted = file.delete();
            if (deleted) {
                System.out.println("Archivo ZIP eliminado: " + file.getName());
            } else {
                System.err.println("No se pudo eliminar el archivo ZIP: " + file.getName());
            }
        } else {
            System.out.println("El archivo no existe: " + file.getAbsolutePath());
        }
    }
}
