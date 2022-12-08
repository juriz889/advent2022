package day8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class VisibleTrees {


    public int findVisibleTrees(String input) {
        int[][] numbers = convertInputToArray(input);
        Set<NumberCoordinates> foundNumbers = new HashSet<>();
        for (int y = 0; y < numbers.length; y++) {
            int[] numbersInRow = numbers[y];
            for (int x = 0; x < numbersInRow.length ; x++) {
                int startingNumber = numbersInRow[x];
                boolean hasHigherRightToIt = hasHigherNumberToTheRight(numbersInRow, x, startingNumber);
                if (!hasHigherRightToIt) {
                    System.out.println("Found number on position y: " + y + " x " + x + " with number " + startingNumber);
                    foundNumbers.add(new NumberCoordinates(y, x));
                    continue;
                }
                boolean hasHigherLeftToIt = hasHigherNumberToTheLeft(numbersInRow, x, startingNumber);
                if (!hasHigherLeftToIt) {
                    System.out.println("Found number on position y: " + y + " x " + x + " with number " + startingNumber);
                    foundNumbers.add(new NumberCoordinates(y, x));
                    continue;
                }
                boolean hasHigherToTop = hasHigherNumberToTheTop(numbers, x, y, startingNumber);
                if (!hasHigherToTop) {
                    System.out.println("Found number on position y: " + y + " x " + x + " with number " + startingNumber);
                    foundNumbers.add(new NumberCoordinates(y, x));
                    continue;
                }
                boolean hasHigherToBottom = hasHigherNumberToTheBottom(numbers, x, y, startingNumber);
                if (!hasHigherToBottom) {
                    System.out.println("Found number on position y: " + y + " x " + x + " with number " + startingNumber);
                    foundNumbers.add(new NumberCoordinates(y, x));
                }
            }
        }
        return foundNumbers.size();
    }

    private boolean hasHigherNumberToTheBottom(int[][] allNumbers, int fixedX, int startingY, int startingNumber) {
        boolean hasHigherRightToBottom = false;
        for (int y = startingY + 1; y < allNumbers.length; y++) {
            if (allNumbers[y][fixedX] >= startingNumber) {
                hasHigherRightToBottom = true;
                break;
            }
        }
        return hasHigherRightToBottom;
    }

    private boolean hasHigherNumberToTheTop(int[][] allNumbers, int fixedX, int startingY, int startingNumber) {
        boolean hasHigherToTop = false;
        for (int y = startingY - 1; y >= 0; y--) {
            if (allNumbers[y][fixedX] >= startingNumber) {
                hasHigherToTop = true;
                break;
            }
        }
        return hasHigherToTop;
    }

    private boolean hasHigherNumberToTheRight(int[] numbersInRow, int startingX, int startingNumber) {
        boolean hasHigherRightToIt = false;
        for (int i2 = startingX + 1; i2 < numbersInRow.length; i2++) {
            if (numbersInRow[i2] >= startingNumber) {
                hasHigherRightToIt = true;
                break;
            }
        }
        return hasHigherRightToIt;
    }

    private boolean hasHigherNumberToTheLeft(int[] numbersInRow, int startingX, int startingNumber) {
        boolean hasHigherLeftToIt = false;
        for (int i2 = startingX - 1; i2 >= 0; i2--) {
            if (numbersInRow[i2] >= startingNumber) {
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
