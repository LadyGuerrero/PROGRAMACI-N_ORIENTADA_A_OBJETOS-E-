/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.tareasemana6;

/**
 *
 * @author Asus
 */
public class Perro extends Animal{
  public Perro(String nombre, int edad) {
        super(nombre, edad); // Hereda el constructor
    }

    // Polimorfismo: método sobrescrito
    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " dice: ¡Guau!");
    }
}  
