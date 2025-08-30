/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tareas.codigocorregido;

/**
 *
 * @author Asus
 */
import java.util.*;


public class CodigoCorregido {

    public static void main(String[] args) {

        // LISTA de nombres
        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Ana");

        // Corrección 1: Validar índice antes de acceder
        // El índice 3 no existe porque la lista tiene elementos en posiciones 0, 1 y 2.
        if (nombres.size() > 3) {
            System.out.println("Elemento en posicion 3: " + nombres.get(3));
        } else {
            System.out.println("No hay elemento en la posicion 3.");
        }

        // Corrección 2: Comparar cadenas con equals()
        // Usar == compara referencias, no contenido. equals() compara el texto.
        String buscado = new String("Ana");
        if (buscado.equals("Ana")) {
            System.out.println("Encontrado");
        }

        // MAPA de teléfonos
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("Ana", "0991111111");
        telefonos.put("Luis", "0992222222");

        // Corrección 3: Advertir sobrescritura
        // Se verifica si la clave ya existe antes de reemplazar su valor.
        if (telefonos.containsKey("Ana")) {
            System.out.println("Advertencia: numero de Ana sera reemplazado.");
        }
        telefonos.put("Ana", "0993333333");

        // Corrección 4: Validar existencia de clave antes de acceder
        // Si la clave "Bea" no existe, get() devuelve null y .toString() lanza excepción.
        if (telefonos.containsKey("Bea")) {
            System.out.println("Bea: " + telefonos.get("Bea"));
        } else {
            System.out.println("Bea no esta en el directorio.");
        }

        // SET de inscritos
        Set<Alumno> inscritos = new HashSet<>();
        inscritos.add(new Alumno(1, "Ana"));
        inscritos.add(new Alumno(2, "Luis"));
        inscritos.add(new Alumno(1, "Ana")); // duplicado lógico

        // Corrección 5: Implementar equals() y hashCode() en clase Alumno
        // Esto permite que HashSet detecte duplicados lógicos correctamente.

        System.out.println("Tamano del Set: " + inscritos.size());
        System.out.println(inscritos);
    }
}

// Clase Alumno con métodos para evitar duplicados lógicos en HashSet
class Alumno {
    int id;
    String nombre;

    Alumno(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alumno{id=" + id + ", nombre='" + nombre + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno)) return false;
        Alumno a = (Alumno) o;
        return id == a.id && Objects.equals(nombre, a.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}
