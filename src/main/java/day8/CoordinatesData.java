package day8;

public final class CoordinatesData {
    private final int[][] numbers;
    private final int x;
    private final int y;
    private final int currentNumber;

    public CoordinatesData(int[][] numbers, int x, int y, int currentNumber) {
        this.numbers = numbers;
        this.x = x;
        this.y = y;
        this.currentNumber = currentNumber;
    }

    public int[][] getNumbers() {
        return numbers;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }
}
