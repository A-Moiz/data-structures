import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class main {
    static Scanner input = new Scanner(System.in);

    // Array
    static int arrayLength = 10;
    static String[] array = new String[arrayLength];

    public static void main(String[] args) {
        mainMenu();
    }

    private static void menuOptions() {
        System.out.println("--------------------------------------------------");
        System.out.println("Please choose one of the following options:");
        System.out.println("----------");
        System.out.println("1: Array");
        System.out.println("----------");
        System.out.println("6: Exit");
        System.out.println("----------");
    }

    private static void mainMenu() {
        int num = -1;
        while (num < 0) {
            menuOptions();
            try {
                int choice = Integer.valueOf(input.nextLine());
                switch (choice) {
                    case 1:
                        arrayMenu();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid option entered");
                num = -1;
            }
        }
    }

    private static void arrayMenu() {
        int num = -1;
        while (num < 0) {
            arrayOptions();
            try {
                int choice = Integer.valueOf(input.nextLine());
                switch (choice) {
                    case 1:
                        if (array[array.length - 1] != null) {
                            System.out.println("Array is full right now, remove an item before adding something new.");
                        } else {
                            addToArray();
                        }
                        break;
                    case 2:
                        viewArray();
                        break;
                    case 3:
                        deleteFromArray();
                        break;
                    case 6:
                        num = 0;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid option entered");
                num = -1;
            }
        }
    }

    private static void arrayOptions() {
        System.out.println("--------------------------------------------------");
        System.out.println("Please choose one of the following options:");
        System.out.println("--------------------");
        System.out.println("1: Add to array (String)");
        System.out.println("--------------------");
        System.out.println("2: View array (String)");
        System.out.println("--------------------");
        System.out.println("3: Delete from array (String)");
        System.out.println("--------------------");
        System.out.println("4: Save array to file (String)");
        System.out.println("--------------------");
        System.out.println("5: Load array from file (String)");
        System.out.println("--------------------");
        System.out.println("6: Back to main menu");
        System.out.println("--------------------");
    }

    // Array
    private static void deleteFromArray() {
        int index = getIndexInput();
        if (array[index] != null) {
            System.out.println(array[index] + " has been removed from the Array.");
            array[index] = null;
        } else {
            System.out.println("The index selected is already null.");
        }
    }

    private static int getIndexInput() {
        System.out.println("--------------------------------------------------");
        viewArray();
        int index = -1;
        boolean validIndex = false;
        while (!validIndex) {
            System.out.print("Select the index of the item you want to remove: ");
            try {
                index = main.input.nextInt();
                if (index >= 0 && index < array.length) {
                    validIndex = true;
                } else {
                    System.out.println("Invalid index. Please enter a valid index.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid index.");
            }
        }
        return index;
    }



    private static void viewArray() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                System.out.println(i + ": " + "Empty");
            } else {
                System.out.println(i + ": " + array[i]);
            }
        }
    }

    private static void addToArray() {
        String input = getInputForArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = input;
                System.out.println("Added '" + input + "' to the array.");
                break;
            }
        }
    }

    private static String getInputForArray() {
        String input = "";
        while (!isValidWord(input)) {
            System.out.print("Add to Array: ");
            input = main.input.nextLine();
        }
        return input;
    }

    private static boolean isValidWord(String input) {
        return Pattern.matches("[a-zA-Z]+", input);
    }
}
