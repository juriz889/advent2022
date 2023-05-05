package day24;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Game {
    private GameMap gameMap;
    private Set<GameProgress> gameProgress;
    private boolean solved = false;
    private int movementsToSolve;
    private final Point goal;

    public Game(GameMap gameMap) {
        this.gameMap = gameMap;
        this.gameProgress = new HashSet<>();
        gameProgress.add(new GameProgress(new Point(0, 1), 0));
        goal = gameMap.goal();
        System.out.println("Goal is " + goal);
    }

    public Set<GameProgress> getGameProgress() {
        return gameProgress;
    }

    public void tick() {
        GameMap newGameMap = gameMap.clone();
        for (int y = 1; y < gameMap.getHeight() - 1; y++) {
            for (int x = 1; x < gameMap.getWidth() - 1; x++) {
                Point point = new Point(y, x);
                for (Character character : gameMap.getMapPoint(point).getCharacters()) {
                    character.move(newGameMap, point);
                }
            }
        }
        gameMap = newGameMap;
        Set<GameProgress> newGameProgress = new HashSet<>();
        for (GameProgress progress : gameProgress) {
            Point currentlyAt = progress.getAt();
            Point bottom = new Point(currentlyAt.y() + 1, currentlyAt.x());
            moveIfPossible(bottom, newGameProgress, progress);
            Point right = new Point(currentlyAt.y(), currentlyAt.x() + 1);
            moveIfPossible(right, newGameProgress, progress);
            Point top = new Point(currentlyAt.y() - 1, currentlyAt.x());
            moveIfPossible(top, newGameProgress, progress);
            Point left = new Point(currentlyAt.y(), currentlyAt.x() - 1);
            moveIfPossible(left, newGameProgress, progress);
            moveIfPossible(currentlyAt, newGameProgress, progress);
        }
        gameProgress = newGameProgress;
    }

    private void moveIfPossible(Point point, Set<GameProgress> newGameProgress, GameProgress progress) {
        Optional<MapPosition> positionOptional = gameMap.getMapPointIfExists(point);
        if (positionOptional.isPresent()) {
            MapPosition position = positionOptional.get();
            if (position.canVisit() && position.getCharacters().isEmpty()) {
                if (point.equals(goal)) {
                    solved = true;
                    movementsToSolve = progress.getMovements() + 1;
                }
                newGameProgress.add(new GameProgress(point, progress.getMovements() + 1));
            }
        }
    }

    public MapPosition getPositionAt(Point point) {
        return this.gameMap.getMapPoint(point);
    }

    public int solve() {
        int ticks = 0;
        while (!solved) {
            System.out.println("ticks " + ticks++);
            this.tick();
        }
        return movementsToSolve;
    }
}
