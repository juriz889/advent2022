package day19;

public class RobotCost {
    private final Unit unit;
    private final int cost;

    public RobotCost(Unit unit, int cost) {
        this.unit = unit;
        this.cost = cost;
    }

    public Unit getUnit() {
        return unit;
    }

    public int getCost() {
        return cost;
    }
}
