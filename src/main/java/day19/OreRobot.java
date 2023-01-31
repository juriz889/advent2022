package day19;

public class OreRobot implements Robot {
    private static final String NAME = "ORE";
    public static final Robot INSTANCE = new OreRobot();

    private OreRobot() {

    }

    @Override
    public UnitAmount collect() {
        return new UnitAmount(Unit.ORE, 1);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
