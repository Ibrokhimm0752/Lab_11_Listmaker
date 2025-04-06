import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> list = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String menuOption;
        do {
            displayMenu();
            menuOption = SafeInput.getRegExString(in, "Choose an option [A, D, I, P, Q]", "[AaDdIiPpQq]");
            switch (menuOption.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(in, "Are you sure you want to quit? ")) {
                        System.out.println("Exiting program.");
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (true);
    }

    private static void displayMenu() {
        System.out.println("\nCurrent List:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
        System.out.println("\nMenu Options:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("I - Insert an item into the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }

    private static void addItem() {
        String newItem = SafeInput.getNonZeroLenString(in, "Enter the item to add");
        list.add(newItem);
        System.out.println("Item added.");
    }

    private static void deleteItem() {
        if (list.isEmpty()) {
            System.out.println("The list is empty, nothing to delete.");
            return;
        }
        int itemNumber = SafeInput.getRangedInt(in, "Enter the item number to delete:", 1, list.size());
        list.remove(itemNumber - 1);
        System.out.println("Item deleted.");
    }

    private static void insertItem() {
        if (list.isEmpty()) {
            System.out.println("List is empty, inserting at the first position.");
        }
        int position = SafeInput.getRangedInt(in, "Enter the position to insert the item " + (list.size() + 1), 1, list.size() + 1);
        String newItem = SafeInput.getNonZeroLenString(in, "Enter the item to insert");
        list.add(position - 1, newItem);
        System.out.println("Item inserted.");
    }

    private static void printList() {
        System.out.println("\nCurrent List:");
        if (list.isEmpty()) {
            System.out.println("The list is currently empty.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }
}