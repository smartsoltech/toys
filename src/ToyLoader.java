import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToyLoader {
    public static List<Toy> loadFromFile(String fileName) {
        List<Toy> toys = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                int weight = Integer.parseInt(parts[2].trim());
                toys.add(new Toy(id, name, weight));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toys;
    }
}
