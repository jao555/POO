public abstract class Animal implements MedicalCare {
    private String id;
    private double weight;
    private int age;
    private String species;
    private String[] medicalHistory;
    private int checkupCount;
    private String lastCheckup;

    public Animal(String id, double weight, int age, String species){
        this.id = id;
        this.weight = weight;
        this.age = age;
        this.species = species;
        this.medicalHistory = new String[2];
        this.checkupCount = 0;
        this.lastCheckup = "None";

    }

    public String getId() {
        return id;
    }

    public abstract void count();

    public abstract void calculateFoodRation();
}
