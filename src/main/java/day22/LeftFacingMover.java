package day22;

public class LeftFacingMover implements FacingMover {
    private final GameMap gameMap;

    public LeftFacingMover(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    @Override
    public int getScore() {
        return 2;
    }

    @Override
    public FacingMover rotate(String direction) {
        if (direction.equals("R")) {
            return new UpFacingMover(gameMap);
        }
        return new DownFacingMover(gameMap);
    }

    @Override
    public Point move(Point start, int by) {
        int x = start.getX();
        while (true) {
            x--;
            by--;
            if (x < 0 || gameMap.chartAt(start.getY(), x) == ' ') {
                int lastX = x;
                x = getHighestX(start.getY());
                char next = gameMap.chartAt(start.getY(), x);
                if (next == '#') {
                    return new Point(lastX + 1, start.getY());
                }
            } else {
                char next = gameMap.chartAt(start.getY(), x);
                if (next == '#') {
                    return new Point(x + 1, start.getY());
                }
                if (by == 0) {
                    return new Point(x, start.getY());
                }
            }
        }
    }

    private int getHighestX(int row) {
        int maxX = gameMap.getWidth();
        for (int i = maxX - 1; i >= 0; i--) {
            if (gameMap.chartAt(row, i) == '.' || gameMap.chartAt(row, i) == '#') {
                return i;
            }
        }
        throw new IllegalStateException("Could not find lowest point");
    }
}
