package day23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private final GameMap gameMap;

    public Game(String input) {
        var parser = new GameMapParser();
        gameMap = parser.parse(input);
    }

    public GameMap playRound(int roundsToPlay) {
        for (int rounds = 0; rounds < roundsToPlay; rounds++) {
            Map<Point, List<GameCharacterPosition>> targetPointVsCharacter = new HashMap<>();
            Rectangle filledDimensions = gameMap.getFilledDimensions();
            int smallestX = filledDimensions.getTopLeft().getX();
            int smallestY = filledDimensions.getTopLeft().getY();
            int greatestX = filledDimensions.getBottomRight().getX();
            int greatestY = filledDimensions.getBottomRight().getY();
            playRound(targetPointVsCharacter, smallestX, smallestY, greatestX, greatestY);
        }
        return gameMap;
    }

    private void playRound(Map<Point, List<GameCharacterPosition>> targetPointVsCharacter, int smallestX, int smallestY, int greatestX, int greatestY) {
        for (int x = smallestX; x <= greatestX; x++) {
            for (int y = smallestY; y <= greatestY; y++) {
                Point currentPosition = new Point(x, y);
                GameCharacter gameCharacter = gameMap.getPosition(currentPosition);
                if (gameCharacter.isFilled()) {
                    Point newPoint = gameCharacter.findNextPosition(currentPosition, gameMap);
                    targetPointVsCharacter.computeIfAbsent(newPoint, e -> new ArrayList<>()).add(new GameCharacterPosition(gameCharacter, currentPosition));
                }
            }
        }
        for (Map.Entry<Point, List<GameCharacterPosition>> pointListEntry : targetPointVsCharacter.entrySet()) {
            if (pointListEntry.getValue().size() > 1) {
                System.out.println("Ignoring movement to point " + pointListEntry.getKey() + " as multiple characters tried to move");
                continue;
            }
            gameMap.swap(pointListEntry.getKey(), pointListEntry.getValue().get(0).getPoint());
        }
    }
}
