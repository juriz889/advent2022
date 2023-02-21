package day22;

import java.util.List;

public class Game {
    private final Instructor instructor;
    private final GameMap gameMap;
    private FacingMover facingMover;

    public Game(Instructor instructor, GameMap gameMap) {
        this.instructor = instructor;
        this.gameMap = gameMap;
        facingMover = new RightFacingMover(gameMap);
    }


    public int run() {
        Point point = new Point(getLowestX(0), 0);
        List<String> instructions = instructor.getInstructions();
        for (String instruction : instructions) {
            if (instruction.matches("\\d+")) {
                int val = Integer.parseInt(instruction);
                point = facingMover.move(point, val);
                if (gameMap.chartAt(point.getY(), point.getX()) != '.') {
                    throw new IllegalStateException("Stepped on wrong field");
                }
            } else {
                facingMover = facingMover.rotate(instruction.trim());
            }
        }
        return 1000 * (point.getY() + 1) + 4 * (point.getX() + 1) + facingMover.getScore();
    }

    private int getLowestX(int row) {
        int maxX = gameMap.getWidth();
        for (int i = 0; i < maxX; i++) {
            if (gameMap.chartAt(row, i) == '.' || gameMap.chartAt(row, i) == '#') {
                return i;
            }
        }
        throw new IllegalStateException("Could not find lowest point");
    }
}
