package day24;

import java.util.Objects;

public class GameProgress {
    private final Point at;
    private final int movements;

    public GameProgress(Point at, int movements) {
        this.at = at;
        this.movements = movements;
    }

    public Point getAt() {
        return at;
    }

    public int getMovements() {
        return movements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameProgress that = (GameProgress) o;
        return movements == that.movements && at.equals(that.at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(at, movements);
    }
}
