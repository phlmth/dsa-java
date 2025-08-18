package main.java.linear;

import java.util.Queue;
import java.util.Stack;

public class QueueReverser {
    public static void reverse(Queue<Integer> queue) {
        java.util.Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());
    }
}
