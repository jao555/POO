package Zoo;

public class Visitante {
    private String id;
    private String nombre;
    private  String tipoEntrada;
    private boolean active;

    public Visitante (String id, String nombre, String tipoEntrada){
        this.id = id;
        this.nombre = textFormat.formatString(nombre);
        this.tipoEntrada = tipoEntrada;
        this.active = true;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public boolean isActive() {
        return active;
    }

    public void registrarSalida() {
        this.active = false;
        System.out.println("El visitante " + nombre + " ha salido del zoológico (Eliminación lógica).");
    }

    @Override
    public String toString() {
        return "Visitante{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipoEntrada='" + tipoEntrada + '\'' +
                ", active=" + active +
                '}';
    }
}
