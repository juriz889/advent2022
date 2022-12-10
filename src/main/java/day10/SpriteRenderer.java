package day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpriteRenderer {
    private static final Pattern ADD_X = Pattern.compile("^addx (-?\\d+)");
    private final Map<Integer, Integer> checkPointVsX = new HashMap<>();
    private List<String> allRenderedRows = new ArrayList<>();

    public String getRenderedSprite(String input) {
        int x = 1;
        int i = 0;
        StringBuilder currentRow = new StringBuilder();
        for (String s : input.split("\n")) {
            if ("noop".equals(s)) {
                i++;
                checkIfCheckpointIsReached(i, x, currentRow);
            } else {
                Matcher matcher = ADD_X.matcher(s);
                matcher.find();
                int add = Integer.parseInt(matcher.group(1));
                i++;
                checkIfCheckpointIsReached(i, x, currentRow);
                i++;
                checkIfCheckpointIsReached(i, x, currentRow);
                x += add;
            }
        }
        allRenderedRows.add(currentRow.toString());
        return String.join("\n", allRenderedRows);
    }

    private void checkIfCheckpointIsReached(int i, int x, StringBuilder currentRow) {
        if (currentRow.length() == 40) {
            allRenderedRows.add(currentRow.toString());
            currentRow.delete(0, 40);
        }
        if (currentRow.length() + 1 >= x && currentRow.length() + 1 - x <= 2) {
            currentRow.append("#");
        } else {
            currentRow.append(".");
        }
    }
}
