package Zoo;

import java.util.Objects;

public abstract class Animal implements MedicalCare {
    private String id;
    private double weight;
    private int age;
    private String species;
    private ControlMedico[] medicalHistory;
    private State state;
    private int checkupCount;  //contador para redimendionamiento del array
    private String lastCheckup;
    private static int totalAnimals = 0;
    private boolean active;  //Atributo para eliminacion

    //Constructor
    public Animal(String id, double weight, int age, String species){
        this.id = id;
        this.weight = weight;
        this.age = age;
        this.species = species;
        this.medicalHistory = new ControlMedico[2]; //Empieza con 2 registros
        this.state = State.DESPIERTO;
        this.checkupCount = 0;
        this.lastCheckup = "None";
        this.active = true;
        totalAnimals++;

    }
    //getters
    public double getWeight() {
        return weight;
    }
    public int getAge() {
        return age;
    }
    public String getSpecies() {
        return species;
    }
    public String getId() {
        return id;
    }
    public static int getTotalAnimals(){
        return totalAnimals;
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public String getLastCheckup() {
        return lastCheckup;
    }

    //métodos abstractos para subclases
    public abstract void count();
    public abstract double calculateFoodRation();

    //Registro de un chequeo médico(redimensionamiento del array)
    @Override
    public void registerCheckup(ControlMedico control) {
        if (checkupCount >=medicalHistory.length) {
            //Redimensionamiento con duplicado
            ControlMedico[] newArray = new ControlMedico[medicalHistory.length * 2];
            for(int i = 0; i < medicalHistory.length; i++) {
                newArray[i] = medicalHistory[i];
            }
            medicalHistory=newArray;
        }
        medicalHistory[checkupCount] = control;
        checkupCount++;
        lastCheckup=control.getFecha();
    }

    //Genera un reporte detallado del historial médico
    public String generateMedicalReport() {
        if (checkupCount == 0) return "Sin historial médico.";

        String report = "Historial de " + id + ":\n";
        for (int i = 0; i < checkupCount; i++) {
            report += "- " + medicalHistory[i].toString() + "\n";
        }
        return report;
    }

    @Override
    public ControlMedico[] getMedicalHistory() {
        return medicalHistory;
    }

    //Sobreescritura de métodos de la clase object.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Zoo.Animal{" +
                "id='" + id + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", species='" + species + '\'' +
                ", state=" + state +
                ", active=" + active +
                '}';
    }

}
