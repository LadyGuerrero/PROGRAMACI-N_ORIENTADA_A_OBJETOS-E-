/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tareas.calculadorarea;

/**
 *
 * Programa sencillo que calcula el área de un rectángulo
 * usando diferentes tipos de datos en Java.
 */
public class CalculadorArea {

    public static void main(String[] args) {
       // Variables con diferentes tipos de datos
        String mensaje_programa = "Calculando área del rectángulo...";  // String
        float largo_valor = 8.5f;                                       // float
        float ancho_valor = 4.2f;                                       // float
        int numero_rectangulo = 1;                                       // int
        boolean calcular_ahora = true;                                   // boolean
        
        // Mostrar mensaje
        System.out.println(mensaje_programa);
        
        // Crear rectángulo y calcular área
        if (calcular_ahora) {
            Rectangulo rectangulo_ejemplo = new Rectangulo(largo_valor, ancho_valor);
            float area_total = rectangulo_ejemplo.calcular_area();
            
            // Mostrar resultado
            System.out.println("Rectángulo " + numero_rectangulo);
            System.out.println("Largo: " + largo_valor + " metros");
            System.out.println("Ancho: " + ancho_valor + " metros");
            System.out.println("Área: " + area_total + " metros cuadrados");
        }
    }
}
