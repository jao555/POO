public class Visitant extends Person {
    private static Integer NumVisitant = 0;

    public Visitant(String name, int id,int NumVisitant) {
        super(name, id);
    }

    public void Numclients (){
        NumVisitant++;
    }

    @Override
    public String toString() {
        String s = "El numero de visistantes hasta ahora es de " + NumVisitant;
        return s;
    }
}
