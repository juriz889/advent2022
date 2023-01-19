package day19;

import java.util.Map;
import java.util.Objects;

public final class RobotCosts {
    private final Map<Unit, Integer> unitCosts;

    public RobotCosts(Map<Unit, Integer> unitCosts) {
        this.unitCosts = unitCosts;
    }

    public int getCostByUnit(Unit unit) {
        return unitCosts.get(unit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
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
                '}';
    }
}
