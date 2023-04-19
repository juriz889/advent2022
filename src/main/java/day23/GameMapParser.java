package day23;

import java.util.ArrayList;
import java.util.List;

public class GameMapParser {

    public GameMap parse(String mapString) {
        String[] split = mapString.split("\n");
        List<String> strings = exendSplit(split);
        GameCharacter[][] gameMapCharacters = new GameCharacter[strings.size()][];
        var gameLine = 0;
        for (String s : strings) {
            s = extendS(s);
            GameCharacter[] gameMapCharactersLine = new GameCharacter[s.length()];
            char[] lineCharacter = s.toCharArray();
            for (int i = 0; i < lineCharacter.length; i++) {
                if (lineCharacter[i] == '.') {
                    gameMapCharactersLine[i] = Space.INSTANCE;
                } else if (lineCharacter[i] == '#') {
                    gameMapCharactersLine[i] = new Elf();
                }
            }
            gameMapCharacters[gameLine] = gameMapCharactersLine;
            gameLine++;
        }
        return new GameMap(gameMapCharacters);
    }

    private List<String> exendSplit(String[] split) {
        StringBuilder blank = new StringBuilder();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < split[0].length(); i++) {
            blank.append('.');
        }
        for (int i = 0; i <= 10; i++) {
            result.add(blank.toString());
        }
        result.addAll(List.of(split));
        for (int i = 0; i <= 10; i++) {
            result.add(blank.toString());
        }
        return result;
    }

    private String extendS(String s) {
        return ".........." + s + "..........";
    }
}
