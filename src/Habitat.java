public class Habitat {
    private int id;
    private int capacity;
    public String type;
    private String cleaningDay;
    private int numberAnimals;

    public Habitat(int id, int capacity, String type, String cleaningDay, int numberAnimals){
        this.id=id;
        this.capacity=capacity;
        this.type=type;
        this.cleaningDay=cleaningDay;
        this.numberAnimals=numberAnimals;
    }

    public void cleaningVerification(String cleaningDay){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCleaningDay() {
        return cleaningDay;
    }

    public void setCleaningDay(String cleaningDay) {
        this.cleaningDay = cleaningDay;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNumberAnimals() {
        return numberAnimals;
    }

    public void setNumberAnimals(int numberAnimals) {
        this.numberAnimals = numberAnimals;
    }
}
