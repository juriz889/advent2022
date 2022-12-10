package day3;

import java.util.*;
import java.util.stream.Collectors;

public class PriorityCounter {
    private static final Map<Character, Integer> PRIORITY = new HashMap<>();

    static {


        int priority = 0;
        for (
                char alphabet = 'a';
                alphabet <= 'z'; alphabet++) {
            PRIORITY.put(alphabet, ++priority);
        }
        for (
                char alphabet = 'A';
                alphabet <= 'Z'; alphabet++) {
            PRIORITY.put(alphabet, ++priority);
        }
    }

    public int findPriority(String input) {
        String[] split = input.split("\n");
        int sum = 0;
        for (String s : split) {
            String trimmed = s.trim();
            String firstPart = trimmed.substring(0, trimmed.length() / 2).trim();
            String secondPart = trimmed.substring(trimmed.length() / 2);
            System.out.println("Firstpart " + firstPart);
            System.out.println("Secondpart " + secondPart);
            Set<Character> collect = firstPart.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
            for (Character c : collect) {
                if (secondPart.contains(String.valueOf(c))) {
                    sum += PRIORITY.get(c);
                }
            }
        }
        return sum;
    }

    public int findBatches(String input) {
        String[] split = input.split("\n");
        List<Set<Character>> uniqueCharacterOnEachLine = new ArrayList<>();
        for (String s : split) {
            Set<Character> collect = s.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
            uniqueCharacterOnEachLine.add(collect);
        }

        int i = 0;
        int sum = 0;
        for (Set<Character> characters : uniqueCharacterOnEachLine) {
            if ((i + 1) % 3 == 0) {
                System.out.println("Proccessing line " + characters);
                for (Character c : characters) {
                    if (uniqueCharacterOnEachLine.get(i - 1).contains(c) && uniqueCharacterOnEachLine.get(i - 2).contains(c)) {
                        System.out.println("Found character " + c);
                        sum += PRIORITY.get(c);
                    }
                }
            }
            i++;
        }
        return sum;
    }
}
