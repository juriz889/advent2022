package day17;

import java.util.List;

public class FallingRock {
    private final Rock rock;
    private int startX;
    private int startY;

    public FallingRock(Rock rock, int startX, int startY) {
        this.rock = rock;
        this.startX = startX;
        this.startY = startY;
    }

    public void applyWind(char wind, List<char[]> game) {
        if (wind == '<' && startX - 1 >= 0 && !this.hasCollision(game, this.startX - 1, this.startY)) {
            startX = Math.max(0, startX - 1);
        } else {
            if (wind == '>' && startX + rock.getWidth() <= 6 && !this.hasCollision(game, startX + 1, startY)) {
                startX = startX + 1;
            }
        }
    }

    public boolean moveDownIfPossible(List<char[]> game) {
        if (!this.hasCollision(game, this.startX, startY + 1)) {
            this.startY = startY + 1;
            return true;
        }
        return false;
    }

    public void undrawRock(List<char[]> game) {
        int dimensionIndex = rock.getDimension().length;
        for (char[] myRow : rock.getDimension()) {
            char[] row = game.get(game.size() - dimensionIndex - startY);
            for (int i = 0; i < myRow.length; i++) {
                if (myRow[i] == '#') {
                    row[i + startX] = '.';
                }
            }
            dimensionIndex--;
        }
    }

    public void drawRock(List<char[]> game) {
        int dimensionIndex = this.rock.getDimension().length;
        for (char[] myRow : this.rock.getDimension()) {
            char[] row = game.get(game.size() - dimensionIndex - startY);
            for (int i = 0; i < myRow.length; i++) {
                if (row[i + startX] == '.') {
                    row[i + startX] = myRow[i];
                }
            }
            dimensionIndex--;
        }
    }

    private boolean hasCollision(List<char[]> game, int x, int y) {
        int dimensionIndex = rock.getDimension().length;
        if ((game.size() - dimensionIndex - y) < 0) {
            return true;
        }
        for (int i = 0; i < rock.getDimension().length; i++) {
            char[] myRow = rock.getDimension()[i];
            for (int i1 = 0; i1 < myRow.length; i1++) {
                char myChar = myRow[i1];
                char[] row = game.get(game.size() - dimensionIndex - y);
                char otherChart = row[i1 + x];
                if (myChar != '#' || otherChart != '#') {
                    continue;
                }
                return true;
            }
            dimensionIndex--;
        }
        return false;
    }
}
