package semana2.tecnicasdepoo;

// ABSTRACCIÓN - Clase abstracta que define la estructura común
abstract class Empleado {
    // ENCAPSULACIÓN - Atributos privados
    private String nombre;
    private String id;
    private double salarioBase;
    
    // Constructor
    public Empleado(String nombre, String id, double salarioBase) {
        this.nombre = nombre;
        this.id = id;
        this.salarioBase = salarioBase;
    }
    
    // ENCAPSULACIÓN - Métodos getter y setter
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public double getSalarioBase() {
        return salarioBase;
    }
    
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    
    // ABSTRACCIÓN - Método abstracto que debe ser implementado por las subclases
    public abstract double calcularSalario();
    
    // ABSTRACCIÓN - Método abstracto para mostrar información específica
    public abstract void mostrarInformacion();
    
    // Método común para todos los empleados
    public void mostrarInformacionBasica() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Salario Base: $" + salarioBase);
    }
}

// HERENCIA - EmpleadoTiempoCompleto hereda de Empleado
class EmpleadoTiempoCompleto extends Empleado {
    private double bono;
    private int diasVacaciones;
    
    public EmpleadoTiempoCompleto(String nombre, String id, double salarioBase, double bono, int diasVacaciones) {
        super(nombre, id, salarioBase); // Llamada al constructor de la clase padre
        this.bono = bono;
        this.diasVacaciones = diasVacaciones;
    }
    
    // Getters y Setters
    public double getBono() {
        return bono;
    }
    
    public void setBono(double bono) {
        this.bono = bono;
    }
    
    public int getDiasVacaciones() {
        return diasVacaciones;
    }
    
    public void setDiasVacaciones(int diasVacaciones) {
        this.diasVacaciones = diasVacaciones;
    }
    
    // POLIMORFISMO - Implementación específica del método abstracto
    @Override
    public double calcularSalario() {
        return getSalarioBase() + bono;
    }
    
    // POLIMORFISMO - Implementación específica del método abstracto
    @Override
    public void mostrarInformacion() {
        System.out.println("=== EMPLEADO TIEMPO COMPLETO ===");
        mostrarInformacionBasica();
        System.out.println("Bono: $" + bono);
        System.out.println("Días de vacaciones: " + diasVacaciones);
        System.out.println("Salario Total: $" + calcularSalario());
        System.out.println("================================");
    }
}

// HERENCIA - EmpleadoPorHoras hereda de Empleado
class EmpleadoPorHoras extends Empleado {
    private int horasTrabajadas;
    private double tarifaPorHora;
    
    public EmpleadoPorHoras(String nombre, String id, double salarioBase, int horasTrabajadas, double tarifaPorHora) {
        super(nombre, id, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }
    
    // Getters y Setters
    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }
    
    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
    
    public double getTarifaPorHora() {
        return tarifaPorHora;
    }
    
    public void setTarifaPorHora(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }
    
    // POLIMORFISMO - Implementación específica del método abstracto
    @Override
    public double calcularSalario() {
        double salarioHoras = horasTrabajadas * tarifaPorHora;
        // Si trabaja más de 40 horas, recibe tiempo extra
        if (horasTrabajadas > 40) {
            double horasExtra = horasTrabajadas - 40;
            salarioHoras += horasExtra * tarifaPorHora * 0.5; // 50% extra por horas adicionales
        }
        return getSalarioBase() + salarioHoras;
    }
    
    // POLIMORFISMO - Implementación específica del método abstracto
    @Override
    public void mostrarInformacion() {
        System.out.println("=== EMPLEADO POR HORAS ===");
        mostrarInformacionBasica();
        System.out.println("Horas trabajadas: " + horasTrabajadas);
        System.out.println("Tarifa por hora: $" + tarifaPorHora);
        if (horasTrabajadas > 40) {
            System.out.println("Horas extra: " + (horasTrabajadas - 40));
        }
        System.out.println("Salario Total: $" + calcularSalario());
        System.out.println("==========================");
    }
}

// HERENCIA - Gerente hereda de EmpleadoTiempoCompleto
class Gerente extends EmpleadoTiempoCompleto {
    private String departamento;
    private int equipoACargo;
    private double bonoGerencial;
    
    public Gerente(String nombre, String id, double salarioBase, double bono, int diasVacaciones, 
                   String departamento, int equipoACargo, double bonoGerencial) {
        super(nombre, id, salarioBase, bono, diasVacaciones);
        this.departamento = departamento;
        this.equipoACargo = equipoACargo;
        this.bonoGerencial = bonoGerencial;
    }
    
    // Getters y Setters
    public String getDepartamento() {
        return departamento;
    }
    
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    public int getEquipoACargo() {
        return equipoACargo;
    }
    
    public void setEquipoACargo(int equipoACargo) {
        this.equipoACargo = equipoACargo;
    }
    
    public double getBonoGerencial() {
        return bonoGerencial;
    }
    
    public void setBonoGerencial(double bonoGerencial) {
        this.bonoGerencial = bonoGerencial;
    }
    
    // POLIMORFISMO - Sobreescritura del método calcularSalario
    @Override
    public double calcularSalario() {
        return super.calcularSalario() + bonoGerencial;
    }
    
    // POLIMORFISMO - Sobreescritura del método mostrarInformacion
    @Override
    public void mostrarInformacion() {
        System.out.println("=== GERENTE ===");
        mostrarInformacionBasica();
        System.out.println("Bono empleado: $" + getBono());
        System.out.println("Días de vacaciones: " + getDiasVacaciones());
        System.out.println("Departamento: " + departamento);
        System.out.println("Equipo a cargo: " + equipoACargo + " personas");
        System.out.println("Bono gerencial: $" + bonoGerencial);
        System.out.println("Salario Total: $" + calcularSalario());
        System.out.println("===============");
    }
}

// Clase para gestionar empleados
class GestorEmpleados {
    private Empleado[] empleados;
    private int contador;
    
    public GestorEmpleados(int capacidad) {
        empleados = new Empleado[capacidad];
        contador = 0;
    }
    
    public void agregarEmpleado(Empleado empleado) {
        if (contador < empleados.length) {
            empleados[contador] = empleado;
            contador++;
            System.out.println("Empleado agregado exitosamente: " + empleado.getNombre());
        } else {
            System.out.println("No se puede agregar más empleados. Capacidad máxima alcanzada.");
        }
    }
    
    // POLIMORFISMO - El método acepta cualquier tipo de Empleado
    public void mostrarTodosLosEmpleados() {
        System.out.println("\n=== LISTA DE TODOS LOS EMPLEADOS ===");
        for (int i = 0; i < contador; i++) {
            empleados[i].mostrarInformacion(); // Polimorfismo en acción
            System.out.println();
        }
    }
    
    public void calcularNominaTotal() {
        double nominaTotal = 0;
        for (int i = 0; i < contador; i++) {
            nominaTotal += empleados[i].calcularSalario(); // Polimorfismo en acción
        }
        System.out.println("Nómina total de la empresa: $" + nominaTotal);
    }
    
    public Empleado buscarEmpleadoPorId(String id) {
        for (int i = 0; i < contador; i++) {
            if (empleados[i].getId().equals(id)) {
                return empleados[i];
            }
        }
        return null;
    }
}

// Clase principal para probar el sistema - NOMBRE CORREGIDO
public class TecnicasdePOO {
    public static void main(String[] args) {
        // Crear gestor de empleados
        GestorEmpleados gestor = new GestorEmpleados(10);
        
        // Crear diferentes tipos de empleados
        EmpleadoTiempoCompleto emp1 = new EmpleadoTiempoCompleto(
            "Ana García", "EMP001", 3000.0, 500.0, 20
        );
        
        EmpleadoPorHoras emp2 = new EmpleadoPorHoras(
            "Carlos López", "EMP002", 800.0, 45, 15.0
        );
        
        Gerente gerente1 = new Gerente(
            "María Rodríguez", "GER001", 5000.0, 1000.0, 25, 
            "Tecnología", 8, 1500.0
        );
        
        EmpleadoPorHoras emp3 = new EmpleadoPorHoras(
            "Luis Martínez", "EMP003", 600.0, 35, 12.0
        );
        
        // Agregar empleados al gestor
        gestor.agregarEmpleado(emp1);
        gestor.agregarEmpleado(emp2);
        gestor.agregarEmpleado(gerente1);
        gestor.agregarEmpleado(emp3);
        
        // Mostrar todos los empleados (POLIMORFISMO en acción)
        gestor.mostrarTodosLosEmpleados();
        
        // Calcular nómina total
        gestor.calcularNominaTotal();
        
        // Buscar un empleado específico
        System.out.println("\n=== BÚSQUEDA DE EMPLEADO ===");
        Empleado empleadoBuscado = gestor.buscarEmpleadoPorId("EMP002");
        if (empleadoBuscado != null) {
            System.out.println("Empleado encontrado:");
            empleadoBuscado.mostrarInformacion();
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }
}