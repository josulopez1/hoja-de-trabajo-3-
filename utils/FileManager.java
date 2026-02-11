import java.io.*;
import java.util.*;

// Esta clase se encarga de manejar archivos.
// Permite escribir números aleatorios en un archivo y también leer números desde un archivo.
public class FileManager {

    // Escribe una cantidad de números aleatorios en un archivo de texto.
    public static void writeRandomNumbers(String filename, int amount) throws IOException {

        Random rand = new Random();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            for (int i = 0; i < amount; i++) {
                writer.write(String.valueOf(rand.nextInt(10000)));
                writer.newLine();
            }
        }
    }

    // Lee números desde un archivo y los guarda en un arreglo de Integer.
    public static Integer[] readNumbers(String filename) throws IOException {

        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        }

        return numbers.toArray(new Integer[0]);
    }
}
