/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ladyguerrero.proyecto.servicio;


import com.ladyguerrero.proyecto.modelo.Tarea;
import java.util.ArrayList;
import java.util.List;

public class TareaServicioImpl implements TareaServicio {
    private final List<Tarea> tareas = new ArrayList<>();

    @Override
    public void agregar(Tarea tarea) {
        tareas.add(tarea);
    }

    @Override
    public void listar() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
        } else {
            for (Tarea t : tareas) {
                System.out.println(t.mostrar());
            }
        }
    }
}
