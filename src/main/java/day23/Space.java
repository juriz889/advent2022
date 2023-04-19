package day23;

public class Space implements GameCharacter {
    public static final Space INSTANCE = new Space();

    private Space() {
    }

    @Override
    public boolean isFilled() {
        return false;
    }

    @Override
    public Point findNextPosition(Point currentPosition, GameMap gameMap) {
        return currentPosition;
    }

    @Override
    public char draw() {
        return '.';
    }
}
