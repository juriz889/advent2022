package day8;

import java.util.Objects;

public class NumberCoordinates {
    private final int x;
    private final int y;

    public NumberCoordinates(int y, int x) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberCoordinates that = (NumberCoordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
