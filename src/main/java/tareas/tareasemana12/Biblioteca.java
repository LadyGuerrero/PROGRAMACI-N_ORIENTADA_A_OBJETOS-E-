/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.tareasemana12;

/**
 *
 * @author Asus
 */
import java.util.*;

public class Biblioteca {
    private Map<String, Libro> catalogoPorIsbn;
    private Map<String, Usuario> usuariosPorId;
    private Set<String> isbnsPrestados;

    public Biblioteca() {
        catalogoPorIsbn = new HashMap<>();
        usuariosPorId = new HashMap<>();
        isbnsPrestados = new HashSet<>();
    }

    public void añadirLibro(Libro libro) {
        catalogoPorIsbn.put(libro.getIsbn(), libro);
    }

    public void quitarLibro(String isbn) {
        catalogoPorIsbn.remove(isbn);
        isbnsPrestados.remove(isbn);
    }

    public void registrarUsuario(Usuario u) {
        usuariosPorId.put(u.getId(), u);
    }

    public void darBajaUsuario(String id) {
        Usuario u = usuariosPorId.remove(id);
        if (u != null) {
            for (String isbn : u.getIsbnsPrestados()) {
                isbnsPrestados.remove(isbn);
            }
        }
    }

    public boolean prestarLibro(String idUsuario, String isbn) {
        Usuario u = usuariosPorId.get(idUsuario);
        Libro l = catalogoPorIsbn.get(isbn);
        if (u != null && l != null && !isbnsPrestados.contains(isbn)) {
            u.getIsbnsPrestados().add(isbn);
            isbnsPrestados.add(isbn);
            return true;
        }
        return false;
    }

    public boolean devolverLibro(String idUsuario, String isbn) {
        Usuario u = usuariosPorId.get(idUsuario);
        if (u != null && u.getIsbnsPrestados().contains(isbn)) {
            u.getIsbnsPrestados().remove(isbn);
            isbnsPrestados.remove(isbn);
            return true;
        }
        return false;
    }

    public List<Libro> buscarPorTitulo(String texto) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro l : catalogoPorIsbn.values()) {
            if (l.getTitulo().toLowerCase().contains(texto.toLowerCase())) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    public List<Libro> buscarPorAutor(String texto) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro l : catalogoPorIsbn.values()) {
            if (l.getAutor().toLowerCase().contains(texto.toLowerCase())) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    public List<Libro> buscarPorCategoria(String texto) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro l : catalogoPorIsbn.values()) {
            if (l.getCategoria().equalsIgnoreCase(texto)) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    public List<Libro> listarPrestados(String idUsuario) {
        Usuario u = usuariosPorId.get(idUsuario);
        List<Libro> resultado = new ArrayList<>();
        if (u != null) {
            for (String isbn : u.getIsbnsPrestados()) {
                Libro l = catalogoPorIsbn.get(isbn);
                if (l != null) resultado.add(l);
            }
        }
        return resultado;
    }
}
