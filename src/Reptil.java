public abstract class Reptil extends Animal{

    private static int totalReptiles = 0;
    private String scaleType;

    public Reptil(String id, double weight, int age, String species, String scaleType){
        super(id,weight, age, species);
        this.scaleType = scaleType;
        totalReptiles++;
    }

    @Override
    public double calculateFoodRation() {
        return this.getWeight() * 0.02;
    }
    @Override
    public void count() {
        System.out.println("Total de reptiles registrados: " + totalReptiles);
    }

    public String getScaleType() {
        return scaleType;
    }

    public static int getTotalReptiles() {
        return totalReptiles;
    }
}
