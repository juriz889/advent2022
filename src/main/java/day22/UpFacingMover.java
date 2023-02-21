package day22;

public class UpFacingMover implements FacingMover {
    private final GameMap gameMap;

    public UpFacingMover(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    @Override
    public int getScore() {
        return 3;
    }

    @Override
    public FacingMover rotate(String direction) {
        if (direction.equals("R")) {
            return new RightFacingMover(gameMap);
        }
        return new LeftFacingMover(gameMap);
    }

    @Override
    public Point move(Point start, int by) {
        int y = start.getY();
        int moves = 0;
        while (true) {
            y--;
            moves++;

            if (y < 0 || isBlank(start, y)) {
                int lastY = y;
                y = getHeighestY(start.getX());
                char next = gameMap.chartAt(y, start.getX());
                if (next == '#') {
                    return new Point(start.getX(), lastY + 1);
                }
            } else {
                char next = gameMap.chartAt(y, start.getX());
                if (next == '#') {
                    return new Point(start.getX(), y + 1);
                }
                if (moves >= by) {
                    return new Point(start.getX(), y);
                }
            }
        }
    }

    private boolean isBlank(Point start, int y) {
        return gameMap.chartAt(y, start.getX()) == ' ' || gameMap.chartAt(y, start.getX()) == Character.MIN_VALUE;
    }

    private int getHeighestY(int row) {
        int maxY = gameMap.getHeight();
        for (int i = maxY - 1; i >= 0; i--) {
            if (gameMap.chartAt(i, row) == '.' || gameMap.chartAt(i, row) == '#') {
                return i;
            }
        }
        throw new IllegalStateException("Could not find lowest point");
    }
}
