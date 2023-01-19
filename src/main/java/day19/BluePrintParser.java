package day19;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class BluePrintParser {
    private final Pattern BLUEPRINT = Pattern.compile("Blueprint (\\d+)");
    private final Pattern ORE_ROBOT = Pattern.compile("Each ore robot costs (\\d+) ore.");
    private final Pattern CLAY_ROBOT = Pattern.compile("Each clay robot costs (\\d+) ore.");
    private final Pattern OBSIDIAN_ROBOT = Pattern.compile("Each obsidian robot costs (\\d+) ore and (\\d+) clay.");
    private final Pattern GEODE_ROBOT = Pattern.compile("Each geode robot costs (\\d+) ore and (\\d+) obsidian.");

    public BluePrint parse(String input) {
        String[] split = input.split("\n");
        String blueprintName = getBluePrintName(split);
        RobotCosts oreRobotCost = getOreRobotCosts(split);
        RobotCosts clayRobotCosts = getClayRobotCosts(split);
        RobotCosts obsidianCosts = getObsidianCosts(split);
        RobotCosts geodeRobotCosts = getGeodeRobotCosts(split);
        return new BluePrint(blueprintName, oreRobotCost, clayRobotCosts, obsidianCosts, geodeRobotCosts);
    }

    private RobotCosts getGeodeRobotCosts(String[] split) {
        String obsidianRobot = split[4];
        Matcher matcher = GEODE_ROBOT.matcher(obsidianRobot);
        matcher.find();
        return new RobotCosts(Map.of(Unit.ORE, Integer.parseInt(matcher.group(1)), Unit.OBSIDIAN, Integer.parseInt(matcher.group(2))));
    }

    private RobotCosts getObsidianCosts(String[] split) {
        String obsidianRobot = split[3];
        Matcher matcher = OBSIDIAN_ROBOT.matcher(obsidianRobot);
        matcher.find();
        return new RobotCosts(Map.of(Unit.ORE, Integer.parseInt(matcher.group(1)), Unit.CLAY, Integer.parseInt(matcher.group(2))));
    }

    private RobotCosts getClayRobotCosts(String[] split) {
        String clayRobot = split[2];
        Matcher matcher = CLAY_ROBOT.matcher(clayRobot);
        matcher.find();
        return new RobotCosts(Map.of(Unit.ORE, Integer.parseInt(matcher.group(1))));
    }

    private RobotCosts getOreRobotCosts(String[] split) {
        String oreRobot = split[1];
        Matcher matcher = ORE_ROBOT.matcher(oreRobot);
        matcher.find();
        return new RobotCosts(Map.of(Unit.ORE, Integer.parseInt(matcher.group(1))));
    }

    private String getBluePrintName(String[] split) {
        String bluePrint = split[0];
        Matcher matcher = BLUEPRINT.matcher(bluePrint);
        matcher.find();
        return matcher.group(1);
    }
}
