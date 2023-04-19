package day23;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Elf implements GameCharacter {
    private final LinkedList<Direction> directions = new LinkedList<>();

    public Elf() {
        directions.add(new NorthDirection());
        directions.add(new SouthDirection());
        directions.add(new WestDirection());
        directions.add(new EastDirection());
    }

    @Override
    public boolean isFilled() {
        return true;
    }

    @Override
    public Point findNextPosition(Point currentPosition, GameMap gameMap) {
        Point result = currentPosition;
        boolean hasElfAsNeighbor = false;
        for (Point neighBor : calcNeighborPoints(currentPosition)) {
            Optional<GameCharacter> character = gameMap.getCharacter(neighBor);
            if (character.isPresent()) {
                hasElfAsNeighbor = character.get().isFilled();
            }
            if (hasElfAsNeighbor) {
                break;
            }
        }
        if (!hasElfAsNeighbor) {
            directions.add(directions.poll());
            return currentPosition;
        }
        for (Direction direction : directions) {
            System.out.println("Checking direction " + direction);
            if (direction.canMove(currentPosition, gameMap)) {
                result = direction.getTargetPosition(currentPosition);
                break;
            }
        }
        directions.add(directions.poll());
        return result;
    }

    private List<Point> calcNeighborPoints(Point point) {
        int currentY = point.getY();
        int currentX = point.getX();
        return List.of(new Point(currentX + 1, currentY),
                new Point(currentX - 1, currentY),
                new Point(currentX, currentY + 1),
                new Point(currentX, currentY - 1),
                new Point(currentX + 1, currentY + 1),
                new Point(currentX - 1, currentY - 1),
                new Point(currentX + 1, currentY - 1),
                new Point(currentX - 1, currentY + 1));
    }

    @Override
    public char draw() {
        return '#';
    }


}
