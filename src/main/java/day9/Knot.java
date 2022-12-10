package day9;

import java.util.HashSet;
import java.util.Set;

public class Knot {
    private CoordinatesData coordinatesData;
    private final Set<CoordinatesData> visited = new HashSet<>();
    private final String name;

    public Knot(CoordinatesData coordinatesData, String name) {
        this.setCoordinatesData(coordinatesData);
        this.name = name;
    }

    public int getX() {
        return coordinatesData.getX();
    }

    public int getY() {
        return coordinatesData.getY();
    }

    public void moveX(int x, int y) {
        this.setCoordinatesData(new CoordinatesData(this.getX() + x, y));
    }

    public void moveY(int y, int x) {
        this.setCoordinatesData(new CoordinatesData(x, this.getY() + y));
    }

    public int getVisited() {
        return visited.size();
    }

    private void setCoordinatesData(CoordinatesData coordinatesData) {
        visited.add(coordinatesData);
        this.coordinatesData = coordinatesData;
    }

    @Override
    public String toString() {
        return "Knot{" +
                ", name='" + name + '\'' +
                "coordinatesData=" + coordinatesData +
                '}';
    }
}
