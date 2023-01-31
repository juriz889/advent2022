package day19;

public class ClayRobot implements Robot {
    private static final String NAME = "CLAY";
    public static final Robot INSTANCE = new ClayRobot();

    private ClayRobot() {
    }

    @Override
    public UnitAmount collect() {
        return new UnitAmount(Unit.CLAY, 1);
    }

    @Override
    public String getName() {
        return ClayRobot.NAME;
    }

}
