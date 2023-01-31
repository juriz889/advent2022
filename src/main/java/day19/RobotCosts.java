package day19;

import java.util.Map;
import java.util.Objects;

public final class RobotCosts {
    private final Map<Unit, Integer> unitCosts;
    private final Robot robot;

    public RobotCosts(Map<Unit, Integer> unitCosts, Robot robot) {
        this.unitCosts = unitCosts;
        this.robot = robot;
    }

    public Robot getRobotFactory() {
        return robot;
    }

    public Map<Unit, Integer> getCosts() {
        return unitCosts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RobotCosts that = (RobotCosts) o;
        return unitCosts.equals(that.unitCosts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitCosts);
    }

    @Override
    public String toString() {
        return "RobotCosts{" +
                "unitCosts=" + unitCosts +
                ", robotFactory=" + robot +
                '}';
    }
}
