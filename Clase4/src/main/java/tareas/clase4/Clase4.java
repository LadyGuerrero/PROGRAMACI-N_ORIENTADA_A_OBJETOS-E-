/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tareas.clase4;

/**
 *
 * @author Asus
 */
public class Clase4 {

    public static void main(String[] args) {
        Cajero miCajero = new Cajero();
        miCajero.retirar(1100);
        System.out.println("Saldo restante: " + miCajero.verSaldo());
    }
}
