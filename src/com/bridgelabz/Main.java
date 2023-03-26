package com.bridgelabz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankCashCounter counter = new BankCashCounter();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add customer");
            System.out.println("2. Process customers");
            System.out.println("3. Check cash balance");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    counter.addCustomer();
                    break;
                case 2:
                    counter.processCustomers();
                    break;
                case 3:
                    System.out.println("Cash balance: " + counter.cashBalance);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
