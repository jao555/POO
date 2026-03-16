package Zoo;

public class Main {
    public static void main(String[] args) {
        ZooManager manager = new ZooManager();

        // Demostración de Clase Utilitaria
        System.out.println("\nPrueba de Clase Utilitaria");
        String nombreDesordenado = "   aLeJAndro AlvARez   ";
        System.out.println("Texto original: " + nombreDesordenado + "");
        System.out.println("Texto formateado: " + textFormat.formatString(nombreDesordenado) + "");

        //Creación de Empleados y Polimorfismo
        System.out.println("\nCreación de Empleados ");
        Veterinario vet = new Veterinario(1, "Dra. Ana", "08:00-16:00", "Mamíferos");
        Criador criador = new Criador(2, "Carlos", "06:00-14:00", "Zona Norte");
        manager.registrarEmpleado(vet);
        manager.registrarEmpleado(criador);

        //Creación de Animales y Redimensionamiento
        System.out.println("\nRegistro de Animales y Redimensionamiento ");
        Animal leon = new Mammal("L001", 200, 5, "León", "Pelaje corto");
        Animal loro = new Bird("A001", 1.2, 2, "Loro", 0.5);
        // Creamos un tercer animal para forzar el redimensionamiento del array de tamaño inicial 2
        Animal elefante = new Mammal("E001", 3000, 10, "Elefante", "Piel gruesa");

        try {
            manager.registrarAnimal(leon);
            manager.registrarAnimal(loro);
            manager.registrarAnimal(elefante); // Aquí ocurre el redimensionamiento manual
            System.out.println("animales registrados");
        } catch (RegistroDuplicadosException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Manejo de Errores: Duplicados
        System.out.println("\nPrueba de Excepción: Registro Duplicado");
        try {
            manager.registrarAnimal(leon); // Intento de duplicado
        } catch (RegistroDuplicadosException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }

        // Manejo de Errores: Sobrecupo en Hábitats
        System.out.println("\nPrueba de Hábitat y Capacidad");
        Habitat sabana = new Habitat(1, 2, "Sabana Africana", CleaningDays.Monday);
        try {
            sabana.addAnimals(leon);
            sabana.addAnimals(elefante);
            //Se intenta agregar un tercer animal al habitat pero no se puede
            sabana.addAnimals(loro); // Esto fallará y lanzará ExtendedCapicityException
        } catch (ExtendedCapicityException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        // Interfaz y Redimensionamiento de Historial Médico
        System.out.println("\n Atención Médica e Historial ");
        ControlMedico control1 = new ControlMedico("2026-03-10", "Vacunación anual", vet);
        ControlMedico control2 = new ControlMedico("2026-03-15", "Revisión dental", vet);
        ControlMedico control3 = new ControlMedico("2026-04-01", "Control de peso", vet);

        vet.registerCheckup(leon, control1);
        vet.registerCheckup(leon, control2);
        vet.registerCheckup(leon, control3); // Aquí ocurre el redimensionamiento del historial

        System.out.println("\nReporte Médico del León:");
        System.out.println(leon.generateMedicalReport());

        //Acciones de empleados (Alimentación)
        System.out.println("Acciones de Criadores");
        criador.alimentarAnimal(leon, "15kg de carne");

        // Búsqueda y Eliminación Lógica
        System.out.println("\nBúsqueda y Eliminación Lógica");
        try {
           //Buscar animal con la ID L001
            Animal encontrado = manager.buscarAnimalPorId("L001");
            System.out.println("Animal encontrado: " + encontrado.toString());

            //Eliminación del animal con codigo L001
            manager.eliminarAnimal("L001"); // Cambia active a false

            //Se intenta buscar el id luego de eliminarlo
            manager.buscarAnimalPorId("L001"); // Debe fallar porque está inactivo
        } catch (InvalidAnimalException e) {
            System.out.println("Excepción capturada : " + e.getMessage());
        }




    }
}