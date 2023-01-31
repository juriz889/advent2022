package day19;

public class GeodeRoboter implements Robot {
    private static final String NAME = "GEODE";
    public static final Robot INSTANCE = new GeodeRoboter();

    private GeodeRoboter() {

    }

    @Override
    public UnitAmount collect() {
        return new UnitAmount(Unit.GEODE, 1);
    }

    @Override
    public String getName() {
        return NAME;
    }

}
