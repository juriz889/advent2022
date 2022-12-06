package day6;

import java.util.HashSet;
import java.util.Set;

public class SignalDetector {

    public int getFirstMarker(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length - 3; i++) {
            Set<Character> lastFourCharacterVisited = new HashSet<>();
            lastFourCharacterVisited.add(chars[i]);
            lastFourCharacterVisited.add(chars[i + 1]);
            lastFourCharacterVisited.add(chars[i + 2]);
            lastFourCharacterVisited.add(chars[i + 3]);
            if (lastFourCharacterVisited.size() == 4) {
                return i + 4;
            }
        }
        return -1;
    }

    public int getMessageMarker(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length - 13; i++) {
            Set<Character> lastFourCharacterVisited = new HashSet<>();
            for (int j = i; j <= i + 13; j++) {
                lastFourCharacterVisited.add(chars[j]);
            }
            if (lastFourCharacterVisited.size() == 14) {
                return i + 14;
            }
        }
        return -1;
    }
}
