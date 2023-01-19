package day19;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BluePrintParserTest {
    @Test
    void bluePrintAsString_parse_parsedBlueString() {
        String input = """
                Blueprint 1:
                  Each ore robot costs 4 ore.
                  Each clay robot costs 2 ore.
                  Each obsidian robot costs 3 ore and 14 clay.
                  Each geode robot costs 2 ore and 7 obsidian.""";
        BluePrintParser cut = new BluePrintParser();
        BluePrint bluePrint = cut.parse(input);
        assertThat(bluePrint).isNotNull();
        assertThat(bluePrint.getName()).isEqualTo("1");
        assertThat(bluePrint.getOreRobotCost()).isEqualTo(new RobotCosts(Map.of(Unit.ORE, 4)));
        assertThat(bluePrint.getClayRobotCosts()).isEqualTo(new RobotCosts(Map.of(Unit.ORE, 2)));
        assertThat(bluePrint.getObsidianRobotCosts()).isEqualTo(new RobotCosts(Map.of(Unit.ORE, 3, Unit.CLAY, 14)));
        assertThat(bluePrint.getGeodeRobotCosts()).isEqualTo(new RobotCosts(Map.of(Unit.ORE, 2, Unit.OBSIDIAN, 7)));
    }

}