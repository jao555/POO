public class Mammal extends Animal {

    private String furType;
    private static int totalMammals = 0;

    public Mammal(String id, double weight, int age, String species, String furType) {
        super(id, weight, age, species);
        this.furType = furType;
        totalMammals++;
    }

    public static int getTotalMammals() {
        return totalMammals;
    }
    // Implementación del método abstracto de Animal
    @Override
    public void count() {
        System.out.println("Total de mamíferos registrados: " + totalMammals);
    }

    public String getFurType() {
        return furType;
    }

    @Override
    public double calculateFoodRation() {
        return this.getWeight() * 0.05;
    }
}
