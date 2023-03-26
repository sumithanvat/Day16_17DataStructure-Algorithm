package com.bridgelabz;

import java.util.Scanner;

public class BalancedParantheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an arithmetic expression: ");
        String expr = sc.nextLine();
        Stack stack = new Stack(expr.length());
        boolean isBalanced = true;
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (stack.isEmpty() && isBalanced) {
            System.out.println("The arithmetic expression is balanced.");
        } else {
            System.out.println("The arithmetic expression is not balanced.");
        }
    }
}

