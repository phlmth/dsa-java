package main.java.functions;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {
    private static final List<Character> rightBrackets = Arrays.asList(')', '>', ']', '}');
    private static final List<Character> leftBrackets = Arrays.asList('(', '<', '[', '{');

    public static boolean isBalanced(String input){
        Stack<Character> stack = new Stack<>();
        for(Character c : input.toCharArray()) {
            if (isLeftBracket(c)) {
                stack.push(c);
            }
            if (isRightBracket(c)) {
                if (stack.empty()) return false;

                var top = stack.pop();
                if(bracketMatch(top, c)) return false;
            }
        }
        return stack.empty();
    }

    private static boolean isLeftBracket(Character c) {
        return leftBrackets.contains(c);
    }

    private static boolean isRightBracket(Character c) {
        return rightBrackets.contains(c);
    }

    private static boolean bracketMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
}
