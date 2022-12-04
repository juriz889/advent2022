package day4;

import java.util.HashSet;
import java.util.Set;

public class RangeAssignment {
    public int findOverlaps(String input) {
        String[] split = input.split("\n");
        int numberOfOverlaps = 0;
        for (String assignmentPairs : split) {
            String[] assignments = assignmentPairs.split(",");
            String firstAssignment = assignments[0];
            String secondAssignment = assignments[1];
            Set<Integer> firstRange = getNumbersFromString(firstAssignment);
            Set<Integer> secondRange = getNumbersFromString(secondAssignment);
            if (firstRange.containsAll(secondRange) || secondRange.containsAll(firstRange)) {
                numberOfOverlaps++;
            }
        }
        return numberOfOverlaps;
    }

    private Set<Integer> getNumbersFromString(String numbersRange) {
        String[] split = numbersRange.split("-");
        int start = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[1]);
        Set<Integer> result = new HashSet<>();
        while (start <= end) {
            result.add(start++);
        }
        return result;
    }

    public int findOverlapsAtAll(String input) {
        String[] split = input.split("\n");
        int numberOfOverlaps = 0;
        for (String assignmentPairs : split) {
            String[] assignments = assignmentPairs.split(",");
            String firstAssignment = assignments[0];
            String secondAssignment = assignments[1];
            Set<Integer> firstRange = getNumbersFromString(firstAssignment);
            Set<Integer> secondRange = getNumbersFromString(secondAssignment);
            if (firstRange.stream().anyMatch(secondRange::contains)) {
                numberOfOverlaps++;
            }
        }
        return numberOfOverlaps;
    }
}
