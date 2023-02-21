package day22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathParser {

    public PathGame parsePath(String gameAndInstrcutions) {
        String[] split = gameAndInstrcutions.split("\n");
        List<String> gameLines = new ArrayList<>(Arrays.asList(split).subList(0, split.length - 2));
        return new PathGame(String.join("\n", gameLines), split[split.length - 1]);
    }
}
