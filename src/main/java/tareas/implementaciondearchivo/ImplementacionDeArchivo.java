/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tareas.implementaciondearchivo;

/**
 *
 * @author Asus
 */
import gestor.*;
import java.io.IOException;

public class ImplementacionDeArchivo {
    public static void main(String[] args) {
        String archivo = "archivo.txt";
        String contenido = "Hola, Lady Este archivo no esta vacio.";

        GestorDeArchivo gestor = new GestorDeArchivo();
        ValidadorArchivo validador = new ValidadorArchivo();

        try {
            gestor.guardar(archivo, contenido);
            System.out.println("Contenido leido:\n" + gestor.leer(archivo));
            validador.verificarNoVacio(archivo);
            System.out.println(" El archivo tiene contenido.");
        } catch (ArchivoVacioException ave) {
            System.err.println(ave.getMessage());
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

