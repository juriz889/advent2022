package day9;

import java.util.Objects;

public final class CoordinatesData {
    private final int x;
    private final int y;

    public CoordinatesData(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinatesData that = (CoordinatesData) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "CoordinatesData{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
