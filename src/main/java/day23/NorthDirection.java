package day23;

public class NorthDirection implements Direction {

    @Override
    public boolean canMove(Point point, GameMap gameMap) {
        return gameMap.canMoveTo(new Point(point.getX(), point.getY() - 1)) && gameMap.canMoveTo(new Point(point.getX() - 1, point.getY() - 1)) && gameMap.canMoveTo(new Point(point.getX() + 1, point.getY() - 1));
    }

    @Override
    public Point getTargetPosition(Point start) {
        return new Point(start.getX(), start.getY() - 1);
    }
}
