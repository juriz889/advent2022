package day15;

public class Sensor implements Coordinate {
    private final int x;
    private final int y;
    private final Beacon beacon;

    public Sensor(int x, int y, Beacon beacon) {
        this.x = x;
        this.y = y;
        this.beacon = beacon;
    }

    public Beacon getBeacon() {
        return beacon;
    }

    public int distanceToBeacon() {
        return Math.abs(this.getX() - this.beacon.getX()) + Math.abs(this.getY() - this.beacon.getY());
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
