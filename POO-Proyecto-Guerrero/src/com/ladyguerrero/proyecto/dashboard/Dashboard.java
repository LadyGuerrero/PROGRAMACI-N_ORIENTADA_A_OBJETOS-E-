/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.ladyguerrero.proyecto.dashboard;

/**
 *
 * @author Asus
 */
import com.ladyguerrero.proyecto.modelo.Tarea;
import com.ladyguerrero.proyecto.servicio.TareaServicio;
import com.ladyguerrero.proyecto.servicio.TareaServicioImpl;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Dashboard {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner scanner = new Scanner(System.in);
        TareaServicio servicio = new TareaServicioImpl();
        boolean activo = true;
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));

        System.out.println("Bienvenido al Dashboard de Tareas");

        while (activo) {
            System.out.println("\n1. Agregar tarea\n2. Ver tareas\n3. Salir");
            System.out.print("Opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> {
                    System.out.print("Descripción de la tarea: ");
                    String texto = scanner.nextLine();
                    servicio.agregar(new Tarea(texto));
                }
                case "2" -> servicio.listar();
                case "3" -> {
                    activo = false;
                    System.out.println("Hasta pronto ");
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}


    