public class Bird extends Animal{

    private double wingspan;
    private static int totalBirds = 0;

    public Bird(String id, double weight, int age, String species, double wingspan){
        super(id, weight, age, species);

        this.wingspan = wingspan;
        totalBirds++;
    }

    @Override
    public double calculateFoodRation() {
        return this.getWeight() * 0.10;
    }
    @Override
    public void count() {
        System.out.println("Total de aves registrados: " + totalBirds);
    }

    public double getWingspan() {
        return wingspan;
    }

    public static int getTotalBirds() {
        return totalBirds;
    }

}
