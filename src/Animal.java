import java.util.Objects;

public abstract class Animal implements MedicalCare {
    private String id;
    private double weight;
    private int age;
    private String species;
    private ControlMedico[] medicalHistory;
    private State state;
    private int checkupCount;
    private String lastCheckup;
    private static int totalAnimals = 0;
    private boolean active;

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
    //getters and setters
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

    //métodos abstractos para subclases
    public abstract void count();
    public abstract void calculateFoodRation();

    public static int getTotalAnimals(){
        return totalAnimals;
    }

    //métdo de alimentacion
    public void comer(String comida){
        System.out.println(species + " con ID " + id + " está comiendo: " + comida);
    }

    @Override
    public void registerCheckup(ControlMedico control) {
        if (checkupCount >=medicalHistory.length) {
            //Redimensionamiento
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

    @Override
    public ControlMedico getMedicalHistory() {
        if (checkupCount == 0){
            return "Sin historial médico.";
        }
        String report = "Historial de " + id + ":\n";

        for (int i = 0; i < checkupCount; i++){
            report += "- " + medicalHistory[i] + "\n";
        }
        return report;
    }

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
        return "Animal{" +
                "id='" + id + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", species='" + species + '\'' +
                ", state=" + state +
                ", active=" + active +
                '}';
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
}
