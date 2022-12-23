package day9;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RopeSimulatorMultiTails {
    private final Pattern DIRECTION_WITH_COUNT = Pattern.compile("^(\\S) (\\d+)");

    public int getTailMovementCount(String input) {
        Knot head = new Knot(new CoordinatesData(0, 0), "head");
        List<Knot> knots = new ArrayList<>();
        knots.add(head);
        for (int i = 0; i <= 8; i++) {
            knots.add(new Knot(new CoordinatesData(0, 0), String.valueOf(i + 1)));
        }
        // System.out.println("Initial knots " + knots);
        String[] split = input.split("\n");
        for (String s : split) {
            //System.out.println("Command id " + s);
            Matcher matcher = DIRECTION_WITH_COUNT.matcher(s);
            if (matcher.find()) {
                String direction = matcher.group(1);
                int count = Integer.parseInt(matcher.group(2));
                switch (direction) {
                    case "R" -> {
                        moveXCoordinate(1, knots, count);
                    }
                    case "L" -> {
                        moveXCoordinate(-1, knots, count);
                    }
                    case "U" -> {
                        moveYCoordinate(1, knots, count);
                    }
                    case "D" -> {
                        moveYCoordinate(-1, knots, count);
                    }
                }
                // System.out.println("New position of head is " + head);
                printKnots(knots);
                //System.out.println("New position of tail is " + getLastKnot(knots));
            }
        }
        return getLastKnot(knots).getVisited();
    }

    private void printKnots(List<Knot> knots) {
        for (Knot knot : knots) {
            System.out.println("All knots " + knot);
        }
    }

    private Knot getLastKnot(List<Knot> knots) {
        return knots.get(knots.size() - 1);
    }

    private void moveYCoordinate(int movement, List<Knot> knots, int count) {
        int toMove = count - 1;
        for (int i = 0; i <= toMove; i++) {
            Knot nextKnot = knots.get(0);
            for (Knot knot : knots) {
                if (isConnected(knot, nextKnot)) {
                    break;
                }
                if (knot.getX() == nextKnot.getX()) {
                    knot.moveY(movement, nextKnot.getX());
                } else {
                    if (knot.getX() > nextKnot.getX()) {
                        knot.moveY(movement, knot.getX() - 1);
                    } else {
                        knot.moveY(movement, knot.getX() + 1);
                    }
                }
                nextKnot = knot;
            }
        }
    }

    private boolean isConnected(Knot knot, Knot nextKnot) {
        if (nextKnot == knot) {
            return false;
        }
        return (Math.abs(knot.getX() - nextKnot.getX()) == 1 && Math.abs(knot.getY() - nextKnot.getY()) == 1) || (knot.getX() == nextKnot.getX() && Math.abs(knot.getY() - nextKnot.getY()) == 1) || (knot.getY() == nextKnot.getY() && Math.abs(knot.getX() - nextKnot.getX()) == 1) || (knot.getX() == nextKnot.getX() && knot.getY() == nextKnot.getY());
    }

    private void moveXCoordinate(int movement, List<Knot> knots, int count) {
        int toMove = count - 1;
        for (int i = 0; i <= toMove; i++) {
            Knot nextKnot = knots.get(0);
            boolean hasCross = false;
            for (Knot knot : knots) {
                if (isConnected(knot, nextKnot)) {
                    continue;
                }
                if (knot.getY() == nextKnot.getY() || knot.getY() + 1 == nextKnot.getY()) {
                    knot.moveX(movement, nextKnot.getY());
                } else {
                    if (knot.getY() > nextKnot.getY()) {
                        int y = knot.getY() - 1;
                        if (hasCross) {
                            knot.moveY(-1, nextKnot.getLastX());
                        } else {
                            knot.moveX(movement, y);
                        }
                    } else {
                        int y = knot.getY() + 1;
                        if (hasCross) {
                            knot.moveY(1, nextKnot.getLastX());
                        } else {
                            knot.moveX(movement, y);
                        }
                    }
                    hasCross = false;
                }
                nextKnot = knot;
            }
        }
    }

}
