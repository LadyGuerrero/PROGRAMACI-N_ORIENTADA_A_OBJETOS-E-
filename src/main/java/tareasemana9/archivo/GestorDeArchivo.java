/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareasemana9.archivo;

// Esta clase forma parte del proyecto de gestion y validacion de archivos desarrollado en tareasemana9.archivo

import java.io.*;
import java.nio.file.*;

public class GestorDeArchivo {

    public void guardar(String nombreArchivo, String contenido) throws IOException {
        Files.write(Paths.get(nombreArchivo), contenido.getBytes());
    }

    public String leer(String nombreArchivo) throws IOException {
        return Files.readString(Paths.get(nombreArchivo));
    }
}