public class Empleado extends Person{
    private int horaInicio;
    private int horaFinal;

    private String schedule;


    public Empleado(int id, String name, String schedule) {
        super(name, id);
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void registrarTrabajo(String actividad){
        System.out.println(name + "registro la actividad: "+ actividad);
    }

}
