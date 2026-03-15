package Zoo;

public class Habitat {
    private int id;
    private int capacity;
    public String name;
    private CleaningDays cleaningDay;
    private int numberAnimals;
    private int addAnimal;
    private int removeAnimal;

    public Habitat(int id, int capacity, String name, CleaningDays cleaningDay, int numberAnimals){
        this.id=id;
        this.capacity=capacity;
        this.name=textFormat.formatString(name);
        this.cleaningDay=cleaningDay;
        this.numberAnimals=numberAnimals;
    }

    public void cleaningVerification(CleaningDays cleaningDay){
        this.cleaningDay=cleaningDay;
        if(cleaningDay == CleaningDays.Monday || cleaningDay ==CleaningDays.Wendsday || cleaningDay==CleaningDays.Friday || cleaningDay == CleaningDays.Sunday){
            System.out.println("Es día de limpieza.");

        }else{
            System.out.println("Hoy no se programo limpieza.");
        }
    }

    public int addAnimals(int addAnimal){
        this.addAnimal=addAnimal;
        int totalAnimals=this.numberAnimals+addAnimal;
        if (totalAnimals>this.capacity) {
            throw new IllegalArgumentException("La capacidad máxima fue excedida. Ya no se puede agregar más animales");
        } else{
            this.numberAnimals=totalAnimals;
            if (this.numberAnimals==this.capacity){
                System.out.println("La capacidad máxima fue alcanzada.");
            }else{
                System.out.println("Animal agregado. Tiene "+(capacity-numberAnimals)+"espacios disponibles");
            }
        }
        return numberAnimals;
    }

    public int removeAnimals(int removeAnimal){
        this.removeAnimal=removeAnimal;
        int totalAnimals=this.numberAnimals-removeAnimal;
        if (totalAnimals < 0){
            throw new IllegalArgumentException("Habitat vacia. No puede remover animales.");
        }else{
            this.numberAnimals=totalAnimals;
            if(numberAnimals==0){
                System.out.println("Zoo.Habitat vacia. Tiene "+this.capacity+" espacios disponibles.");
            }else {
                System.out.println("Animal removido. Tiene "+(this.capacity-this.numberAnimals)+" espacios disponibles.");
            }
        }
        return numberAnimals;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
