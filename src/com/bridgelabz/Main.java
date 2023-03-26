package com.bridgelabz;

import static com.bridgelabz.PalidromeChecker.isPalindrome;

public class Main {
    public static void main(String[] args) {
        String input = "radar";
        System.out.println(isPalindrome(input));
        input = "toot";
        System.out.println(isPalindrome(input));

        input = "madam";
        System.out.println(isPalindrome(input));

        input = "hello";
        System.out.println(isPalindrome(input));
    }
}

