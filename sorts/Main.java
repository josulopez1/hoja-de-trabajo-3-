import utils.FileManager;
import utils.RadixSort;

public class Main {

    public static void main(String[] args) throws Exception {

        // Diferentes tamaños de arreglo que vamos a probar
        int[] sizes = {10, 100, 500, 1000, 2000, 3000};

        // Recorremos cada tamaño
        for (int size : sizes) {

            // Nombre del archivo donde se guardan los números
            String file = "numbers.txt";

            // Genera números aleatorios y los guarda en el archivo
            FileManager.writeRandomNumbers(file, size);

            // Lee los números del archivo y los guarda en un arreglo
            Integer[] data = FileManager.readNumbers(file);

            // Ejecuta cada algoritmo y mide su tiempo
            run("Gnome", new GnomeSort<>(), data.clone());
            run("Insertion"
