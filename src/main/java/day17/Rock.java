package day17;

import java.util.Arrays;
import java.util.List;

public class Rock {
    private final char[][] dimension;

    public Rock(char[][] dimension) {
        this.dimension = dimension;
    }

    public char[][] getDimension() {
        return dimension;
    }

    public int getWidth() {
        return dimension[0].length;
    }

    public int getHeight() {
        return dimension.length;
    }

    public boolean hasCollision(int xStart, int yStart, List<char[]> game) {
        int dimensionIndex = dimension.length;
        if ((game.size() - dimensionIndex - yStart) < 0 || xStart < 0) {
            return true;
        }
        for (int i = 0; i < dimension.length; i++) {
            char[] myRow = dimension[i];
            for (int i1 = 0; i1 < myRow.length; i1++) {
                char myChar = myRow[i1];
                char[] row = game.get(game.size() - dimensionIndex - yStart);
                char otherChart = row[i1 + xStart];
                if (myChar != '#' || otherChart != '#') {
                    continue;
                }
                return true;
            }
            dimensionIndex--;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Rock{" +
                "dimension=" + Arrays.deepToString(dimension) +
                '}';
    }
}
