/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.calculadorarea;

/**
 *
 * Clase que representa un rectangulo y calcula su area
 */
public class Rectangulo {
    float largo_rectangulo;    // tipo float
    float ancho_rectangulo;    // tipo float
    
    // Constructor
    public Rectangulo(float largo, float ancho) {
        this.largo_rectangulo = largo;
        this.ancho_rectangulo = ancho;
    }
    
    // Método para calcular área
    public float calcular_area() {
        return largo_rectangulo * ancho_rectangulo;
    }
}
