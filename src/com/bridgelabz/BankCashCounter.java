package com.bridgelabz;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BankCashCounter {
    int cashBalance;
    private Queue<Customer> queue;

    public void BankingCashCounter() {
        cashBalance = 0;
        queue = new LinkedList<>();
    }

    public void addCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter transaction type (D for deposit, W for withdraw): ");
        String transactionType = scanner.nextLine().toUpperCase();

        System.out.print("Enter transaction amount: ");
        int amount = scanner.nextInt();

        queue.add(new Customer(name, transactionType, amount));
    }

    public void processCustomers() {
        while (!queue.isEmpty()) {
            Customer customer = queue.poll();
            if (customer.getTransactionType().equals("D")) {
                cashBalance += customer.getAmount();
            } else if (customer.getTransactionType().equals("W")) {
                if (customer.getAmount() > cashBalance) {
                    System.out.println("Insufficient cash balance to withdraw " + customer.getAmount() + " for " + customer.getName());
                } else {
                    cashBalance -= customer.getAmount();
                }
            }
        }
    }

}
