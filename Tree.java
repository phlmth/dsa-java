package main.java;

import java.util.ArrayList;

public class Tree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;
    private int distance;
    public void insert(int value) {
        var node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }

        var current = root;
        while (true) {
            if (value > current.value) {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            } else {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
        }
    }

    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value > current.value) current = current.rightChild;
            else if (value < current.value) current = current.leftChild;
            else return true;
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    public int min() {
        return min(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    public int height() {
        return height(root);
    }

    public boolean equal(Tree other) {
        if (other == null) {
            return false;
        }
        return equals(root, other.root);
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.value < min || root.value > max) {
            return false;
        }
        return isBinarySearchTree(root.leftChild, min, root.value - 1)
                && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public ArrayList<Integer> getNodeAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodeAtDistance(root, distance, list);
        return list;
    }

    private void getNodeAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null){
            return;
        }

        if (distance == 0) {
            list.add(root.value);
            return;
        }
        getNodeAtDistance(root.leftChild, distance - 1, list);
        getNodeAtDistance(root.rightChild, distance - 1, list);

    }
    private boolean equals(Node first, Node second) {
        if (first == null && second == null) {
            return true;
        }
        if (first != null && second != null) {
            return first.value == second.value && equals(first.leftChild, first.leftChild) && equals(first.rightChild, second.rightChild);
        }
        return false;
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    private int height(Node root) {
        if (root == null) {
            return -1;
        }
        if (root.leftChild == null && root.rightChild == null) return 0;
        return 1 + (Math.max(height(root.leftChild), height(root.rightChild)));
    }

    private int min(Node root) {
        if (isLeaf(root)) {
            return root.value;
        }
        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    private void traversePreOrder(Node root) {
        if (root == null) return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    private void traverseInOrder(Node root) {
        if (root == null) return;
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    private void traversePostOrder(Node root) {
        if (root == null) return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }
}
