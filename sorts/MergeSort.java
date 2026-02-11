public class MergeSort<T extends Comparable<T>> implements Sorter<T> {

    // Este método es el que se llama para empezar a ordenar
    @Override
    public void sort(T[] array) {
        // Si el arreglo tiene menos de 2 elementos, no se necesita ordenar
        if (array.length < 2) return;

        // Llamamos al método recursivo pasando el inicio y el final del arreglo
        mergeSort(array, 0, array.length - 1);
    }

    // Método recursivo que divide el arreglo en partes más pequeñas
    private void mergeSort(T[] arr, int left, int right) {
        // Si ya no se puede dividir más se termina
        if (left >= right) return;

        // Calculamos el punto medio
        int mid = (left + right) / 2;

        // Ordenamos la mitad izquierda
        mergeSort(arr, left, mid);

        // Ordenamos la mitad derecha
        mergeSort(arr, mid + 1, right);

        // Unimos las dos mitades ya ordenadas
        merge(arr, left, mid, right);
    }

    // Este método une las dos mitades en orden
    private void merge(T[] arr, int left, int mid, int right) {

        // Creamos un arreglo temporal para guardar los elementos ordenados
        Object[] temp = new Object[right - left + 1];

        // i recorre la parte izquierda
        // j recorre la parte derecha
        // k recorre el arreglo temporal
        int i = left, j = mid + 1, k = 0;

        // Comparamos los elementos de las dos mitades
        while (i <= mid && j <= right) {
            // Si el elemento izquierdo es menor o igual, lo guardamos
            if (arr[i].compareTo(arr[j]) <= 0) {
                temp[k++] = arr[i++];
            } else {
                // Si no, guardamos el de la derecha
                temp[k++] = arr[j++];
            }
        }

        // Si sobran elementos en la izquierda, los agregamos
        while (i <= mid) temp[k++] = arr[i++];

        // Si sobran elementos en la derecha, los agregamos
        while (j <= right) temp[k++] = arr[j++];

        // Copiamos los elementos ordenados de nuevo al arreglo original
        for (int m = 0; m < temp.length; m++) {
            arr[left + m] = (T) temp[m];
        }
    }
}
