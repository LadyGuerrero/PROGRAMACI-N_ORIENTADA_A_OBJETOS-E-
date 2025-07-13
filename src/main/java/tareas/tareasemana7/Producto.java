/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.tareasemana7;

/**
 *
 * @author Asus
 */
public class Producto {

private String nombre;
    private double precio;
    private int stock;

    /**
     * Constructor por defecto.
     * Inicializa con valores básicos.
     */
    public Producto() {
        this.nombre = "Sin nombre";
        this.precio = 0.0;
        this.stock = 0;
    }

    /**
     * Constructor parametrizado.
     * Inicializa todos los atributos.
     */
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Sobrecarga de constructor: sin stock.
     * Inicializa nombre y precio, stock en cero.
     */
    public Producto(String nombre, double precio) {
        this(nombre, precio, 0);
    }

    // Getters y setters opcionales para manipular atributos

    /**
     * Método para mostrar información del producto.
     */
    @Override
    public String toString() {
        return "Producto{" +
               "nombre='" + nombre + '\'' +
               ", precio=" + precio +
               ", stock=" + stock +
               '}';
    }
}
