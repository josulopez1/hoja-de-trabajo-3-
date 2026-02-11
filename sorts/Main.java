import utils.FileManager;
import utils.RadixSort;

public class Main {

    public static void main(String[] args) throws Exception {

        int[] sizes = {10, 100, 500, 1000, 2000, 3000};

        for (int size : sizes) {
            String file = "numbers.txt";

            FileManager.writeRandomNumbers(file, size);
            Integer[] data = FileManager.readNumbers(file);

            run("Gnome", new GnomeSort<>(), data.clone());
            run("Insertion", new InsertionSort<>(), data.clone());
            run("Merge", new MergeSort<>(), data.clone());
            run("Quick", new QuickSort<>(), data.clone());

            RadixSort radix = new RadixSort();
            Integer[] rdata = data.clone();

            long start = System.nanoTime();
            radix.sort(rdata);
            long end = System.nanoTime();

            System.out.println("Radix | n=" + size + " | " + (end - start));
            System.out.println("----");
        }
    }

    private static void run(String name, Sorter<Integer> sorter, Integer[] arr) {
        long start = System.nanoTime();
        sorter.sort(arr);
        long end = System.nanoTime();
        System.out.println(name + " | n=" + arr.length + " | " + (end - start));
    }
}