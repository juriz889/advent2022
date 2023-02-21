package day22;

public class RightFacingMover implements FacingMover {
    private final GameMap gameMap;

    public RightFacingMover(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public FacingMover rotate(String direction) {
        if (direction.equals("R")) {
            return new DownFacingMover(gameMap);
        } else if (direction.equals("L")) {
            return new UpFacingMover(gameMap);
        }
        throw new IllegalStateException("Tried to rotate but got " + direction);
    }

    @Override
    public Point move(Point start, int by) {
        int x = start.getX();
        int moves = 0;
        while (true) {
            x++;
            moves++;
            if (x >= gameMap.getWidth() || isBlank(start, x)) {
                int lastX = x;
                x = getLowestX(start.getY());
                char next = gameMap.chartAt(start.getY(), x);
                if (next == '#') {
                    return new Point(lastX - 1, start.getY());
                }
            } else {
                char next = gameMap.chartAt(start.getY(), x);
                if (next == '#') {
                    return new Point(x - 1, start.getY());
                }
                if (moves >= by) {
                    return new Point(x, start.getY());
                }
            }
        }
    }

    private boolean isBlank(Point start, int x) {
        return gameMap.chartAt(start.getY(), x) == ' ' || gameMap.chartAt(start.getY(), x) == Character.MIN_VALUE;
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
