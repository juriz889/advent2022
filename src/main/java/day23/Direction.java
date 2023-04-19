package day23;

public interface Direction {
    boolean canMove(Point point, GameMap gameMap);

    Point getTargetPosition(Point start);
}
