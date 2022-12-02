package day2;

import java.util.Map;

public class PaperRockScissors {
    private static final Map<Character, PaperRockerScissorSymbols> OPPONENT_SYMBOL_ENCRYPTION = Map.of('A', PaperRockerScissorSymbols.ROCK, 'B', PaperRockerScissorSymbols.PAPER, 'C', PaperRockerScissorSymbols.SCISSORS);
    private static final Map<Character, PaperRockerScissorSymbols> MY_SYMBOL_ENCRYPTION = Map.of('X', PaperRockerScissorSymbols.ROCK, 'Y', PaperRockerScissorSymbols.PAPER, 'Z', PaperRockerScissorSymbols.SCISSORS);
    private static final Map<Character, GameResultEnum> GAME_PREDICTION = Map.of('Y', GameResultEnum.DRAW, 'X', GameResultEnum.LOSS, 'Z', GameResultEnum.WIN);

    private static final Map<PaperRockerScissorSymbols, PaperRockerScissorSymbols> BETTER_THAN = Map.of(PaperRockerScissorSymbols.SCISSORS, PaperRockerScissorSymbols.PAPER, PaperRockerScissorSymbols.PAPER, PaperRockerScissorSymbols.ROCK, PaperRockerScissorSymbols.ROCK, PaperRockerScissorSymbols.SCISSORS);
    private static final Map<PaperRockerScissorSymbols, PaperRockerScissorSymbols> WORSE_THAN = Map.of(PaperRockerScissorSymbols.SCISSORS, PaperRockerScissorSymbols.ROCK, PaperRockerScissorSymbols.PAPER, PaperRockerScissorSymbols.SCISSORS, PaperRockerScissorSymbols.ROCK, PaperRockerScissorSymbols.PAPER);

    public int calculateGameToWin(String input) {
        String[] split = input.split("\n");
        int myGameResult = 0;
        for (String s : split) {
            Character opponentCharacter = s.charAt(0);
            Character myCharacter = s.charAt(2);
            PaperRockerScissorSymbols opponentSymbol = OPPONENT_SYMBOL_ENCRYPTION.get(opponentCharacter);
            PaperRockerScissorSymbols mySymbol = MY_SYMBOL_ENCRYPTION.get(myCharacter);
            GameResultEnum resultOfGame = getResultOfGame(opponentSymbol, mySymbol);
            myGameResult += mySymbol.getScore() + resultOfGame.getUserScore();
        }
        return myGameResult;
    }

    public int calculateGameForResult(String input) {
        String[] split = input.split("\n");
        int myGameResult = 0;
        for (String s : split) {
            Character opponentCharacter = s.charAt(0);
            Character gameEndPrediction = s.charAt(2);
            PaperRockerScissorSymbols opponentSymbol = OPPONENT_SYMBOL_ENCRYPTION.get(opponentCharacter);
            GameResultEnum resultOfGame = GAME_PREDICTION.get(gameEndPrediction);
            PaperRockerScissorSymbols mySymbol = getMyCardBasedOnResult(opponentSymbol, resultOfGame);
            myGameResult += mySymbol.getScore() + resultOfGame.getUserScore();
        }
        return myGameResult;
    }

    private GameResultEnum getResultOfGame(PaperRockerScissorSymbols opponentSymbol, PaperRockerScissorSymbols mySymbol) {
        if (mySymbol == opponentSymbol) {
            return GameResultEnum.DRAW;
        }
        if (BETTER_THAN.get(mySymbol) == opponentSymbol) {
            return GameResultEnum.WIN;
        }
        return GameResultEnum.LOSS;
    }
    private PaperRockerScissorSymbols getMyCardBasedOnResult(PaperRockerScissorSymbols opponentSymbol, GameResultEnum resultToAchieve) {
        if (resultToAchieve == GameResultEnum.DRAW) {
            return opponentSymbol;
        }
        if(resultToAchieve == GameResultEnum.WIN){
            return WORSE_THAN.get(opponentSymbol);
        }
        return BETTER_THAN.get(opponentSymbol);
    }
}
