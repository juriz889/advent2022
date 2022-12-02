package day2;

public enum PaperRockerScissorSymbols {
    ROCK(1), PAPER(2), SCISSORS(3);
    private final int score;

    PaperRockerScissorSymbols(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

}
