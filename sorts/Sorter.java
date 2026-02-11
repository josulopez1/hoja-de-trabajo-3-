// Esta interfaz define el método que deben tener todas las clases que implementen un algoritmo de ordenamiento.
public interface Sorter<T extends Comparable<T>> {

    // Método para ordenar un arreglo.
    void sort(T[] array);
}
