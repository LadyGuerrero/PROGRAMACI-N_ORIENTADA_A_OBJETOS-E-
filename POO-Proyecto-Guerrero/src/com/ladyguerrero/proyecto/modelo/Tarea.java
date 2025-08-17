/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ladyguerrero.proyecto.modelo;

/**
 *
 * @author Asus
 */
public class Tarea {
  private final String descripcion;

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String mostrar() {
        return "Tarea: " + descripcion;
    }
}

