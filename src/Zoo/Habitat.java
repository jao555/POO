package Zoo;

public class Habitat {
    private int id;
    private int capacity;
    public String name;
    private CleaningDays cleaningDay;
    private int numberAnimals;
    private Animal[] animalsInHabitat;



    public Habitat(int id, int capacity, String name, CleaningDays cleaningDay){
        this.id=id;
        this.capacity=capacity;
        this.name=textFormat.formatString(name);
        this.cleaningDay=cleaningDay;
        this.animalsInHabitat = new Animal[capacity];
        this.numberAnimals = 0;
    }

    //Getters y setters
    public int getId() {
        return id;
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
    public CleaningDays getCleaningDay() {
        return cleaningDay;
    }
    public void setCleaningDay(CleaningDays cleaningDay) {
        this.cleaningDay = cleaningDay;
    }

    public void cleaningVerification(CleaningDays cleaningDay){
        this.cleaningDay=cleaningDay;
        if(cleaningDay == CleaningDays.Monday || cleaningDay ==CleaningDays.Wendsday || cleaningDay==CleaningDays.Friday || cleaningDay == CleaningDays.Sunday){
            System.out.println("Es día de limpieza en " + this.name);
        }else{
            System.out.println("Hoy no se programo limpieza en " + this.name);
        }
    }

    public void addAnimals(Animal animal) throws ExtendedCapicityException{
        if (numberAnimals >= capacity) {

            throw new ExtendedCapicityException("La capacidad máxima del hábitat " + name + " fue excedida. No se puede agregar al animal: " + animal.getId());
        }
        animalsInHabitat[numberAnimals] = animal;
        numberAnimals++;
        System.out.println("Animal " + animal.getSpecies() + " agregado al hábitat " + name + ". Espacios disponibles: " + (capacity - numberAnimals));
    }

}
