package Zoo;

public class Veterinario extends Empleado{
    private String especialidad;

    public Veterinario(int id,String name,String schedule,String especialidad){
        super(id,name,schedule);
        this.especialidad=especialidad;
    }

    //Getters
    public String getEspecialidad() {
        return especialidad;
    }

    //Método para registrar un chequeo de un animal en el array de objetos controlMedico
    public void registerCheckup(Animal animal, ControlMedico control) {
        animal.registerCheckup(control);
        System.out.println(getName() + " registró un chequeo a " + animal.getId());
    }

    @Override
    public void realizarTrabajo(String actividad) {
        System.out.println(getName() + " está realizando chequeos veterinarios");
    }

}
