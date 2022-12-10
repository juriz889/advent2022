package day5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Stacks {
    private static final String REGEX_NUMBER_LINE = "^\\s*\\d";
    private static final Pattern DOES_LINE_START_WITH_NUMBER = Pattern.compile(REGEX_NUMBER_LINE);
    private static final Pattern ONLY_NUMBERS = Pattern.compile("\\d+");
    private static final Pattern MOVE_COMMAND = Pattern.compile("^move (\\d{1,2}) from (\\d) to (\\d)");

    public String getHighestStack(String input) {
        Map<Integer, LinkedList<String>> allStacks = new HashMap<>();
        String[] split = input.split("\n");
        setupInitialInstruction(allStacks, split);
        executeMovements(allStacks, split);
        System.out.println(allStacks);
        return allStacks.values().stream().map(LinkedList::pop).collect(Collectors.joining());
    }

    public String getHighestCreateMover9001Stack(String input) {
        Map<Integer, LinkedList<String>> allStacks = new HashMap<>();
        String[] split = input.split("\n");
        setupInitialInstruction(allStacks, split);
        executeMovementsWithCreateMover9001(allStacks, split);
        return allStacks.values().stream().map(LinkedList::pop).collect(Collectors.joining());

    }

    private void setupInitialInstruction(Map<Integer, LinkedList<String>> allStacks, String[] split) {
        for (String s : split) {
            Matcher matcher = DOES_LINE_START_WITH_NUMBER.matcher(s);
            if (matcher.find()) {
                System.out.println("Numbers line found " + s);
                Matcher allNumbersMatcher = ONLY_NUMBERS.matcher(s);
                while (allNumbersMatcher.find()) {
                    System.out.println(allNumbersMatcher.start());
                    System.out.println(allNumbersMatcher.end());
                    LinkedList<String> allCharacter = new LinkedList<>();
                    for (String again : split) {
                        if (again.isBlank()) {
                            break;
                        }
                        String substring = again.substring(allNumbersMatcher.start(), allNumbersMatcher.end());
                        if (substring.matches("[A-Z]")) {
                            allCharacter.add(substring);
                            System.out.println(substring);
                        }
                    }
                    allStacks.put(Integer.valueOf(s.substring(allNumbersMatcher.start(), allNumbersMatcher.end()).trim()), allCharacter);
                }
            }
        }
    }

    private void executeMovementsWithCreateMover9001(Map<Integer, LinkedList<String>> allStacks, String[] split) {
        for (String s : split) {
            Matcher matcher = MOVE_COMMAND.matcher(s);
            if (matcher.find()) {
                int howMany = Integer.parseInt(matcher.group(1));
                String fromStack = matcher.group(2);
                String toStack = matcher.group(3);
                LinkedList<String> fromStackList = allStacks.get(Integer.parseInt(fromStack));
                LinkedList<String> receivingList = allStacks.get(Integer.parseInt(toStack));
                LinkedList<String> itemsToMove = new LinkedList<>();
                for (int i = 0; i < howMany; i++) {
                    itemsToMove.addLast(fromStackList.pop());
                }
                int originalSize = itemsToMove.size();
                for (int i = 0; i < originalSize; i++) {
                    receivingList.addFirst(itemsToMove.pollLast());
                }

                System.out.println(allStacks);
            }
        }
    }

    private void executeMovements(Map<Integer, LinkedList<String>> allStacks, String[] split) {
        for (String s : split) {
            Matcher matcher = MOVE_COMMAND.matcher(s);
            if (matcher.find()) {
                int howMany = Integer.parseInt(matcher.group(1));
                String fromStack = matcher.group(2);
                String toStack = matcher.group(3);
                LinkedList<String> fromStackList = allStacks.get(Integer.parseInt(fromStack));
                LinkedList<String> receivingList = allStacks.get(Integer.parseInt(toStack));
                for (int i = 0; i < howMany; i++) {
                    receivingList.addFirst(fromStackList.pop());
                }
                System.out.println(allStacks);
            }
        }
    }
}
