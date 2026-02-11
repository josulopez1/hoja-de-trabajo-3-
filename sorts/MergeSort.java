public class MergeSort<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(T[] array) {
        if (array.length < 2) return;
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(T[] arr, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(T[] arr, int left, int mid, int right) {
        Object[] temp = new Object[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i].compareTo(arr[j]) <= 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int m = 0; m < temp.length; m++) {
            arr[left + m] = (T) temp[m];
        }
    }
}