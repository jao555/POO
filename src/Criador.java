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
}
