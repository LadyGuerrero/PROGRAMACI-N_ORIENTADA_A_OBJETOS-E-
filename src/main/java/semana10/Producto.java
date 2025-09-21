/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana10;

public class Producto {
    String nombre;
    int cantidad;

    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String toString() {
        return nombre + "," + cantidad;
    }

    public static Producto desdeTexto(String linea) {
        String[] partes = linea.split(",");
        return new Producto(partes[0], Integer.parseInt(partes[1]));
    }
}


