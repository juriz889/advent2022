package day22;

public final class PathGame {
    private final String game;
    private final String instructions;

    public PathGame(String game, String instruction) {
        this.game = game;
        this.instructions = instruction;
    }

    public String getGame() {
        return game;
    }

    public String getInstructions() {
        return instructions;
    }
}
