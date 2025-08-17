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

public class ValidadorArchivo {

    public void verificarNoVacio(String nombreArchivo) throws ArchivoVacioException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            if (br.readLine() == null) throw new ArchivoVacioException("Archivo vacío.");
        }
    }
}
