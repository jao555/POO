public abstract class Reptil extends Animal{

    private static int totalReptiles = 0;

    public Reptil(String id, double weight, int age, String species){
        super(id,weight, age, species);

        totalReptiles++;
    }

    @Override
    public double calculateFoodRation() {
        return this.getWeight() * 0.02;
    }
    @Override
    public void count() {
        System.out.println("Total de mamíferos registrados: " + totalReptiles);
    }

    public static int getTotalReptiles() {
        return totalReptiles;
    }
}
