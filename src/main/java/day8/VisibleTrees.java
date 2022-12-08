package day8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public final class VisibleTrees {


    public int findVisibleTrees(String input) {
        int[][] numbers = convertInputToArray(input);
        Set<NumberCoordinates> foundNumbers = new HashSet<>();
        List<Function<CoordinatesData, Boolean>> functions = List.of(this::hasHigherNumberToTheBottom, this::hasHigherNumberToTheLeft, this::hasHigherNumberToTheRight, this::hasHigherNumberToTheTop);
        for (int y = 0; y < numbers.length; y++) {
            int[] numbersInRow = numbers[y];
            for (int x = 0; x < numbersInRow.length; x++) {
                int startingNumber = numbersInRow[x];
                CoordinatesData coordinatesData = new CoordinatesData(numbers, x, y, startingNumber);
                for (Function<CoordinatesData, Boolean> function : functions) {
                    Boolean hasHigherToDirection = function.apply(coordinatesData);
                    if (!hasHigherToDirection) {
                        System.out.println("Found number on position y: " + y + " x " + x + " with number " + startingNumber);
                        foundNumbers.add(new NumberCoordinates(y, x));
                        break;
                    }
                }
            }
        }
        return foundNumbers.size();
    }

    private boolean hasHigherNumberToTheBottom(CoordinatesData coordinatesData) {
        boolean hasHigherRightToBottom = false;
        int[][] allNumbers = coordinatesData.getNumbers();
        for (int y = coordinatesData.getY() + 1; y < allNumbers.length; y++) {
            if (allNumbers[y][coordinatesData.getX()] >= coordinatesData.getCurrentNumber()) {
                hasHigherRightToBottom = true;
                break;
            }
        }
        return hasHigherRightToBottom;
    }

    private boolean hasHigherNumberToTheTop(CoordinatesData coordinatesData) {
        boolean hasHigherToTop = false;
        int[][] allNumbers = coordinatesData.getNumbers();
        for (int y = coordinatesData.getY() - 1; y >= 0; y--) {
            if (allNumbers[y][coordinatesData.getX()] >= coordinatesData.getCurrentNumber()) {
                hasHigherToTop = true;
                break;
            }
        }
        return hasHigherToTop;
    }

    private boolean hasHigherNumberToTheRight(CoordinatesData coordinatesData) {
        boolean hasHigherRightToIt = false;
        int[] numbersInRow = coordinatesData.getNumbers()[coordinatesData.getY()];
        for (int i2 = coordinatesData.getX() + 1; i2 < numbersInRow.length; i2++) {
            if (numbersInRow[i2] >= coordinatesData.getCurrentNumber()) {
                hasHigherRightToIt = true;
                break;
            }
        }
        return hasHigherRightToIt;
    }

    private boolean hasHigherNumberToTheLeft(CoordinatesData coordinatesData) {
        boolean hasHigherLeftToIt = false;
        int[] numbersInRow = coordinatesData.getNumbers()[coordinatesData.getY()];
        for (int i2 = coordinatesData.getX() - 1; i2 >= 0; i2--) {
            if (numbersInRow[i2] >= coordinatesData.getCurrentNumber()) {
                hasHigherLeftToIt = true;
                break;
            }
        }
        return hasHigherLeftToIt;
    }

    private int[][] convertInputToArray(String input) {
        String[] split = input.split("\n");
        int[][] numbers = new int[split.length][split[0].length()];
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            char[] chars = s.toCharArray();
            for (int i1 = 0; i1 < chars.length; i1++) {
                numbers[i][i1] = Integer.parseInt(String.valueOf(chars[i1]));
            }
        }
        System.out.println(Arrays.deepToString(numbers));
        return numbers;
    }
}
