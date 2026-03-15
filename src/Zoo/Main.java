package Zoo;

public class Main {
    static void main(String[] args){
        Habitat habitat1 = new Habitat(1,100,"mariposario",CleaningDays.Monday,80);
        System.out.println(habitat1.getId());
        //habitat1.addAnimals(30);
        System.out.println(habitat1.getCapacity());

    }
}
