/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tareas.zoologico;

import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Zoologico {

    public static void main(String[] args) {
        ArrayList<Animal> animales = new ArrayList<>();

        animales.add(new Mamifero("Jaguar", 6, "Felino", true, "Hervivoro", "Grrrrr"));
        animales.add(new Ave("Condor", 4, "Carroñero andino", true, "Ganchudo", "Sonido Grave"));
        animales.add(new Reptil("Anaconda", 8, "Boa gigante", false, "Lisa y brillante", "Ssss"));

        for (Animal animal : animales) {
            System.out.println("-------------------");
            animal.mostrarInfo();
            animal.emitirSonido();
        }
    }
}
