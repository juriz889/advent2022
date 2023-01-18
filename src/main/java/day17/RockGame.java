package day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RockGame {

    public int solve(String input, int rocksToFall) {
        List<Rock> rocks = List.of(createRock1(), createRock2(), createRock3(), createRock4(), createRock5());
        List<char[]> game = new ArrayList<>();
        char[] empty_line = {
                '.', '.', '.', '.', '.', '.', '.'
        };
        int blowIndex = 0;
        for (int i = 0; i < rocksToFall; i++) {
            Rock rock = rocks.get(i % rocks.size());
            game.add(empty_line.clone());
            game.add(empty_line.clone());
            for (int z = 0; z < rock.getHeight(); z++) {
                game.add(empty_line.clone());
            }
            game.add(empty_line.clone());
            FallingRock fallingRock = new FallingRock(rock, 2, 0);
            fallingRock.drawRock(game);
            boolean canFallDown = true;
            while (canFallDown) {
                fallingRock.undrawRock(game);
                if (blowIndex >= input.length()) {
                    blowIndex = 0;
                }
                char c = input.charAt(blowIndex);
                fallingRock.applyWind(c, game);
                blowIndex++;
                canFallDown = fallingRock.moveDownIfPossible(game);
                fallingRock.drawRock(game);
            }
            while (true) {
                char[] chars = game.get(game.size() - 1);
                boolean isEmpty = isLineEmpty(chars);
                if (isEmpty) {
                    game.remove(game.size() - 1);
                } else {
                    break;
                }
            }
            if (i == 21 || i == 20) {
                drawGame(game);
            }
        }


        return game.size();
    }

    private boolean isLineEmpty(char[] chars) {
        for (int i1 = 0; i1 < chars.length; i1++) {
            if (chars[i1] != '.') {
                return false;
            }
        }
        return true;
    }

    private void drawGame(List<char[]> game) {
        System.out.println("Game :");
        for (int i = game.size() - 1; i >= 0; i--) {
            System.out.println(Arrays.toString(game.get(i)));
        }


    }

    private Rock createRock1() {
        char[][] dimension = new char[1][4];
        dimension[0][0] = '#';
        dimension[0][1] = '#';
        dimension[0][2] = '#';
        dimension[0][3] = '#';
        return new Rock(dimension);
    }

    private Rock createRock2() {
        char[][] dimension = new char[3][3];
        dimension[0][0] = '.';
        dimension[0][1] = '#';
        dimension[0][2] = '.';
        dimension[1][0] = '#';
        dimension[1][1] = '#';
        dimension[1][2] = '#';
        dimension[2][0] = '.';
        dimension[2][1] = '#';
        dimension[2][2] = '.';
        return new Rock(dimension);
    }

    private Rock createRock3() {
        char[][] dimension = new char[3][3];
        dimension[0][0] = '#';
        dimension[0][1] = '#';
        dimension[0][2] = '#';
        dimension[1][0] = '.';
        dimension[1][1] = '.';
        dimension[1][2] = '#';
        dimension[2][0] = '.';
        dimension[2][1] = '.';
        dimension[2][2] = '#';
        return new Rock(dimension);
    }

    private Rock createRock4() {
        char[][] dimension = new char[4][1];
        dimension[0][0] = '#';
        dimension[1][0] = '#';
        dimension[2][0] = '#';
        dimension[3][0] = '#';
        return new Rock(dimension);
    }

    private Rock createRock5() {
        char[][] dimension = new char[2][2];
        dimension[0][0] = '#';
        dimension[1][0] = '#';
        dimension[0][1] = '#';
        dimension[1][1] = '#';
        return new Rock(dimension);
    }
}
