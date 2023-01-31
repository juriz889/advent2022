package day19;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class BluePrintParser {
    private final Pattern BLUEPRINT = Pattern.compile("Blueprint (\\d+): Each ore robot costs (\\d+) ore. Each clay robot costs (\\d+) ore. Each obsidian robot costs (\\d+) ore and (\\d+) clay. Each geode robot costs (\\d+) ore and (\\d+) obsidian.");

    public BluePrint parse(String input) {
        Matcher matcher = getBluePrintMatcher(input);
        RobotCosts oreRobotCost = getOreRobotCosts(matcher);
        RobotCosts clayRobotCosts = getClayRobotCosts(matcher);
        RobotCosts obsidianCosts = getObsidianCosts(matcher);
        RobotCosts geodeRobotCosts = getGeodeRobotCosts(matcher);
        return new BluePrint(matcher.group(1), oreRobotCost, clayRobotCosts, obsidianCosts, geodeRobotCosts);
    }

    private RobotCosts getGeodeRobotCosts(Matcher matcher) {
        return new RobotCosts(Map.of(Unit.ORE, Integer.parseInt(matcher.group(6)), Unit.OBSIDIAN, Integer.parseInt(matcher.group(7))), GeodeRoboter.INSTANCE);
    }

    private RobotCosts getObsidianCosts(Matcher matcher) {
        return new RobotCosts(Map.of(Unit.ORE, Integer.parseInt(matcher.group(4)), Unit.CLAY, Integer.parseInt(matcher.group(5))), ObsidianRobot.INSTANCE);
    }

    private RobotCosts getClayRobotCosts(Matcher matcher) {
        return new RobotCosts(Map.of(Unit.ORE, Integer.parseInt(matcher.group(3))), ClayRobot.INSTANCE);
    }

    private RobotCosts getOreRobotCosts(Matcher matcher) {
        return new RobotCosts(Map.of(Unit.ORE, Integer.parseInt(matcher.group(2))), OreRobot.INSTANCE);
    }

    private Matcher getBluePrintMatcher(String bluePrint) {
        Matcher matcher = BLUEPRINT.matcher(bluePrint);
        matcher.find();
        return matcher;
    }
}
