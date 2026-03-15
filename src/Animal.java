import java.util.Objects;

public abstract class Animal implements MedicalCare {
    private String id;
    private double weight;
    private int age;
    private String species;
    private String state;
    private String[] medicalHistory;
    private int checkupCount;
    private static int totalAnimals = 0;
    private boolean active;

    public Animal(String id, double weight, int age, String species){
        this.id = id;
        this.weight = weight;
        this.age = age;
        this.species = species;
        this.state = "despierto";
        this.medicalHistory = new String[5];
        this.checkupCount = 0;
        this.active = true;

        totalAnimals++;

    }

    public static int getTotalAnimals(){
        return totalAnimals;
    }

    public abstract double calculateFoodRation();

    @Override
    public void registerCheckup(String details) {
        if (checkupCount == medicalHistory.length){
            resizeHistory();
        }
        medicalHistory[checkupCount] = details;
        checkupCount++;
    }

    private void resizeHistory() {
        String[] newArray = new String[medicalHistory.length * 2];
        for (int i = 0; i < medicalHistory.length; i++) {
            newArray[i] = medicalHistory[i];
        }
        this.medicalHistory = newArray;
    }

    @Override
    public String getMedicalHistory() {
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
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id='" + id + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", species='" + species + '\'' +
                ", state='" + state + '\'' +
                ", active=" + active +
                '}';
    }

    public String getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
