package day21;

import java.util.Map;

public class MonkeyRiddle {
    private final Map<String, String> monkeyVSCommand;

    public MonkeyRiddle(Map<String, String> monkeyVSCommand) {
        this.monkeyVSCommand = monkeyVSCommand;
    }

    public String getInstructionFor(String input) {
        return monkeyVSCommand.get(input);
    }
}
