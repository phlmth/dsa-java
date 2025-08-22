package main.java.algorithms;

import java.util.*;

public class CharFinder {

    public static Character findFirstNonRepeatingChar(String str) {
        Map<Character, Boolean> map = new HashMap<>();

        var chars = str.toCharArray();

        for (var ch : chars) {
            var bool = map.containsKey(ch) ? Boolean.TRUE : Boolean.FALSE;
            map.put(ch, bool);
        }

        for (var ch : chars)
            if (map.get(ch) == Boolean.FALSE) return ch;

        return Character.MIN_VALUE;
    }

    public static Character findFirstRepeatingChar(String str) {
        Set<Character> set = new HashSet<>();
        var chars = str.toCharArray();
        for (var ch : chars) {
            if (set.contains(ch))
               return ch;

            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
