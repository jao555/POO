public class Veterinario extends Empleado{
    private String especialidad;

    public Veterinario(int id,String name,String schedule,String especialidad){
        super(id,name,schedule);
        this.especialidad=especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

}
