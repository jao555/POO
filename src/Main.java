public class Main {
    public static void main(String[] args){
        // 1️⃣ Crear empleados
        Veterinario vet = new Veterinario(1, "Ana", "9-17", "Mamíferos");
        Criador criador = new Criador(2, "Carlos", "8-16", "Zona A");

        // 2️⃣ Crear animales
        Mammal leon = new Mammal("L001", 200, 5, "León");
        Mammal loro = new Mammal("A001", 1.2, 2, "Loro");
        Mammal pezPayaso = new Mammal("P001", 0.5, 1, "Pez Payaso");

        // Veterinario regijhstra chequeos
        ControlMedico checkLeon = new ControlMedico("2026-03-13", "Chequeo normal", vet);
        ControlMedico checkLoro = new ControlMedico("2026-03-13", "Alas saludables", vet);
        ControlMedico checkLeon2 = new ControlMedico("2026-03-13", "Chequeo dientes", vet);

        vet.registerCheckup(leon, checkLeon);
        vet.registerCheckup(leon,checkLeon2);
        vet.registerCheckup(loro, checkLoro);

        // Criador alimenta animales
        criador.realizarTrabajo("alimentación");
        leon.comer("Carne");
        loro.comer("Semillas");
        pezPayaso.comer("Alimento para peces");

        // Mostrar historial médico de animales
        System.out.println("\nHistorial de " + leon.getSpecies() + ":");
        for (ControlMedico c : leon.getMedicalHistory()) {
            if (c != null) System.out.println(c);
        }

        System.out.println("\nHistorial de " + loro.getSpecies() + ":");
        for (ControlMedico c : loro.getMedicalHistory()) {
            if (c != null) System.out.println(c);
        }

        // Veterinario realiza trabajo
        vet.realizarTrabajo("chequeos veterinarios");
    }
}
