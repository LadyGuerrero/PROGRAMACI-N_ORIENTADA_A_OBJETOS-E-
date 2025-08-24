/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.zoologico;

/**
 *
 * @author Asus
 */
public abstract class Animal {
    protected String nombre;
    protected int edad;
    protected String especie;

    public Animal(String nombre, int edad, String especie) {
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
    }

    public abstract void emitirSonido();

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Especie: " + especie);
    }
}

