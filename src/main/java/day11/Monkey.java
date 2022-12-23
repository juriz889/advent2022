package day11;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public final class Monkey {
    private long numberOfInspections = 0;
    private final Integer name;
    private final LinkedList<BigInteger> items;
    private final MonkeyOperation monkeyOperation;
    private final Predicate<BigInteger> predicate;
    private ThrowAction trueAction;
    private ThrowAction falseAction;

    public Monkey(Integer name, List<BigInteger> items, MonkeyOperation monkeyOperation, Predicate<BigInteger> predicate) {
        this.name = name;
        this.items = new LinkedList<>(items);
        this.monkeyOperation = monkeyOperation;
        this.predicate = predicate;
    }

    public Integer getName() {
        return name;
    }

    public void setTrueAction(ThrowAction trueAction) {
        this.trueAction = trueAction;
    }

    public void setFalseAction(ThrowAction falseAction) {
        this.falseAction = falseAction;
    }

    @Override
    public String toString() {
        return "Monkey{" +
                "name=" + name +
                ", items=" + items +
                '}';
    }

    public void receiveItem(BigInteger item) {
        items.add(item);
    }

    public long getNumberOfInspections() {
        return numberOfInspections;
    }

    public void processAllItems() {
        while (!items.isEmpty()) {
            numberOfInspections++;
            BigInteger item = items.poll();
            item = monkeyOperation.execute(item).divide(BigInteger.valueOf(3));

            if (predicate.test(item)) {
                trueAction.execute(item);
            } else {
                falseAction.execute(item);
            }
        }
    }

    public DivisiblePredicate getPredicate() {
        return (DivisiblePredicate) predicate;
    }

    public void processAllItemsPart2(long allModulo) {
        while (!items.isEmpty()) {
            numberOfInspections++;
            BigInteger item = items.poll();
            item = monkeyOperation.execute(item);
            item = item.mod(BigInteger.valueOf(allModulo));
            if (predicate.test(item)) {
                trueAction.execute(item);
            } else {
                falseAction.execute(item);
            }
        }
    }
}
