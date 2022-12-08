package day8;

import java.util.Arrays;

public final class ScenicScoreOfTrees {

    public int findBestScenicScore(String input) {
        int[][] numbers = convertInputToArray(input);
        int bestScore = 0;
        for (int y = 0; y < numbers.length; y++) {
            int[] numbersInRow = numbers[y];
            for (int x = 0; x < numbersInRow.length; x++) {
                int startingNumber = numbersInRow[x];
                int right = getVisibleTreesToTheRight(numbersInRow, x, startingNumber);

                int left = getVisibleTreesToTheToTheLeft(numbersInRow, x, startingNumber);

                int top = getVisibleTreesToTheTop(numbers, x, y, startingNumber);

                int bottom = getVisibleTreesToTheBottom(numbers, x, y, startingNumber);
                int score = right * left * top * bottom;
                if (score > bestScore) {
                    bestScore = score;
                }

            }
        }
        return bestScore;
    }

    private int getVisibleTreesToTheBottom(int[][] allNumbers, int fixedX, int startingY, int startingNumber) {
        int visible = 0;
        for (int y = startingY + 1; y < allNumbers.length; y++) {
            visible++;
            if (allNumbers[y][fixedX] >= startingNumber) {
                break;
            }
        }
        return visible;
    }

    private int getVisibleTreesToTheTop(int[][] allNumbers, int fixedX, int startingY, int startingNumber) {
        int visible = 0;
        for (int y = startingY - 1; y >= 0; y--) {
            visible++;
            if (allNumbers[y][fixedX] >= startingNumber) {
                break;
            }
        }
        return visible;
    }

    private int getVisibleTreesToTheRight(int[] numbersInRow, int startingX, int startingNumber) {
        int visible = 0;
        for (int i2 = startingX + 1; i2 < numbersInRow.length; i2++) {
            visible++;
            if (numbersInRow[i2] >= startingNumber) {
                break;
            }
        }
        return visible;
    }

    private int getVisibleTreesToTheToTheLeft(int[] numbersInRow, int startingX, int startingNumber) {
        int visible = 0;
        for (int i2 = startingX - 1; i2 >= 0; i2--) {
            visible++;
            if (numbersInRow[i2] >= startingNumber) {
                break;
            }
        }
        return visible;
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
