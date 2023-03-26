package com.bridgelabz;


import java.io.*;
        import java.util.*;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class UnorderedList<T> {
    Node<T> head;

    public UnorderedList() {
        this.head = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.next = head;
        head = newNode;
    }

    public void remove(T data) {
        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            if (current.data.equals(data)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public boolean contains(T data) {
        Node<T> current = head;

        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void saveToFile(String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        Node<T> current = head;

        while (current != null) {
            writer.write(current.data.toString() + "\n");
            current = current.next;
        }

        writer.close();
    }

    public static void main(String[] args) throws IOException {
        UnorderedList<String> list = new UnorderedList<String>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter file name to read words from: ");
        String fileName = scanner.nextLine();

        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNext()) {
            String word = fileScanner.next();
            list.add(word);
        }

        fileScanner.close();

        System.out.print("Enter word to search: ");
        String searchWord = scanner.nextLine();

        if (list.contains(searchWord)) {
            list.remove(searchWord);
            System.out.println("Word removed from list.");
        } else {
            list.add(searchWord);
            System.out.println("Word added to list.");
        }

        System.out.print("Enter file name to save words to: ");
        fileName = scanner.nextLine();
        list.saveToFile(fileName);

        scanner.close();
    }
}
