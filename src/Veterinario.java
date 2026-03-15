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

    public void registerCheckup(Animal animal, ControlMedico control) {
        animal.registerCheckup(control);
        System.out.println(getId() + " registró un chequeo a " + animal.getId());
    }

    @Override
    public void realizarTrabajo(String actividad) {
        System.out.println(getId() + " está realizando chequeos veterinarios");
    }

}
