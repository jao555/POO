package Zoo;

public class ZooManager {
    private Animal[] todosLosAnimales;
    private int cantidadAnimales;

    public ZooManager(){
        this.todosLosAnimales = new Animal[2];
        this.cantidadAnimales = 0;
    }

    public int getCantidadAnimales() {
        return cantidadAnimales;
    }

    // REDIMENSIONAMIENTO MANUAL
    public void registrarAnimal(Animal animal) {
        if (cantidadAnimales >= todosLosAnimales.length) {
            Animal[] nuevoArray = new Animal[todosLosAnimales.length * 2];
            for (int i = 0; i < todosLosAnimales.length; i++) {
                nuevoArray[i] = todosLosAnimales[i];
            }
            todosLosAnimales = nuevoArray;
            System.out.println(">> Sistema: Array de animales redimensionado a " + todosLosAnimales.length);
        }
        todosLosAnimales[cantidadAnimales] = animal;
        cantidadAnimales++;
    }

    // BÚSQUEDA
    public Animal buscarAnimalPorId(String id) throws EntidadNoEncontradaException {
        for (int i = 0; i < cantidadAnimales; i++) {
            if (todosLosAnimales[i] != null &&
                    todosLosAnimales[i].getId().equals(id) &&
                    todosLosAnimales[i].isActive()) {
                return todosLosAnimales[i];
            }
        }
        throw new EntidadNoEncontradaException("El animal con ID " + id + " no fue encontrado o está inactivo.");
    }

    // ELIMINACIÓN LÓGICA
    public void eliminarAnimal(String id) {
        try {
            Animal animalAEliminar = buscarAnimalPorId(id);
            animalAEliminar.darDeBaja();
        } catch (EntidadNoEncontradaException e) {
            System.out.println("Error al intentar eliminar: " + e.getMessage());
        }
    }

}
