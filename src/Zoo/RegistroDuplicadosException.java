package Zoo;

//Excepcion personalizada para controlar que no se repitan las ID
public class RegistroDuplicadosException extends RuntimeException {
    //Descripción del error
    public RegistroDuplicadosException(String message) {
        super(message);
    }
}
