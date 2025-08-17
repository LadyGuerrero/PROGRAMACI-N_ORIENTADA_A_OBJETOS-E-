/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
package gestor;

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

