/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareas.clase4;

/**
 *
 * @author Asus
 */
public class Cajero {
private int dinero = 1000;
    public void retirar(int monto) {
        if (monto <= dinero) {
            dinero -= monto;
           System.out.println("Retiraste $" + monto);
        } else {
           System.out.println("Fondos insuficientes");
        }
    }
    public int verSaldo() {
        return dinero;
    }    
}
