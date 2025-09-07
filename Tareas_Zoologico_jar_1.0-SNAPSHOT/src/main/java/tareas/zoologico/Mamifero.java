/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.zoologico;

/**
 *
 * @author Asus
 */
public class Mamifero extends Animal {
    private boolean tienePelo;
    private String tipoAlimentacion;
    private String sonido;

    public Mamifero(String nombre, int edad, String especie, boolean tienePelo, String tipoAlimentacion, String sonido) {
        super(nombre, edad, especie);
        this.tienePelo = tienePelo;
        this.tipoAlimentacion = tipoAlimentacion;
        this.sonido = sonido;
    }

    @Override
    public void emitirSonido() {
        System.out.println(nombre + " hace:" + sonido);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Tiene pelo: " + (tienePelo ? "Si" : "No"));
        System.out.println("Tipo de alimentacion: " + tipoAlimentacion);
    }
}

