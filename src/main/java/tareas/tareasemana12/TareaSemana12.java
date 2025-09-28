/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tareas.tareasemana12;

/**
 *
 * @author Asus
 */
public class TareaSemana12 {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.registrarUsuario(new Usuario("U1", "Ana"));
        biblioteca.registrarUsuario(new Usuario("U2", "Luis"));

        biblioteca.añadirLibro(new Libro("ISBN-001", "Clean Code", "Robert C. Martin", "Software"));
        biblioteca.añadirLibro(new Libro("ISBN-002", "Effective Java", "Joshua Bloch", "Java"));

        biblioteca.prestarLibro("U1", "ISBN-001");
        biblioteca.prestarLibro("U2", "ISBN-002");

        System.out.println("Libros prestados a Ana:");
        for (Libro l : biblioteca.listarPrestados("U1")) {
            System.out.println(l.getTitulo());
        }

        biblioteca.devolverLibro("U1", "ISBN-001");

        System.out.println("\nBuscar por autor 'Bloch':");
        for (Libro l : biblioteca.buscarPorAutor("Bloch")) {
            System.out.println(l.getTitulo());
        }

        System.out.println("\nBuscar por categoría 'Software':");
        for (Libro l : biblioteca.buscarPorCategoria("Software")) {
            System.out.println(l.getTitulo());
        }
    }
    }