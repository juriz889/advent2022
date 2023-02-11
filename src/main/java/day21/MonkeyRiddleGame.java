package day21;

public class MonkeyRiddleGame {
    private final MonkeyRiddle monkeyRiddle;

    public MonkeyRiddleGame(String input) {
        monkeyRiddle = new MonkeyRiddleParser().parse(input);
    }

    public long getShoutingNumberOf(String monkey) {
        String instructionFor = monkeyRiddle.getInstructionFor(monkey);
        if (instructionFor.contains("+")) {
            String[] split = instructionFor.split("\\+");
            String leftOperand = split[0].trim();
            String rightOperand = split[1].trim();
            System.out.println("Left operand is " + leftOperand + " right is " + rightOperand);
            return getShoutingNumberOf(leftOperand) + getShoutingNumberOf(rightOperand);
        } else if (instructionFor.contains("-")) {
            String[] split = instructionFor.split("-");
            String leftOperand = split[0].trim();
            String rightOperand = split[1].trim();
            System.out.println("Left operand is " + leftOperand + " right is " + rightOperand);
            return getShoutingNumberOf(leftOperand) - getShoutingNumberOf(rightOperand);
        } else if (instructionFor.contains("*")) {
            String[] split = instructionFor.split("\\*");
            String leftOperand = split[0].trim();
            String rightOperand = split[1].trim();
            System.out.println("Left operand is " + leftOperand + " right is " + rightOperand);
            return getShoutingNumberOf(leftOperand) * getShoutingNumberOf(rightOperand);
        } else if (instructionFor.contains("/")) {
            String[] split = instructionFor.split("/");
            String leftOperand = split[0].trim();
            String rightOperand = split[1].trim();
            System.out.println("Left operand is " + leftOperand + " right is " + rightOperand);
            return getShoutingNumberOf(leftOperand) / getShoutingNumberOf(rightOperand);
        }
        return Integer.parseInt(instructionFor);
    }
}
