package day23;

public final class GameCharacterPosition {
    private final GameCharacter gameCharacter;
    private final Point point;

    public GameCharacterPosition(GameCharacter gameCharacter, Point point) {
        this.gameCharacter = gameCharacter;
        this.point = point;
    }

    public GameCharacter getGameCharacter() {
        return gameCharacter;
    }

    public Point getPoint() {
        return point;
    }
}
