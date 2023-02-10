package day20;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CycleList {
    private static final int NUMBERS_IN_LIST = 6;
    private final List<Integer> initialNumbers;
    private LinkedList<Integer> currentNumbers;

    public CycleList(String input) {
        String[] split = input.split(",");
        initialNumbers = new LinkedList<>(Arrays.stream(split).map(String::trim).map(Integer::valueOf).toList());
        currentNumbers = new LinkedList<>(initialNumbers);
    }

    public List<Integer> move(String s) {
        String[] split = s.split("\n");
        int currentIndex = -1;
        for (String s1 : split) {
            currentIndex++;
            Integer currentNumber = initialNumbers.get(currentIndex);
            System.out.println("Current number is " + currentNumber);
            int indexToMove = currentNumbers.indexOf(currentNumber);
            int toMove = Integer.parseInt(s1.trim());
            if (toMove == 0) {
                continue;
            }
            int howManyToMoveNumber = toMove % NUMBERS_IN_LIST;
            if (howManyToMoveNumber == 0) {
                continue;
            }
            Integer movingNumber = currentNumbers.remove(indexToMove);
            int targetIndex = indexToMove + howManyToMoveNumber;
            System.out.println("Index to move " + indexToMove + " how many numbers " + howManyToMoveNumber + " target " + targetIndex);
            if (targetIndex == 0) {
                targetIndex = currentNumbers.size();
            } else if (targetIndex < 0) {
                targetIndex = currentNumbers.size() + targetIndex;
            } else if (targetIndex >= currentNumbers.size()) {
                targetIndex = howManyToMoveNumber - (currentNumbers.size() - indexToMove);
            }
            System.out.println("Moving number is " + movingNumber + " target index is " + targetIndex);
            currentNumbers.add(targetIndex, movingNumber);

        }
        return currentNumbers;
    }

    public int getNumberAtAfterZero(int after) {
        int currentIndexOfZero = currentNumbers.indexOf(0);
        int toMove = (after + currentIndexOfZero) % 7;
        System.out.println("To move is " + toMove + " added with zero  " + (toMove + currentIndexOfZero));
        return currentNumbers.get(toMove);
    }
}
