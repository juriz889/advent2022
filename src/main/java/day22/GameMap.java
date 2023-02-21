package day22;

public class GameMap {
    private char[][] game;

    public GameMap(String input) {
        String[] split = input.split("\n");
        int biggestWidth = getBiggestWidth(split);
        game = new char[split.length][biggestWidth];
        int x = 0;
        for (String s : split) {
            char[] chars = s.toCharArray();
            System.arraycopy(chars, 0, game[x], 0, chars.length);
            x++;
        }
    }

    private int getBiggestWidth(String[] split) {
        int biggestWidth = 0;
        for (String s : split) {
            if (s.length() > biggestWidth) {
                biggestWidth = s.length();
            }
        }
        return biggestWidth;
    }

    public int getWidth() {
        return game[0].length;
    }

    public int getHeight() {
        return game.length;
    }

    public char chartAt(int y, int x) {
        return game[y][x];
    }
}
