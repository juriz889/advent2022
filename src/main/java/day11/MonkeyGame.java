package day11;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MonkeyGame {
    private final static Pattern MONKEY = Pattern.compile("Monkey (\\d+):");

    public long simulate20Rounds(String input) {
        Map<Integer, Monkey> monkeys = createMonkey(input);
        System.out.println(monkeys);
        for (int i = 0; i < 20; i++) {
            for (Monkey monkey : monkeys.values()) {
                monkey.processAllItems();
            }
            System.out.println(monkeys);
        }
        return monkeys.values().stream().map(Monkey::getNumberOfInspections).sorted(Comparator.reverseOrder()).limit(2).reduce(1L, (a, b) -> a * b);

    }

    private Map<Integer, Monkey> createMonkey(String input) {
        Map<Integer, Monkey> monkeys = new HashMap<>();
        String[] split = input.split("\n");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            Matcher matcher = MONKEY.matcher(s);
            if (matcher.find()) {
                List<BigInteger> initialItems = getStartingItems(split, i);
                String operation = split[i + 2].split(" Operation: new =")[1];
                MonkeyOperation monkeyOperation = getMonkeyOperation(operation);
                Predicate<BigInteger> divisiblePredicate = getPredicate(split, i);
                monkeys.put(Integer.valueOf(matcher.group(1)), new Monkey(Integer.valueOf(matcher.group(1)), initialItems, monkeyOperation, divisiblePredicate));
            }
        }
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            Matcher matcher = MONKEY.matcher(s);
            if (matcher.find()) {
                Monkey monkey = monkeys.get(Integer.valueOf(matcher.group(1)));
                Integer ifTrueReceiver = Integer.valueOf(split[i + 4].split("If true: throw to monkey")[1].trim());
                Integer ifFalseReceiver = Integer.valueOf(split[i + 5].split("If false: throw to monkey")[1].trim());
                ThrowAction trueAction = new ThrowAction(monkeys.get(ifTrueReceiver));
                ThrowAction falseAction = new ThrowAction(monkeys.get(ifFalseReceiver));
                monkey.setTrueAction(trueAction);
                monkey.setFalseAction(falseAction);
            }
        }
        return monkeys;
    }

    private MonkeyOperation getMonkeyOperation(String operation) {
        MonkeyOperation monkeyOperation;
        if (operation.contains("+")) {
            monkeyOperation = new AddOperation(Integer.parseInt(operation.split("\\+")[1].trim()));
        } else {
            String trim = operation.split("\\*")[1].trim();
            if (trim.equals("old")) {
                monkeyOperation = new MultiplyItselfOperation();
            } else {
                monkeyOperation = new MultiplyOperation(Integer.parseInt(trim));
            }
            // System.out.println(operation);
        }
        return monkeyOperation;
    }

    private Predicate<BigInteger> getPredicate(String[] split, int i) {
        String disibleByValue = split[i + 3].split("Test: divisible by")[1];
        Predicate<BigInteger> divisiblePredicate = new DivisiblePredicate(Long.parseLong(disibleByValue.trim()));
        return divisiblePredicate;
    }

    private List<BigInteger> getStartingItems(String[] split, int i) {
        String startingItemsCommaSeparated = split[i + 1].split("Starting items:")[1];
        String[] split1 = startingItemsCommaSeparated.split(",");
        List<BigInteger> initialItems = Arrays.stream(split1).map(String::trim).map(Long::valueOf).map(BigInteger::valueOf).toList();
        return initialItems;
    }

    public long simulate10000Rounds(String input) {
        Map<Integer, Monkey> monkeys = createMonkey(input);
        Optional<Long> reduce = monkeys.values().stream().map(m -> m.getPredicate().getDivisor()).reduce((a, b) -> a * b);
        System.out.println(monkeys);
        for (int i = 0; i < 10000; i++) {
            for (Monkey monkey : monkeys.values()) {
                monkey.processAllItemsPart2(reduce.get());
            }
            System.out.println(i);
        }
        return monkeys.values().stream().map(Monkey::getNumberOfInspections).sorted(Comparator.reverseOrder()).limit(2).reduce(1L, (a, b) -> a * b);
    }
}
