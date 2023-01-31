package day19;

import java.util.Set;

public class BluePrint {
    private final String name;
    private final RobotCosts oreRobotCosts;
    private final RobotCosts clayRobotCosts;
    private final RobotCosts obsidianRobotCosts;
    private final RobotCosts geodeRobotCosts;

    public BluePrint(String name, RobotCosts oreRobotCosts, RobotCosts clayRobotCosts, RobotCosts obsidianRobotCosts, RobotCosts geodeRobotCosts) {
        this.name = name;
        this.oreRobotCosts = oreRobotCosts;
        this.clayRobotCosts = clayRobotCosts;
        this.obsidianRobotCosts = obsidianRobotCosts;
        this.geodeRobotCosts = geodeRobotCosts;
    }

    public Set<RobotCosts> getAllRobotCosts() {
        return Set.of(getOreRobotCost(), getClayRobotCosts(), getObsidianRobotCosts(), getGeodeRobotCosts());
    }

    public RobotCosts getOreRobotCost() {
        return oreRobotCosts;
    }

    public String getName() {
        return name;
    }

    public RobotCosts getClayRobotCosts() {
        return clayRobotCosts;
    }

    public RobotCosts getObsidianRobotCosts() {
        return obsidianRobotCosts;
    }

    public RobotCosts getGeodeRobotCosts() {
        return geodeRobotCosts;
    }
}
