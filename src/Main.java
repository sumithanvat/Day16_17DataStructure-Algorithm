import java.io.*;
        import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        String filename = "input.txt";
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                insertSorted(list, num);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return;
        }
        System.out.println("List before operation: " + list);

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to insert or delete: ");
        int num = input.nextInt();
        if (list.contains(num)) {
            list.add(Integer.valueOf(num));
            System.out.println("Number " + num + " removed from the list.");
        } else {
            insertSorted(list, num);
            System.out.println("Number " + num + " inserted in the list.");
        }
        input.close();

        System.out.println("List after operation: " + list);

        filename = "output.txt";
        try {
            PrintWriter writer = new PrintWriter(new File(filename));
            for (int n : list) {
                writer.println(n);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return;
        }
        System.out.println("List written to file: " + filename);
    }

    public static void insertSorted(LinkedList<Integer> list, int num) {
        ListIterator<Integer> iter = list.listIterator();
        while (iter.hasNext()) {
            if (num < iter.next()) {
                iter.previous();
                iter.add(num);
                return;
            }
        }
        list.add(num);
    }
}
