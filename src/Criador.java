public class Criador extends Empleado {

    private String workZone;

    public Criador(int id, String name, String schedule,String workZone){
        super(id,name,schedule);
        this.workZone=workZone;
    }

    public String getWorkZone() {
        return workZone;
    }

    public void setWorkZone(String workZone) {
        this.workZone = workZone;
    }

    public void alimentarAnimal(Animal animal, String comida) {
        System.out.println(getName() + " alimentó a " + animal.getId() + " con " + comida);
        animal.comer(comida);  // suponiendo método en Animal
    }

    @Override
    public void realizarTrabajo() {
        System.out.println(getName() + " está alimentando animales en " + workZone);
    }
}
