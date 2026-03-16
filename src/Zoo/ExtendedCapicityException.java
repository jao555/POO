package Zoo;
//Excepcion personalizada para verificar que no se exceda la capacidad de un habitat
public class ExtendedCapicityException extends RuntimeException {
    public ExtendedCapicityException(String message) {
        super(message);
    }
}
