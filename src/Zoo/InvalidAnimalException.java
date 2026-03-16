package Zoo;

//Excepcion personalizada para identificar errores de busqueda.
public class InvalidAnimalException extends RuntimeException {
    //Mensaje de invalidación de busqueda.
    public InvalidAnimalException(String message) {
        super(message);
    }
}
