import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);





        // Test insert and delete for the circular list.
        CircularLinkedList circularList = new CircularLinkedList();
        System.out.println("Enter circular list numbers (0 to stop):");
        int number = readNumber(scanner);
        while (number != 0) {
            circularList.insertIfAbsent(number, circularList.size());
            number = readNumber(scanner);
        }

        int value = readNumber(scanner, "Number to insert if it is not in the circular list:");
        
        if (circularList.contains(value)) {
            System.out.println(value + " is already in the circular list.");
        } else {
            int position = readPosition(scanner, circularList.size());
            circularList.insertIfAbsent(value, position);
        }
        
        System.out.println("Circular list: " + circularList);

        value = readNumber(scanner, "Number to delete from the circular list:");
       
        if (!circularList.deleteIfPresent(value)) {
            System.out.println(value + " was not found in the circular list.");
        }
        System.out.println("Circular list: " + circularList);








        // Test insert and delete for the doubly linked list.
        DoublyLinkedList doublyList = new DoublyLinkedList();
        System.out.println("\nEnter doubly linked-list numbers (0 to stop):");
        number = readNumber(scanner);
        
        while (number != 0) {
            doublyList.insertIfAbsent(number, doublyList.size());
            number = readNumber(scanner);
        }

        value = readNumber(scanner, "Number to insert if it is not in the doubly linked list:");
        if (doublyList.contains(value)) {
            System.out.println(value + " is already in the doubly linked list.");
        } else {
            int position = readPosition(scanner, doublyList.size());
            doublyList.insertIfAbsent(value, position);
        }
        System.out.println("Doubly linked list: " + doublyList);

        value = readNumber(scanner, "Number to delete from the doubly linked list:");
        if (!doublyList.deleteIfPresent(value)) {
            System.out.println(value + " was not found in the doubly linked list.");
        }
        System.out.println("Doubly linked list: " + doublyList);

        scanner.close();
    }

    private static int readPosition(Scanner scanner, int size) {
        int position = readNumber(scanner, "Insert position (0 to " + size + "):");
        while (position < 0 || position > size) {
            position = readNumber(scanner, "Invalid position. Enter a number from 0 to " + size + ":");
        }
        return position;
    }

    private static int readNumber(Scanner scanner) {
        return readNumber(scanner, "Enter a number (0 to stop):");
    }

    private static int readNumber(Scanner scanner, String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a whole number:");
            scanner.next();
        }
        return scanner.nextInt();
    }
}