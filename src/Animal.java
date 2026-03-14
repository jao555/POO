public abstract class Animal implements MedicalCare {
    private String id;
    private double weight;
    private int age;
    private String species;
    private ControlMedico[] medicalHistory;
    private int checkupCount;
    private String lastCheckup;

    public Animal(String id, double weight, int age, String species){
        this.id = id;
        this.weight = weight;
        this.age = age;
        this.species = species;
        this.medicalHistory = new ControlMedico[2]; //Empieza con 2 registros
        this.checkupCount = 0;
        this.lastCheckup = "None";

    }
    //getters and setters
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
    public void setSpecies(String species) {
        this.species = species;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    //métodos abstractos para subclases
    public abstract void count();
    public abstract void calculateFoodRation();

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
    public ControlMedico[] getMedicalHistory() {
        return this.medicalHistory;
    }
    public String getLastCheckup() {
        return lastCheckup;
    }
}
