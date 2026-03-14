public interface MedicalCare {
    void registerCheckup(ControlMedico control);
    ControlMedico[] getMedicalHistory();         // devuelve un array de objetos ControlMedico
}
