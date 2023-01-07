package day16;

public class ShortestPath {
    private final int steps;
    private final Pipe currentPipe;

    public ShortestPath(Pipe currentPipe, int steps) {
        this.steps = steps;
        this.currentPipe = currentPipe;
    }

    public int getSteps() {
        return steps;
    }

    public Pipe getCurrentPipe() {
        return currentPipe;
    }
}
