import java.util.PriorityQueue;
import java.util.Random;

public class ToyLottery {
    private PriorityQueue<Toy> queue;

    public ToyLottery() {
        queue = new PriorityQueue<>((a, b) -> b.getWeight() - a.getWeight());
    }

    public void add(Toy toy) {
        queue.add(toy);
    }

    public int getRandomToyId() {
        int totalWeight = queue.stream().mapToInt(Toy::getWeight).sum();
        int randomValue = new Random().nextInt(totalWeight);
        int currentWeight = 0;
        for (Toy toy : queue) {
            currentWeight += toy.getWeight();
            if (randomValue < currentWeight) {
                return toy.getId();
            }
        }
        return -1;
    }
}
