package day14;

import java.util.Arrays;

public class SandFall {

    public int simulateFalls(String input) {
        char[][] game = new char[1000][1000];
        String[] split = input.split("\n");
        for (String s : split) {
            String[] split1 = s.split("->");
            Integer previousX = null;
            Integer previousY = null;
            for (String s1 : split1) {
                String[] split2 = s1.split(",");
                int x = Integer.parseInt(split2[0].trim());
                int y = Integer.parseInt(split2[1].trim());
                if (previousX != null) {
                    int xDistance = x - previousX;
                    if (xDistance != 0) {
                        int xStart = previousX;
                        while (true) {
                            game[xStart][y] = '#';
                            if (xStart == x) {
                                break;
                            }
                            if (xDistance < 1) {
                                xStart--;
                            } else {
                                xStart++;
                            }
                        }

                    }
                    int yDistance = y - previousY;
                    if (yDistance != 0) {
                        int yStart = previousY;
                        while (true) {
                            game[x][yStart] = '#';
                            if (yStart == y) {
                                break;
                            }
                            if (yStart <= 0) {
                                System.out.println("test");
                            }
                            if (yDistance < 1) {
                                yStart--;
                            } else {
                                yStart++;
                            }
                        }
                    }
                }
                previousX = x;
                previousY = y;
            }
        }
        int landed = 0;
        int x = 500;
        int y = 0;
        while (true) {

            if (game[x][y] != '#' && game[x][y] != 'o') {
                y++;
            } else if (game[x - 1][y] != 'o' && game[x - 1][y] != '#') {
                x = x - 1;
                y = y + 1;
            } else if (game[x + 1][y] != 'o' && game[x + 1][y] != '#') {
                x = x + 1;
                y = y + 1;
            } else {
                game[x][y - 1] = 'o';
                x = 500;
                y = 0;
                landed++;
            }
            if (y == game[x].length) {
                break;
            }

        }
        System.out.println(Arrays.deepToString(game));
        return landed;
    }

    public int simulateFallsPart2(String input) {
        char[][] game = new char[1000][1000];
        String[] split = input.split("\n");
        int highestY = 0;
        for (String s : split) {
            String[] split1 = s.split("->");
            Integer previousX = null;
            Integer previousY = null;
            for (String s1 : split1) {
                String[] split2 = s1.split(",");
                int x = Integer.parseInt(split2[0].trim());
                int y = Integer.parseInt(split2[1].trim());
                highestY = Math.max(y, highestY);
                if (previousX != null) {
                    int xDistance = x - previousX;
                    if (xDistance != 0) {
                        int xStart = previousX;
                        while (true) {
                            game[xStart][y] = '#';
                            if (xStart == x) {
                                break;
                            }
                            if (xDistance < 1) {
                                xStart--;
                            } else {
                                xStart++;
                            }
                        }

                    }
                    int yDistance = y - previousY;
                    if (yDistance != 0) {
                        int yStart = previousY;
                        while (true) {
                            game[x][yStart] = '#';
                            if (yStart == y) {
                                break;
                            }
                            if (yStart <= 0) {
                                System.out.println("test");
                            }
                            if (yDistance < 1) {
                                yStart--;
                            } else {
                                yStart++;
                            }
                        }
                    }
                }
                previousX = x;
                previousY = y;
            }
        }
        highestY += 2;
        for (int i = 0; i < game.length; i++) {
            game[i][highestY] = '#';
        }
        int landed = 0;
        int x = 500;
        int y = 0;
        while (true) {

            if (game[x][y] != '#' && game[x][y] != 'o') {
                y++;
            } else if (game[x - 1][y] != 'o' && game[x - 1][y] != '#' && y != 0) {
                x = x - 1;
                y = y + 1;
            } else if (game[x + 1][y] != 'o' && game[x + 1][y] != '#' && y != 0) {
                x = x + 1;
                y = y + 1;
            } else {
                if (y == 0) {
                    break;
                }
                if (game[x][y - 1] == 'o') {
                    break;
                }
                game[x][y - 1] = 'o';
                x = 500;
                y = 0;
                landed++;
            }


        }
        for (int j = 0; j <= 20; j++) {
            StringBuilder print = new StringBuilder();
            for (int i = 480; i <= 520; i++) {
                print.append(game[i][j]);
            }
            System.out.println(print);
        }
        return landed;
    }
}
