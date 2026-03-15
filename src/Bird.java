public class Bird extends Animal{

    private static int totalBirds = 0;

    public Bird(String id, double weight, int age, String species){
        super(id, weight, age, species);

        totalBirds++;
    }

    @Override
    public double calculateFoodRation() {
        return this.getWeight() * 0.10;
    }

    public static int getTotalBirds() {
        return totalBirds;
    }
}
