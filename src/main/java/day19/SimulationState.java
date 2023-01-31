package day19;

import java.util.*;

public class SimulationState {
    private final Map<Unit, Integer> units = new HashMap<>();
    private Map<Unit, Integer> resourceLastMinutes = units;
    private final List<Robot> robotList = new ArrayList<>();
    private final Map<String, Integer> robotVsCount = new HashMap<>();
    private final Map<String, Integer> robotFirstProducesVsMinutes;
    private int minute;

    public SimulationState() {
        this.minute = 0;
        robotList.add(OreRobot.INSTANCE);
        robotVsCount.put(OreRobot.INSTANCE.getName(), 1);
        robotFirstProducesVsMinutes = new HashMap<>();
    }

    private SimulationState(Map<Unit, Integer> units, List<Robot> robots, Map<String, Integer> robotFirstProducesVsMinutes, int minute) {
        this.minute = minute;
        this.units.putAll(units);
        this.robotList.addAll(robots);
        this.robotFirstProducesVsMinutes = robotFirstProducesVsMinutes;
        this.resourceLastMinutes = units;
        countRobot(robots);
    }

    public int getMinute() {
        return minute;
    }


    public void addRobots(Robot robotsToAdd) {
        robotList.add(robotsToAdd);
        robotFirstProducesVsMinutes.putIfAbsent(robotsToAdd.getName(), minute);
        countRobot(List.of(robotsToAdd));
    }

    private void countRobot(Collection<Robot> robotsToAdd) {
        for (Robot robot : robotsToAdd) {
            robotVsCount.put(robot.getName(), robotVsCount.getOrDefault(robot.getName(), 0) + 1);
        }
    }

    public void tickMinute() {
        minute++;
        resourceLastMinutes = new HashMap<>(units);
        List<UnitAmount> collect = robotList.stream().map(Robot::collect).toList();
        for (UnitAmount unitAmount : collect) {
            this.add(unitAmount);
        }
    }

    public Integer getUnit(Unit unit) {
        return units.getOrDefault(unit, 0);
    }

    public void add(UnitAmount unitAmount) {
        units.put(unitAmount.getUnit(), unitAmount.getAmount() + units.getOrDefault(unitAmount.getUnit(), 0));
    }

    public int getGeodesPerMinute() {
        return robotVsCount.getOrDefault(GeodeRoboter.INSTANCE.getName(), 0);
    }

    public static SimulationState clone(SimulationState other) {
        return new SimulationState(other.units, other.robotList, other.robotFirstProducesVsMinutes, other.minute);
    }

    private void remove(UnitAmount unitAmount) {
        int value = units.get(unitAmount.getUnit()) - unitAmount.getAmount();
        if (value < 0) {
            throw new IllegalStateException("Cannot have negative amount");
        }
        units.put(unitAmount.getUnit(), value);
        resourceLastMinutes.put(unitAmount.getUnit(), resourceLastMinutes.get(unitAmount.getUnit()) - unitAmount.getAmount());
    }

    private Map<Unit, Integer> getLastMinuteUnits() {
        return resourceLastMinutes;
    }

    public boolean isCapableOfBuying(RobotCosts robotCosts) {
        return isCapableOfBuying(units, robotCosts);
    }

    public boolean couldHaveBoughtInLastMinutes(RobotCosts robotCosts) {
        return isCapableOfBuying(getLastMinuteUnits(), robotCosts);
    }

    private boolean isCapableOfBuying(Map<Unit, Integer> units, RobotCosts allCombination) {
        boolean capableOfBuying = true;
        for (Map.Entry<Unit, Integer> unitIntegerEntry : allCombination.getCosts().entrySet()) {
            Integer unit = units.getOrDefault(unitIntegerEntry.getKey(), 0);
            if (unit < unitIntegerEntry.getValue()) {
                capableOfBuying = false;
                break;
            }
        }
        return capableOfBuying;
    }

    @Override
    public String toString() {
        return "SimulationState{" +
                "units=" + units +
                ", robotList=" + robotVsCount +
                '}';
    }

    void buy(RobotCosts allCombination) {
        for (Map.Entry<Unit, Integer> unitIntegerEntry : allCombination.getCosts().entrySet()) {
            remove(new UnitAmount(unitIntegerEntry.getKey(), unitIntegerEntry.getValue()));
        }
    }

}
