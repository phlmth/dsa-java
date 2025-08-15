package main.java;

import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;


    private boolean isEmpty() {
        if (first == null) {
            return true;
        }
        return false;
    }

    public void addLast(int item) {
        var node = new Node(item);
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int item) {
        var node = new Node(item);

        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;

        while (current != null) {
            if (current.value == item) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first.next == last) {
            first = null;
            last = null;
            return;
        }
        size--;

        var second = first.next;
        first.next = null;
        first = second;
    }

    public void removeLast() {
        last = getPrevious(last);
        last.next = null;
        size--;
    }

    public Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        int index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse() {
        if (isEmpty()) return;

        var previous = first;
        var current = previous.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromTheEnd(int k) {
        if (k < 1 || isEmpty() || k > size)
            throw new IllegalArgumentException();
        if (k == 1) return last.value;

        var a = first;
        var b = a;

        for(int i = 0; i < k - 1; i++)
            b = b.next;

        while (b != last){
            a = a.next;
            b = b.next;
        }

        return a.value;
    }

    public void push(int item){
        addFirst(item);
    }

    public void pop(){
        removeFirst();
    }

    public int peek(){
        if(isEmpty()) throw new IllegalStateException("Stack is empty");
        return first.value;
    }
}
