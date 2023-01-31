package day19;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static day19.Unit.GEODE;

public class BluePrintSimulator {
    private final BluePrint bluePrint;

    public BluePrintSimulator(BluePrint bluePrint) {
        this.bluePrint = bluePrint;
    }

    public SimulationState simulate(int minutes) {
        List<RobotCosts> allRobotCosts = List.of(bluePrint.getOreRobotCost(), bluePrint.getClayRobotCosts(), bluePrint.getObsidianRobotCosts(), bluePrint.getGeodeRobotCosts());
        Stack<SimulationState> statesToTry = new Stack<>();
        SimulationState simulationState = new SimulationState();
        statesToTry.add(
                simulationState);
        SimulationState bestResult = simulationState;
        while (!statesToTry.isEmpty()) {
            SimulationState currentState = statesToTry.pop();
            if (currentState.getMinute() >= minutes) {
                if (currentState.getUnit(GEODE) > bestResult.getUnit(GEODE)) {
                    bestResult = currentState;
                }
            } else {
                if (!canWeBeatTheRecord(minutes, currentState, bestResult)) {
                    continue;
                }
                List<SimulationState> newStates = new ArrayList<>(getRobotsToAdd(currentState, allRobotCosts));
                currentState.tickMinute();
                if (newStates.size() != allRobotCosts.size()) {
                    statesToTry.push(currentState);
                }
                newStates.forEach(statesToTry::push);
            }
        }
        return bestResult;
    }

    private boolean canWeBeatTheRecord(int maxMinutes, SimulationState situation, SimulationState bestSimulation) {
        int remainingMinutes = getRemainingMinutes(maxMinutes, situation);

        int geodesPerMinute = situation.getGeodesPerMinute();

        int numberOfGeodeRobotsWillProduceInRainingTime = geodesPerMinute * remainingMinutes;
        int maxNewGeodeRobotsWillCreate = remainingMinutes * (remainingMinutes - 1) / 2;

        int currentAmountOfGeode = situation.getUnit(GEODE);

        int reachableGeode =
                currentAmountOfGeode
                        + numberOfGeodeRobotsWillProduceInRainingTime
                        + maxNewGeodeRobotsWillCreate;

        return reachableGeode > bestSimulation.getUnit(GEODE);
    }

    private int getRemainingMinutes(int maxMinutes, SimulationState situation) {
        return maxMinutes + 1 - situation.getMinute();
    }

    private List<SimulationState> getRobotsToAdd(SimulationState
                                                         simulationResult, List<RobotCosts> allRobotCosts) {
        List<SimulationState> newStates = new ArrayList<>();
        for (RobotCosts robotCosts : allRobotCosts) {
            boolean capableOfBuying = simulationResult.isCapableOfBuying(robotCosts);
            boolean wasAlreadyCapableOfBuying = simulationResult.couldHaveBoughtInLastMinutes(robotCosts);
            if (capableOfBuying && !wasAlreadyCapableOfBuying) {
                SimulationState newSimulation = SimulationState.clone(simulationResult);
                newSimulation.tickMinute();
                newSimulation.buy(robotCosts);
                newSimulation.addRobots(robotCosts.getRobotFactory());
                newStates.add(newSimulation);
            }
        }
        return newStates;
    }


}

