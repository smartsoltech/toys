import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ResultsWriter {
    public static void writeResultsToFile(Map<Integer, Integer> resultMap, List<Toy> toys, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Результаты розыгрыша:\n");
            resultMap.forEach((id, count) -> {
                Toy toy = toys.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
                if (toy != null) {
                    try {
                        writer.write(String.format("Игрушка: %s (ID: %d) - выпала %d раз(а)%n", toy.getName(), id, count));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
