package day9;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RopeSimulator {
    private Pattern DIRECTION_WITH_COUNT = Pattern.compile("^(\\S) (\\d+)");

    public int getTailMovementCount(String input) {
        CoordinatesData head = new CoordinatesData(0, 5);
        CoordinatesData tail = new CoordinatesData(0, 5);
        Set<CoordinatesData> tailVisited = new HashSet<>();
        tailVisited(tailVisited, tail);
        String[] split = input.split("\n");
        for (String s : split) {
            System.out.println("Command id " + s);
            Matcher matcher = DIRECTION_WITH_COUNT.matcher(s);
            if (matcher.find()) {
                String direction = matcher.group(1);
                int count = Integer.parseInt(matcher.group(2));
                switch (direction) {
                    case "R" -> {
                        head = new CoordinatesData(head.getX() + count, head.getY());
                        tail = moveXCoordinate(1, head, tail, tailVisited);
                    }
                    case "L" -> {
                        head = new CoordinatesData(head.getX() - count, head.getY());
                        tail = moveXCoordinate(-1, head, tail, tailVisited);
                    }
                    case "U" -> {
                        head = new CoordinatesData(head.getX(), head.getY() + count);
                        tail = moveYCoordinate(1, head, tail, tailVisited);
                    }
                    case "D" -> {
                        head = new CoordinatesData(head.getX(), head.getY() - count);
                        tail = moveYCoordinate(-1, head, tail, tailVisited);
                    }
                }
                System.out.println("New position of head is " + head);
                System.out.println("New position of tail is " + tail);
            }
        }
        return tailVisited.size();
    }

    private CoordinatesData moveYCoordinate(int movement, CoordinatesData head, CoordinatesData tail, Set<CoordinatesData> tailVisited) {
        for (int i = Math.abs(head.getY() - tail.getY()) - 1; i > 0; i--) {
            tail = new CoordinatesData(head.getX(), tail.getY() + movement);
            tailVisited(tailVisited, tail);
        }
        return tail;
    }

    private CoordinatesData moveXCoordinate(int movement, CoordinatesData head, CoordinatesData tail, Set<CoordinatesData> tailVisited) {
        for (int i = Math.abs(head.getX() - tail.getX()) - 1; i > 0; i--) {
            tail = new CoordinatesData(tail.getX() + movement, head.getY());
            tailVisited(tailVisited, tail);
        }
        return tail;
    }

    private void tailVisited(Set<CoordinatesData> tailVisited, CoordinatesData tail) {
        System.out.println("Tail visited " + tail);
        tailVisited.add(tail);
    }
}
