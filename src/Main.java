import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Toy> toys = ToyLoader.loadFromFile("toys.txt");
        ToyLottery toyLottery = new ToyLottery();
        toys.forEach(toyLottery::add);

        Map<Integer, Integer> resultMap = new HashMap<>();
        toys.forEach(toy -> resultMap.put(toy.getId(), 0));

        for (int i = 0; i < 10; i++) {
            int toyId = toyLottery.getRandomToyId();
            resultMap.put(toyId, resultMap.get(toyId) + 1);
        }
        ResultsWriter.writeResultsToFile(resultMap, toys, "results.txt");
        System.out.println("Результаты розыгрыша сохранены в файле 'results.txt'");
        System.out.println("");
        System.out.println("Результаты розыгрыша:");
        resultMap.forEach((id, count) -> {
            Toy toy = toys.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
            if (toy != null) {
                System.out.printf("Игрушка: %s (ID: %d) - выпала %d раз(а)%n", toy.getName(), id, count);
            }
        });
    }
}
