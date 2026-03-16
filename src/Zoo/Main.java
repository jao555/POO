package Zoo;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA ZOOLÓGICO ===");

        ZooManager manager = new ZooManager();
        Veterinario vet = new Veterinario(1, "Ana", "9-17", "Mamíferos");
        Animal leon = new Mammal("L001", 200, 5, "León", "Pelaje");
        Animal loro = new Bird("A001", 1.2, 2, "Loro", 0.5);

        try {
            manager.registrarEmpleado(vet);
            manager.registrarAnimal(leon);
            manager.registrarAnimal(loro);
            // manager.registrarAnimal(leon); // Descomentar para probar error duplicado
        } catch (RegistroDuplicadosException e) {
            System.out.println("❌ " + e.getMessage());
        }

        System.out.println("\n--- Prueba Hábitat ---");
        Habitat sabana = new Habitat(1, 1,"Agua", CleaningDays.Monday );
        try {
            sabana.addAnimals(leon);
            sabana.addAnimals(loro); // Falla: capacidad es 1
        } catch (ExtendedCapicityException e) {
            System.out.println("❌ " + e.getMessage());
        }

        System.out.println("\n--- Prueba Búsqueda y Eliminación Lógica ---");
        try {
            Animal encontrado = manager.buscarAnimalPorId("L001");
            System.out.println("✅ Encontrado: " + encontrado.getSpecies());

            manager.eliminarAnimal("L001"); // Eliminación lógica
            manager.buscarAnimalPorId("L001"); // Falla: inactivo
        } catch (InvalidAnimalException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
}