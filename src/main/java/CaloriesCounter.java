import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CaloriesCounter {
    public int calcHighestCalories(String input) {
        String[] split = input.split("\n");
        int highestCalories = 0;
        int currentCalories = 0;
        for (String s : split) {
            if (!s.isBlank()) {
                currentCalories += Integer.parseInt(s);
            } else {
                highestCalories = Math.max(highestCalories, currentCalories);
                currentCalories = 0;
            }
        }
        return highestCalories;
    }

    public int getTopThree(String input) {
        List<Integer> highestThree = new LinkedList<>();
        String[] split = input.split("\n");
        int currentCalories = 0;
        for (String s : split) {
            if (!s.isBlank()) {
                currentCalories += Integer.parseInt(s);
            } else {
                if (highestThree.size() <= 2) {
                    highestThree.add(currentCalories);
                } else {
                    highestThree.set(highestThree.size() - 1, Math.max(currentCalories, highestThree.get(highestThree.size() - 1)));
                }
                highestThree = highestThree.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
                System.out.println(highestThree);
                currentCalories = 0;
            }
        }
        highestThree.set(highestThree.size() - 1, Math.max(currentCalories, highestThree.get(highestThree.size() - 1)));
        return highestThree.stream().mapToInt(Integer::valueOf).sum();
    }
}
