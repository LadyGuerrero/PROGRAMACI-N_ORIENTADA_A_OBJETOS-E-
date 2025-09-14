/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package semana10;

import java.io.*;
import java.util.*;

public class InventarioSemana10 {
    static String archivo = "inventario.txt";
    static List<String> productos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        cargar();

        int opcion;
        do {
            System.out.println("\n MENU");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> agregar();
                case 2 -> mostrar();
                case 0 -> System.out.println(" Adios.");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    static void agregar() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Cantidad: ");
        String cantidad = sc.nextLine();
        productos.add(nombre + "," + cantidad);
        guardar();
        System.out.println(" Producto guardado.");
    }

    static void mostrar() {
        System.out.println("\n Inventario:");
        if (productos.isEmpty()) {
            System.out.println("Sin productos.");
        } else {
            for (String p : productos)
                System.out.println(p);
        }
    }

    static void cargar() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null)
                productos.add(linea);
        } catch (IOException e) {
            System.out.println(" Archivo no encontrado, se creara.");
        }
    }

    static void guardar() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (String p : productos)
                bw.write(p + "\n");
        } catch (IOException e) {
            System.out.println(" Error al guardar.");
        }
    }
}
