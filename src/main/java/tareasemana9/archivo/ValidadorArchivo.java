/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareasemana9.archivo;

// Esta clase forma parte del proyecto de gestion y validacion de archivos desarrollado en tareasemana9.archivo

import java.io.IOException;
import java.nio.file.*;

public class ValidadorArchivo {

    public void verificarNoVacio(String nombreArchivo) throws ArchivoVacioException, IOException {
        String contenido = Files.readString(Paths.get(nombreArchivo));
        if (contenido.trim().isEmpty()) {
            throw new ArchivoVacioException("El archivo esta vacio.");
        }
    }
}