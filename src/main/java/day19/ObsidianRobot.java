package day19;

public class ObsidianRobot implements Robot {
    private static final String NAME = "OBSIDIAN";
    public static final Robot INSTANCE = new ObsidianRobot();

    private ObsidianRobot() {

    }

    @Override
    public UnitAmount collect() {
        return new UnitAmount(Unit.OBSIDIAN, 1);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
