package main.java.linear;

public class Array {
    private int[] items;
    private int count;

    public Array() {
        new Array(0);
    }

    public Array(int length) {
        if (length < 1) {
            items = new int[1];
            return;
        }
        items = new int[length];
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    public int length() {
        return count;
    }

    public void insert(int item) {
        if (count == items.length) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[count++] = item;
    }

    public void removeAt(int index) {
        if(index < 0 || index >= count){
            throw new IllegalArgumentException();
        }

        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }

        count--;
    }

    public int indexOf(int number) {
        for (int i = 0; i < count; i++) {
            if (number == items[i]) {
                return i;
            }
        }
        return -1;
    }

}