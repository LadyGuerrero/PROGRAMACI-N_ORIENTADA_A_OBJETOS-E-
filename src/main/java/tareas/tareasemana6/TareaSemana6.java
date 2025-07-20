/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tareas.tareasemana6;

/**
 *
 * @author Asus
 */
public class TareaSemana6 {

public static void main(String[] args) {
        // Crear objeto de la clase base
        Animal miAnimal = new Animal("Animalito", 3);
        miAnimal.hacerSonido();

        // Crear objeto de la clase derivada
        Perro miPerro = new Perro("Rex", 5);
        miPerro.hacerSonido();
}
}