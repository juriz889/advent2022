package day19;

public class SimulationGame {

    public int solve(String input) {
        String[] split = input.split("\n");
        int sum = 0;
        for (String s : split) {
            BluePrintParser printParser = new BluePrintParser();
            BluePrint parse = printParser.parse(s);
            BluePrintSimulator simulator = new BluePrintSimulator(parse);
            SimulationState simulate = simulator.simulate(24);
            sum += simulate.getUnit(Unit.GEODE) * Integer.parseInt(parse.getName());
        }
        return sum;
    }
}
