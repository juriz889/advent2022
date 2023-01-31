package day19;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BluePrintSimulatorTest {

    private BluePrintSimulator cut;

    @BeforeEach
    void setUp() {
        BluePrint bluePrint = new BluePrint("1", new RobotCosts(Map.of(Unit.ORE, 4), OreRobot.INSTANCE), new RobotCosts(Map.of(Unit.ORE, 2), ClayRobot.INSTANCE), new RobotCosts(Map.of(Unit.ORE, 3, Unit.CLAY, 14), ObsidianRobot.INSTANCE), new RobotCosts(Map.of(Unit.ORE, 2, Unit.OBSIDIAN, 7), GeodeRoboter.INSTANCE));
        cut = new BluePrintSimulator(bluePrint);
    }

    @Test
    void bluePrint_simulateOneMinute() {
        SimulationState result = cut.simulate(1);
        assertThat(result.getUnit(Unit.ORE)).isEqualTo(1);
    }

    @Test
    void bluePrint_simulateTwoMinutes() {
        SimulationState result = cut.simulate(2);
        assertThat(result.getUnit(Unit.ORE)).isEqualTo(2);
    }

    @Test
    void bluePrint_simulateTwentyFourMinutes() {
        SimulationState result = cut.simulate(24);
        assertThat(result.getUnit(Unit.GEODE)).isEqualTo(9);
    }

    @Test
    void anotherBluePrint_simulateTwentyFourMinutes() {
        BluePrint bluePrint = new BluePrint("2", new RobotCosts(Map.of(Unit.ORE, 2), OreRobot.INSTANCE), new RobotCosts(Map.of(Unit.ORE, 3), ClayRobot.INSTANCE), new RobotCosts(Map.of(Unit.ORE, 3, Unit.CLAY, 8), ObsidianRobot.INSTANCE), new RobotCosts(Map.of(Unit.ORE, 3, Unit.OBSIDIAN, 12), GeodeRoboter.INSTANCE));
        cut = new BluePrintSimulator(bluePrint);
        SimulationState result = cut.simulate(24);
        assertThat(result.getUnit(Unit.GEODE)).isEqualTo(12);
    }
}