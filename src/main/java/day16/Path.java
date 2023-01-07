package day16;

import java.util.List;

public class Path {
    private final Pipe currentPie;
    private final int steps;
    private final List<String> openPipes;
    private final int release;
    private final int stepRelease;

    public Path(Pipe currentPie, int steps, List<String> openPipes, int release, int stepRelease) {
        this.currentPie = currentPie;
        this.steps = steps;
        this.openPipes = openPipes;
        this.release = release;
        this.stepRelease = stepRelease;
    }

    public int getStepRelease() {
        return stepRelease;
    }

    public int getRelease() {
        return release;
    }

    public int getSteps() {
        return steps;
    }

    public Pipe getCurrentPipe() {
        return currentPie;
    }


    public List<String> getOpenPipes() {
        return openPipes;
    }

    @Override
    public String toString() {
        return "Path{" +
                "currentPie=" + currentPie +
                ", steps=" + steps +
                ", openPipes=" + openPipes +
                ", release=" + release +
                '}';
    }
}
