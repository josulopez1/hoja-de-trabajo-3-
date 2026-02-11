// Esta clase implementa el algoritmo Radix Sort.
// Ordena números enteros usando sus dígitos (unidades, decenas, centenas, etc.).
public class RadixSort {

    // Método principal que ejecuta el algoritmo.
    public void sort(Integer[] array) {

        // Primero encuentra el número más grande.
        int max = getMax(array);

        // Ordena por cada dígito usando count sort.
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(array, exp);
        }
    }

    // Encuentra el valor máximo del arreglo.
    private int getMax(Integer[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    // Ordena el arreglo según el dígito actual.
    private void countSort(Integer[] arr, int exp) {

        int n = arr.length;
        Integer[] output = new Integer[n];
        int[] count = new int[10];

        // Cuenta cuántas veces aparece cada dígito.
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Acumula las posiciones.
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construye el arreglo ordenado.
        for (int i = n - 1; i >= 0; i--) {
            int idx = (arr[i] / exp) % 10;
            output[count[idx] - 1] = arr[i];
            count[idx]--;
        }

        // Copia el resultado al arreglo original.
        System.arraycopy(output, 0, arr, 0, n);
    }
}
