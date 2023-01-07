package day15;

import java.util.Objects;

public class Beacon implements Coordinate {
    private final int x;
    private final int y;

    public Beacon(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beacon beacon = (Beacon) o;
        return x == beacon.x && y == beacon.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
