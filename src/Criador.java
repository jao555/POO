public class Criador extends Empleado {

    private String workZone;

    public Criador(int id, String name, String schedule,String workZone){
        super(id,name,schedule);
        this.workZone=workZone;
    }
    //getters y setters
    public String getWorkZone() {
        return workZone;
    }
    public void setWorkZone(String workZone) {
        this.workZone = workZone;
    }

    public void alimentarAnimal(Animal animal, String comida) {
        System.out.println(getName() + " alimentó a " + animal.getId() + " con " + comida);
        animal.comer(comida);  // suponiendo metodo en animal
    }

    @Override
    public void realizarTrabajo(String actividad) {
        System.out.println(getName() + " está " +actividad+"en"+ workZone);
    }
}
