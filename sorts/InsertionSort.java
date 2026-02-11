public class InsertionSort<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(T[] array) {

        // Empezamos desde la posición 1 porque el primero se asume ordenado
        for (int i = 1; i < array.length; i++) {

            // Guardamos el valor actual
            T key = array[i];

            // Empezamos a comparar desde la posición anterior
            int j = i - 1;

            // Mientras el valor anterior sea mayor que el actual, lo movemos
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }

            // Colocamos el valor en su posición correcta
            array[j + 1] = key;
        }
    }
}
