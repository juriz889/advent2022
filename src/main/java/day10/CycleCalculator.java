package day10;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CycleCalculator {
    private static final Pattern ADD_X = Pattern.compile("^addx (-?\\d+)");
    private final Map<Integer, Integer> checkPointVsX = new HashMap<>();

    public int getCycleCounter(String input) {

        int x = 1;
        int i = 0;
        int nextCheckpoint = 20;
        for (String s : input.split("\n")) {
            if ("noop".equals(s)) {
                i++;
                nextCheckpoint = checkIfCheckpointIsReached(i, x, nextCheckpoint);
            } else {
                Matcher matcher = ADD_X.matcher(s);
                matcher.find();
                int add = Integer.parseInt(matcher.group(1));
                i++;
                nextCheckpoint = checkIfCheckpointIsReached(i, x, nextCheckpoint);
                i++;
                nextCheckpoint = checkIfCheckpointIsReached(i, x, nextCheckpoint);
                x += add;
            }
        }
        return checkPointVsX.values().stream().mapToInt(Integer::intValue).sum();
    }

    private int checkIfCheckpointIsReached(int i, int x, int nextCheckpoint) {
        if (i - nextCheckpoint == 0) {
            checkPointVsX.put(i, i * x);
            return nextCheckpoint + 40;
        }
        return nextCheckpoint;
    }
}
