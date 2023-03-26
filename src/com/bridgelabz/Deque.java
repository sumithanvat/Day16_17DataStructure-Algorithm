package com.bridgelabz;
import java.util.*;
public class Deque {
    ArrayList<Character> items;

    public Deque() {
        items = new ArrayList<>();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void addFront(char item) {
        items.add(0, item);
    }

    public void addRear(char item) {
        items.add(item);
    }

    public char removeFront() {
        return items.remove(0);
    }

    public char removeRear() {
        return items.remove(items.size() - 1);
    }

    public int size() {
        return items.size();
    }
}
