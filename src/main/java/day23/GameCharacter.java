package day23;

public interface GameCharacter {
    boolean isFilled();

    Point findNextPosition(Point currentPosition, GameMap gameMap);

    char draw();
}
