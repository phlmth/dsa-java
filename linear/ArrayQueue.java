package main.java.linear;

import java.util.Arrays;

public class ArrayQueue {
    private int[] items;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
    }

    public void enqueue(int item) {
        if (isFull()) {
            throw new IllegalStateException("full");
        }
        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        }

        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return item;

    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return items[rear];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
