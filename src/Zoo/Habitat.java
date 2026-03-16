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

    public void removeAnimal(String animalId) throws InvalidAnimalException {
        boolean encontrado = false;

        for (int i = 0; i < numberAnimals; i++) {
            // Buscamos al animal por su ID
            if (animalsInHabitat[i] != null && animalsInHabitat[i].getId().equals(animalId)) {
                encontrado = true;

                // Desplazamos todos los animales un espacio hacia la izquierda para tapar el hueco
                for (int j = i; j < numberAnimals - 1; j++) {
                    animalsInHabitat[j] = animalsInHabitat[j + 1];
                }

                // Vaciamos la última posición y reducimos el contador
                animalsInHabitat[numberAnimals - 1] = null;
                numberAnimals--;

                System.out.println("El animal " + animalId + " ha sido retirado del hábitat " + name + ". Espacios disponibles: " + (capacity - numberAnimals));
                break; // Terminamos el ciclo porque ya lo encontramos y sacamos
            }
        }

        // Si termina el ciclo y no lo encontró, lanzamos excepción
        if (!encontrado) {
            throw new InvalidAnimalException("Error: El animal " + animalId + " no se encuentra en el hábitat " + name + ".");
        }
    }

}
