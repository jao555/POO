package Zoo;

public class Mammal extends Animal {

    private static int totalMammals = 0;

    public Mammal(String id, double weight, int age, String species) {
        super(id, weight, age, species);
        totalMammals++;
    }

    public static int getTotalMammals() {
        return totalMammals;
    }
    // Implementación del método abstracto de Zoo.Animal
    @Override
    public void count() {
        System.out.println("Total de mamíferos registrados: " + totalMammals);
    }

    @Override
    public double calculateFoodRation() {
        return this.getWeight() * 0.05;
    }
}
