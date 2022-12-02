package day2;

public enum GameResultEnum {
    LOSS(0), DRAW(3), WIN(6);
    private final int userScore;

    GameResultEnum(int userScore) {
        this.userScore = userScore;
    }

    public int getUserScore() {
        return userScore;
    }
}
