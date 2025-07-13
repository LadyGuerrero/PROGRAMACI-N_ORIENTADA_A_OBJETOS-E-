package semana2.gestorclimasemanal;

import java.util.Scanner;

/**
 * Programa para calcular el promedio semanal de temperaturas
 * Implementa ambos enfoques: tradicional y orientado a objetos
 */
public class GestorClimaSemanal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("SELECCIONE EL MÉTODO:");
        System.out.println("1. Programación Tradicional");
        System.out.println("2. Programación Orientada a Objetos");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        
        switch(opcion) {
            case 1:
                ejecutarTradicional();
                break;
            case 2:
                ejecutarPOO();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
    
    // ========== IMPLEMENTACIÓN TRADICIONAL ==========
    private static void ejecutarTradicional() {
        System.out.println("\n=== MÉTODO TRADICIONAL ===");
        double[] temperaturas = new double[7];
        ingresarTemperaturasTradicional(temperaturas);
        double promedio = calcularPromedioTradicional(temperaturas);
        System.out.printf("El promedio semanal de temperatura es: %.2f°C%n", promedio);
    }
    
    private static void ingresarTemperaturasTradicional(double[] temps) {
        Scanner scanner = new Scanner(System.in);
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        
        System.out.println("Ingrese las temperaturas diarias:");
        for (int i = 0; i < temps.length; i++) {
            System.out.print(dias[i] + ": ");
            temps[i] = scanner.nextDouble();
        }
    }
    
    private static double calcularPromedioTradicional(double[] temps) {
        double suma = 0;
        for (double temp : temps) {
            suma += temp;
        }
        return suma / temps.length;
    }
    
    // ========== IMPLEMENTACIÓN ORIENTADA A OBJETOS ==========
    private static void ejecutarPOO() {
        System.out.println("\n=== MÉTODO ORIENTADO A OBJETOS ===");
        SemanaClimatica semana = new SemanaClimatica();
        semana.ingresarTemperaturas();
        semana.mostrarPromedio();
    }
}

class SemanaClimatica {
    private final double[] temperaturas;
    private final String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
    
    public SemanaClimatica() {
        temperaturas = new double[7];
    }
    
    public void ingresarTemperaturas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese las temperaturas diarias:");
        
        for (int i = 0; i < temperaturas.length; i++) {
            System.out.print(dias[i] + ": ");
            temperaturas[i] = scanner.nextDouble();
        }
    }
    
    private double calcularPromedio() {
        double suma = 0;
        for (double temp : temperaturas) {
            suma += temp;
        }
        return suma / temperaturas.length;
    }
    
    public void mostrarPromedio() {
        double promedio = calcularPromedio();
        System.out.printf("El promedio semanal de temperatura es: %.2f°C%n", promedio);
    }
    
    public double[] getTemperaturas() {
        return temperaturas.clone();
    }
}