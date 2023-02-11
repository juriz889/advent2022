package day21;

import java.util.HashMap;
import java.util.Map;

public class MonkeyRiddleParser {
    public MonkeyRiddle parse(String input) {
        String[] split = input.split("\n");
        Map<String, String> monkeyVSCommand = new HashMap<>();
        for (String s : split) {
            String[] splitByCollon = s.split(":");
            monkeyVSCommand.put(splitByCollon[0], splitByCollon[1].trim());
        }
        return new MonkeyRiddle(monkeyVSCommand);
    }
}
