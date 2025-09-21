package tareasemana9.archivo;

// Esta clase forma parte del proyecto de gestion y validacion de archivos desarrollado en tareasemana9.archivo

import java.io.IOException;


public class ImplementacionDeArchivo {

    public static void main(String[] args) {
        String archivo = "archivo.txt";
        String contenido = "Hola Lucio. Este archivo no esta vacio.";

        GestorDeArchivo gestor = new GestorDeArchivo();
        ValidadorArchivo validador = new ValidadorArchivo();

        try {
            gestor.guardar(archivo, contenido);
            System.out.println("[OK] Contenido leido:\n" + gestor.leer(archivo));
            validador.verificarNoVacio(archivo);
            System.out.println("[OK] El archivo tiene contenido.");
        } catch (ArchivoVacioException ave) {
            System.err.println("[ADVERTENCIA] " + ave.getMessage());
        } catch (IOException e) {
            System.err.println("[ERROR] " + e.getMessage());
        }
    }
}
