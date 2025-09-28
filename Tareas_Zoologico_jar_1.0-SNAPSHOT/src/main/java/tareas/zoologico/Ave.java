/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.zoologico;

/**
 *
 * @author Asus
 */
public class Ave extends Animal {
    private boolean puedeVolar;
    private String tipoDePico;
    private String sonido;

    public Ave(String nombre, int edad, String especie, boolean puedeVolar, String tipoDePico, String sonido) {
        super(nombre, edad, especie);
        this.puedeVolar = puedeVolar;
        this.tipoDePico = tipoDePico;
        this.sonido = sonido;
    }

    @Override
    public void emitirSonido() {
        System.out.println(nombre + " hace:" + sonido);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Puede volar: " + (puedeVolar ? "Si" : "No"));
        System.out.println("Tipo de pico: " + tipoDePico);
    }
}

