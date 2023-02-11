package day20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CircularList<T> {
    private final List<Node<T>> allItems = new LinkedList<>();

    public static class Node<S> {
        private final S value;
        private Node<S> next;
        private Node<S> previous;

        public Node<S> getNext() {
            return next;
        }

        public Node(S value) {
            this.value = value;
        }

        public S getValue() {
            return value;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public void addValue(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        allItems.add(newNode);
        newNode.previous = tail;
        newNode.next = head;
        tail = newNode;
        tail.next = head;
        head.previous = tail;
    }

    public List<Node<T>> getAllNodesIterator() {
        return allItems;
    }

    public void moveNode(Node<T> start, int move) {
        System.out.println("Found node to move " + start.value);
        Node<T> previous = start.previous;
        Node<T> next = start.next;
        if (start == head) {
            head = next;
        }
        previous.next = next;
        next.previous = previous;
        if (move < 0) {
            for (int i = 0; i > move; i--) {
                next = previous;
                previous = previous.previous;
            }
        } else {
            for (long i = 0; i < move; i++) {
                previous = next;
                next = next.next;
            }
        }
        previous.next = start;
        start.previous = previous;
        start.next = next;
        next.previous = start;
    }

    public List<T> toList() {
        List<T> result = new ArrayList<>();
        Node<T> currentNode = head;
        if (head == null) {
            return result;
        } else {
            do {
                result.add(currentNode.value);
                currentNode = currentNode.next;
            } while (currentNode != head);
            return result;
        }
    }

    public Node<T> findByValue(T value) {
        Node<T> currentNode = head;
        if (head == null) {
            return null;
        } else {
            do {
                if (currentNode.value == value) {
                    return currentNode;
                }
                currentNode = currentNode.next;
            } while (true);
        }
    }

}
