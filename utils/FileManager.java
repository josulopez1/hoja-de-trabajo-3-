import java.io.*;
import java.util.*;

public class FileManager {

    public static void writeRandomNumbers(String filename, int amount) throws IOException {
        Random rand = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < amount; i++) {
                writer.write(String.valueOf(rand.nextInt(10000)));
                writer.newLine();
            }
        }
    }

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