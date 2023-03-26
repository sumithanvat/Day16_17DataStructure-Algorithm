package com.bridgelabz;

public class PalidromeChecker {
    public static boolean isPalindrome(String input) {
        Deque deque = new Deque();
        for (char c : input.toCharArray()) {
            deque.addRear(c);
        }
        while (deque.size() > 1) {
            char front = deque.removeFront();
            char rear = deque.removeRear();
            if (front != rear) {
                return false;
            }
        }
        return true;
    }
}
