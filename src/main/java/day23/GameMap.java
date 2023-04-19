package day23;

import java.util.Optional;

public class GameMap {
    private final GameCharacter[][] gameMapCharacters;

    public GameMap(GameCharacter[][] gameMapCharacters) {
        this.gameMapCharacters = gameMapCharacters;
    }

    public GameCharacter getPosition(Point point) {
        return gameMapCharacters[point.getY()][point.getX()];
    }

    public Optional<GameCharacter> getCharacter(Point point) {
        if (gameMapCharacters.length > point.getY() && point.getY() >= 0) {
            GameCharacter[] gameMapCharacter = gameMapCharacters[point.getY()];
            if (gameMapCharacter.length > point.getX() && point.getX() >= 0) {
                return Optional.of(gameMapCharacter[point.getX()]);
            }
        }
        return Optional.empty();
    }

    public boolean canMoveTo(Point point) {
        if (gameMapCharacters.length > point.getY() && point.getY() >= 0) {
            GameCharacter[] gameMapCharacter = gameMapCharacters[point.getY()];
            if (gameMapCharacter.length > point.getX() && point.getX() >= 0) {
                return !gameMapCharacter[point.getX()].isFilled();
            }
        }
        return false;
    }

    public Rectangle getFilledDimensions() {
        int smallestX = Integer.MAX_VALUE;
        int smallestY = Integer.MAX_VALUE;
        int greatestX = 0;
        int greatestY = 0;
        for (int i = 0; i < gameMapCharacters.length; i++) {
            GameCharacter[] gameMapCharacter = gameMapCharacters[i];
            for (int i1 = 0; i1 < gameMapCharacter.length; i1++) {
                if (gameMapCharacter[i1].isFilled()) {
                    smallestX = Math.min(smallestX, i1);
                    smallestY = Math.min(smallestY, i);
                    greatestY = Math.max(greatestY, i);
                    greatestX = Math.max(greatestX, i1);
                }
            }
        }
        return new Rectangle(new Point(smallestX, smallestY), new Point(greatestX, greatestY));
    }

    public String draw() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < gameMapCharacters.length; i++) {
            GameCharacter[] gameMapCharacter = gameMapCharacters[i];
            for (int i1 = 0; i1 < gameMapCharacter.length; i1++) {
                stringBuilder.append(gameMapCharacter[i1].draw());
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String drawFilled() {
        Rectangle filledDimensions = this.getFilledDimensions();
        int smallestX = filledDimensions.getTopLeft().getX();
        int smallestY = filledDimensions.getTopLeft().getY();
        int greatestX = filledDimensions.getBottomRight().getX();
        int greatestY = filledDimensions.getBottomRight().getY();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = smallestY; i <= greatestY; i++) {
            GameCharacter[] gameMapCharacter = gameMapCharacters[i];
            for (int i1 = smallestX; i1 <= greatestX; i1++) {
                stringBuilder.append(gameMapCharacter[i1].draw());
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public int calcEmptyInRectangle() {
        Rectangle filledDimensions = this.getFilledDimensions();
        int smallestX = filledDimensions.getTopLeft().getX();
        int smallestY = filledDimensions.getTopLeft().getY();
        int greatestX = filledDimensions.getBottomRight().getX();
        int greatestY = filledDimensions.getBottomRight().getY();
        int result = 0;
        for (int i = smallestY; i <= greatestY; i++) {
            GameCharacter[] gameMapCharacter = gameMapCharacters[i];
            for (int i1 = smallestX; i1 <= greatestX; i1++) {
                if (!gameMapCharacter[i1].isFilled()) {
                    result++;
                }
            }
        }
        return result;
    }

    public void swap(Point targetPoint, Point startPoint) {
        if (targetPoint.equals(startPoint)) {
            return;
        }
        GameCharacter characterOnTarget = getPosition(targetPoint);
        if (characterOnTarget.isFilled()) {
            throw new IllegalStateException("Character on target fills position which is not allowed");
        }
        GameCharacter characterOnStart = getPosition(startPoint);
        setCharacter(targetPoint, characterOnStart);
        setCharacter(startPoint, characterOnTarget);
    }

    private void setCharacter(Point point, GameCharacter character) {
        gameMapCharacters[point.getY()][point.getX()] = character;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return this.draw().equals(((GameMap) o).draw());
    }

    @Override
    public int hashCode() {
        return this.draw().hashCode();
    }

    @Override
    public String toString() {
        return "GameMap{" +
                "gameMapCharacters=" + this.draw() +
                '}';
    }
}
