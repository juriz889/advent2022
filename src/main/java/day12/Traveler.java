package day12;


import java.util.*;

public class Traveler {

    public int getLeastTravels(String input) {
        String[] split = input.split("\n");
        char[][] characters = new char[split.length][split[0].length()];
        int i = 0;
        int startY = 0;
        int startX = 0;
        for (String s : split) {
            char[] chars = s.toCharArray();
            for (int i1 = 0; i1 < chars.length; i1++) {
                if (chars[i1] == 'S') {
                    startY = i1;
                    startX = i;

                }
            }
            characters[i++] = chars;

        }
        return calcLeastTravels(characters, startX, startY, new HashSet<>());
    }

    private int calcLeastTravels(char[][] characters, int x, int y, Set<CoordinatesData> alreadyVisited) {
        Queue<CoordinatesData> toTraverse = new LinkedList<>();
        Map<CoordinatesData, Integer> toTraverseSet = new HashMap<>();
        toTraverse.add(new CoordinatesData(x, y, 0));
        int lowestSolution = Integer.MAX_VALUE;
        while (!toTraverse.isEmpty()) {
            CoordinatesData currentCoordinate = toTraverse.poll();
            x = currentCoordinate.getX();
            y = currentCoordinate.getY();
            alreadyVisited.add(currentCoordinate);
            char currentChar = characters[currentCoordinate.getX()][currentCoordinate.getY()];
            if (currentChar == 'E') {
                System.out.println("Reached E with " + currentCoordinate.getDistance());
                lowestSolution = Math.min(currentCoordinate.getDistance(), lowestSolution);
            }
            int xPlus1 = currentCoordinate.getX() + 1;
            if (getNumericValue(y, xPlus1, characters, currentChar, alreadyVisited)) {
                CoordinatesData e = new CoordinatesData(xPlus1, y, currentCoordinate.getDistance() + 1);
                extracted(toTraverse, toTraverseSet, e);
            }
            int xMinus1 = x - 1;
            if (getNumericValue(y, xMinus1, characters, currentChar, alreadyVisited)) {
                CoordinatesData e = new CoordinatesData(xMinus1, y, currentCoordinate.getDistance() + 1);
                extracted(toTraverse, toTraverseSet, e);
            }

            int yPlusOne = y + 1;
            if (getNumericValue(yPlusOne, x, characters, currentChar, alreadyVisited)) {
                CoordinatesData e = new CoordinatesData(x, yPlusOne, currentCoordinate.getDistance() + 1);
                extracted(toTraverse, toTraverseSet, e);
            }
            int yMinusOne = y - 1;
            if (getNumericValue(yMinusOne, x, characters, currentChar, alreadyVisited)) {
                CoordinatesData e = new CoordinatesData(x, yMinusOne, currentCoordinate.getDistance() + 1);
                extracted(toTraverse, toTraverseSet, e);
            }
        }

        return lowestSolution;
    }

    private void extracted(Queue<CoordinatesData> toTraverse, Map<CoordinatesData, Integer> toTraverseSet, CoordinatesData e) {
        Integer integer = toTraverseSet.get(e);
        if (integer == null) {
            toTraverseSet.put(e, e.getDistance());
            toTraverse.add(e);
        }
    }

    private boolean getNumericValue(int y, int x, char[][] characters, char currentChar, Set<CoordinatesData> visited) {
        if (x >= 0 && characters.length > x && y >= 0 && characters[x].length > y) {
            if (characters[x][y] == 'E') {
                return Character.getNumericValue('z') - Character.getNumericValue(currentChar) <= 1;
            }
            boolean isLess = Character.getNumericValue(characters[x][y]) - Character.getNumericValue(currentChar) <= 1;
            return isLess && !visited.contains(new CoordinatesData(x, y, 0));
        }
        return false;
    }

    public int getLeastTravelsFromA(String input) {
        String[] split = input.split("\n");
        char[][] characters = new char[split.length][split[0].length()];
        int i = 0;
        for (String s : split) {
            char[] chars = s.toCharArray();
            characters[i++] = chars;

        }
        int lowestResult = Integer.MAX_VALUE;
        int startX = 0;
        for (char[] character : characters) {
            int startY = 0;
            for (char c : character) {
                if (c == 'a') {
                    lowestResult = Math.min(calcLeastTravels(characters, startX, startY, new HashSet<>()), lowestResult);
                }
                startY++;
            }
            startX++;
        }
        return lowestResult;
    }
}
