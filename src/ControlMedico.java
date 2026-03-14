public class ControlMedico {
    private String fecha;
    private String observacion;
    private Veterinario veterinario;

    public ControlMedico(String fecha, String observacion, Veterinario veterinario) {
        this.fecha = fecha;
        this.observacion = observacion;
        this.veterinario = veterinario;
    }

    //Getters y setters
    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public Veterinario getVeterinario() {
        return veterinario;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "ControlMedico{" +
                "fecha='" + fecha + '\'' +
                ", observacion='" + observacion + '\'' +
                ", veterinario=" + veterinario.getName() +
                '}';
    }
}
