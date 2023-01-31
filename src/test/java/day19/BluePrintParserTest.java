package day19;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BluePrintParserTest {
    @Test
    void bluePrintAsString_parse_parsedBlueString() {
        String input = "Blueprint 1: Each ore robot costs 4 ore. Each clay robot costs 2 ore. Each obsidian robot costs 3 ore and 14 clay. Each geode robot costs 2 ore and 7 obsidian.";
        BluePrintParser cut = new BluePrintParser();
        BluePrint bluePrint = cut.parse(input);
        assertThat(bluePrint).isNotNull();
        assertThat(bluePrint.getName()).isEqualTo("1");
        assertThat(bluePrint.getOreRobotCost()).isEqualTo(new RobotCosts(Map.of(Unit.ORE, 4), OreRobot.INSTANCE));
        assertThat(bluePrint.getClayRobotCosts()).isEqualTo(new RobotCosts(Map.of(Unit.ORE, 2), ClayRobot.INSTANCE));
        assertThat(bluePrint.getObsidianRobotCosts()).isEqualTo(new RobotCosts(Map.of(Unit.ORE, 3, Unit.CLAY, 14), ObsidianRobot.INSTANCE));
        assertThat(bluePrint.getGeodeRobotCosts()).isEqualTo(new RobotCosts(Map.of(Unit.ORE, 2, Unit.OBSIDIAN, 7), GeodeRoboter.INSTANCE));
    }

    @Test
    void anotherBluePrintAsString_parse_parsedBlueString() {
        String input = "Blueprint 30: Each ore robot costs 4 ore. Each clay robot costs 4 ore. Each obsidian robot costs 4 ore and 8 clay. Each geode robot costs 4 ore and 14 obsidian.";
        BluePrintParser cut = new BluePrintParser();
        BluePrint bluePrint = cut.parse(input);
        assertThat(bluePrint).isNotNull();
        assertThat(bluePrint.getName()).isEqualTo("30");
        assertThat(bluePrint.getOreRobotCost()).isEqualTo(new RobotCosts(Map.of(Unit.ORE, 4), OreRobot.INSTANCE));
        assertThat(bluePrint.getClayRobotCosts()).isEqualTo(new RobotCosts(Map.of(Unit.ORE, 4), ClayRobot.INSTANCE));
        assertThat(bluePrint.getObsidianRobotCosts()).isEqualTo(new RobotCosts(Map.of(Unit.ORE, 4, Unit.CLAY, 8), ObsidianRobot.INSTANCE));
        assertThat(bluePrint.getGeodeRobotCosts()).isEqualTo(new RobotCosts(Map.of(Unit.ORE, 4, Unit.OBSIDIAN, 14), GeodeRoboter.INSTANCE));
    }

}