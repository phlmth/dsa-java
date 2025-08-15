package main.java;

import java.util.Stack;

public class StringReverter {
    public static String reverse(String input) {
        if(input == null) {
            throw new IllegalArgumentException();
        }
        var stack = new Stack<Character>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        StringBuilder s = new StringBuilder();

        while (!stack.isEmpty()) {
            s.append(stack.pop());
        }

        return s.toString();
    }
}
