package main.java;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items = new int[2];
    private int count;

    public void add(int item) {
        if (isFull()) {
            items = Arrays.copyOf(items, count * 2);
        }
        var i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }

    public int shiftItemsToInsert(int item) {
        int i;
        for (i  = count - 1; i >= 0; i--){
            if (items[i] > item)
                items[i + 1] = items[i];
            else break;
        }
        return i + 1;
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[--count];
    }

    private boolean isFull() {
        return count == items.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
