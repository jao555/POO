package Zoo;

public class ZooManager {

    //Definición de arreglos con dos espacios y auxiliares para redimensionar
    private Animal[] todosLosAnimales = new Animal[2];
    private int cantidadAnimales = 0;

    private Empleado[] todosLosEmpleados = new Empleado[2];
    private int cantidadEmpleados = 0;

    private Visitante[] todosLosVisitantes = new Visitante[2];
    private int cantidadVisitantes = 0;

    // Gesstion de animales:-Aqui verificamos que no se repita la ID de un animal.
    //tambien se hace el redimensionamiento del arreglo de objetos.

    public void registrarAnimal(Animal animal) throws RegistroDuplicadosException {
        for (int i = 0; i < cantidadAnimales; i++) {
            if (todosLosAnimales[i].equals(animal)) {
                throw new RegistroDuplicadosException("Error: El animal con ID " + animal.getId() + " ya está registrado.");
            }
        }
        if (cantidadAnimales >= todosLosAnimales.length) {
            Animal[] nuevoArray = new Animal[todosLosAnimales.length * 2];
            for (int i = 0; i < todosLosAnimales.length; i++) {nuevoArray[i] = todosLosAnimales[i];}
            todosLosAnimales = nuevoArray;
        }
        todosLosAnimales[cantidadAnimales] = animal;
        cantidadAnimales++;
    }

    //Gestion de busqueda de animales
    public Animal buscarAnimalPorId(String id) throws InvalidAnimalException {
        for (int i = 0; i < cantidadAnimales; i++) {
            if (todosLosAnimales[i] != null && todosLosAnimales[i].getId().equals(id) && todosLosAnimales[i].isActive()) {
                return todosLosAnimales[i];
            }
        }
        throw new InvalidAnimalException("Animal " + id + " no encontrado o inactivo.");
    }

    //Eliminación de ID
    public void eliminarAnimal(String id) {
        try {
            Animal animal = buscarAnimalPorId(id);
            animal.darDeBaja();
        } catch (InvalidAnimalException e) {
            System.out.println(e.getMessage());
        }
    }

    //Gestion registro de empleados:-Se redimensiona el array
    public void registrarEmpleado(Empleado empleado) {
        if (cantidadEmpleados >= todosLosEmpleados.length) {
            Empleado[] nuevoArray = new Empleado[todosLosEmpleados.length * 2];
            for (int i = 0; i < todosLosEmpleados.length; i++) nuevoArray[i] = todosLosEmpleados[i];
            todosLosEmpleados = nuevoArray;
        }
        todosLosEmpleados[cantidadEmpleados] = empleado;
        cantidadEmpleados++;
    }

    //Gestion registro de visitante
    public void registrarVisitante(Visitante visitante) {
        if (cantidadVisitantes >= todosLosVisitantes.length) {
            Visitante[] nuevoArray = new Visitante[todosLosVisitantes.length * 2];
            for (int i = 0; i < todosLosVisitantes.length; i++) nuevoArray[i] = todosLosVisitantes[i];
            todosLosVisitantes = nuevoArray;
        }
        todosLosVisitantes[cantidadVisitantes] = visitante;
        cantidadVisitantes++;
    }
}