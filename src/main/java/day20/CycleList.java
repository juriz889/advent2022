package day20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CycleList {
    private final CircularList<Integer> currentNumbers;
    private final int size;

    public CycleList(String input) {
        String[] split = input.split("\n");
        List<Integer> initialNumbers = new LinkedList<>(Arrays.stream(split).map(String::trim).map(Integer::valueOf).toList());
        currentNumbers = new CircularList<>();
        initialNumbers.forEach(currentNumbers::addValue);
        size = initialNumbers.size();

    }

    public List<Integer> move() {
        List<CircularList.Node<Integer>> nodesInStartOrder = new ArrayList<>(currentNumbers.getAllNodesIterator());
        for (CircularList.Node<Integer> integerNode : nodesInStartOrder) {
            Integer initialNumber = integerNode.getValue();
            System.out.println("Current number is " + initialNumber);
            int toMove = initialNumber;
            int howManyToMoveNumber = toMove % (nodesInStartOrder.size() - 1);
            if (howManyToMoveNumber == 0) {
                continue;
            }
            System.out.println("Will move by " + howManyToMoveNumber);
            currentNumbers.moveNode(integerNode, howManyToMoveNumber);
        }
        return currentNumbers.toList();
    }

    public int getNumberAtAfterZero(int after) {
        int toMove = (after) % size;
        System.out.println("To move is " + toMove + " added with zero  " + (toMove));
        CircularList.Node<Integer> result = currentNumbers.findByValue(0);
        for (long i = 0; i < toMove; i++) {
            result = result.getNext();
        }
        return result.getValue();
    }
}
