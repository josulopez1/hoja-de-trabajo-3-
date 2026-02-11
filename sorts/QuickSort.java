public class QuickSort<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Método recursivo que divide el arreglo.
    private void quickSort(T[] arr, int low, int high) {

        if (low < high) {

            // Obtiene la posición correcta del pivote.
            int p = partition(arr, low, high);

            // Ordena las dos partes.
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    // Reorganiza el arreglo usando un pivote.
    private int partition(T[] arr, int low, int high) {

        T pivot = arr[high];
        int i = low - 1;

        // Coloca los elementos menores al pivote a la izquierda.
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Coloca el pivote en su posición final.
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
