/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.zoologico;

/**
 *
 * @author Asus
 */
public class Reptil extends Animal {
    private boolean esVenenoso;
    private String tipoEscamas;
    private String sonido;

    public Reptil(String nombre, int edad, String especie, boolean esVenenoso, String tipoEscamas, String sonido) {
        super(nombre, edad, especie);
        this.esVenenoso = esVenenoso;
        this.tipoEscamas = tipoEscamas;
        this.sonido = sonido;
    }

    @Override
    public void emitirSonido() {
        System.out.println(nombre + " hace: " + sonido);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Es venenoso: " + (esVenenoso ? "Si" : "No"));
        System.out.println("Tipo de escamas: " + tipoEscamas);
    }
}

