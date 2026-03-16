package Zoo;

public class Empleado {
    private String name;
    private int id;
    private String schedule;

    public Empleado(int id,String name,String schedule){
        this.id=id;
        this.name=name;
        this.schedule=schedule;
    }
    //Getters y setters
    public String getName() {
        return name;
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

    public void realizarTrabajo(String actividad){
        System.out.println(name+'\''+ "realiza la actividad: "+ actividad);
    }

}
