package src;

import java.io.*;
import java.util.Scanner;

public class main {
    static Scanner input = new Scanner(System.in);

    // Array
    static Array arrayObject = new Array();

    // Array list
    static ArrayListManager arrayListObject = new ArrayListManager();

    public static void main(String[] args) {
        mainMenu();
    }

    private static void menuOptions() {
        System.out.println("--------------------------------------------------");
        System.out.println("Please choose one of the following options:");
        System.out.println("----------");
        System.out.println("1: Array");
        System.out.println("----------");
        System.out.println("2: Array List");
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
                    case 2:
                        arrayListMenu();
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

    // ArrayList
    private static void arrayListMenu() {
        int num = -1;
        while (num < 0) {
            arrayListOptions();
            try {
                int choice = Integer.valueOf(input.nextLine());
                switch (choice) {
                    case 1:
                        arrayListObject.addToArrayList();
                        break;
                    case 2:
                        arrayListObject.viewArrayList();
                        break;
                    case 3:
                        arrayListObject.deleteFromArrayList();
                        break;
                    case 4:
                        saveArrayListMenu();
                        break;
                    case 5:
                        loadArrayListMenu();
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

    private static void arrayListOptions() {
        System.out.println("--------------------------------------------------");
        System.out.println("Please choose one of the following options:");
        System.out.println("--------------------");
        System.out.println("1: Add to ArrayList (String)");
        System.out.println("--------------------");
        System.out.println("2: View ArrayList (String)");
        System.out.println("--------------------");
        System.out.println("3: Delete from ArrayList (String)");
        System.out.println("--------------------");
        System.out.println("4: Save ArrayList to file");
        System.out.println("--------------------");
        System.out.println("5: Load ArrayList from file");
        System.out.println("--------------------");
        System.out.println("6: Back to main menu");
        System.out.println("--------------------");
    }

    private static void saveArrayListOptions() {
        System.out.println("--------------------------------------------------");
        System.out.println("Please choose one of the following options:");
        System.out.println("--------------------");
        System.out.println("1: Save ArrayList to CSV");
        System.out.println("--------------------");
        System.out.println("2: Save ArrayList to Text file");
        System.out.println("--------------------");
        System.out.println("3: Go back");
        System.out.println("--------------------");
    }

    private static void saveArrayListMenu() {
        int num = -1;
        while (num < 0) {
            saveArrayListOptions();
            try {
                int choice = Integer.valueOf(input.nextLine());
                switch (choice) {
                    case 1:
                        arrayListObject.saveArrayListToCSVFile();
                        break;
                    case 2:
                        arrayListObject.saveArrayListToTextFile();
                        break;
                    case 3:
                        num = 0;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid option entered");
                num = -1;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void loadArrayListOptions() {
        System.out.println("--------------------------------------------------");
        System.out.println("Please choose one of the following options:");
        System.out.println("--------------------");
        System.out.println("1: Load data from CSV file");
        System.out.println("--------------------");
        System.out.println("2: Load data from text file");
        System.out.println("--------------------");
        System.out.println("3: Go back");
        System.out.println("--------------------");
    }

    private static void loadArrayListMenu() {
        int num = -1;
        while (num < 0) {
            loadArrayListOptions();
            try {
                int choice = Integer.valueOf(input.nextLine());
                switch (choice) {
                    case 1:
                        arrayListObject.loadArrayListFromCSVFile();
                        break;
                    case 2:
                        arrayListObject.loadArrayListFromTextFile();
                        break;
                    case 3:
                        num = 0;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid option entered");
                num = -1;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Array
    private static void arrayMenu() {
        int num = -1;
        while (num < 0) {
            arrayOptions();
            try {
                int choice = Integer.valueOf(input.nextLine());
                switch (choice) {
                    case 1:
                        arrayObject.checkArray();
                        break;
                    case 2:
                        arrayObject.viewArray();
                        break;
                    case 3:
                        arrayObject.deleteFromArray();
                        break;
                    case 4:
                        saveArrayMenu();
                        break;
                    case 5:
                        loadArrayMenu();
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

    private static void saveArrayMenu() {
        int num = -1;
        while (num < 0) {
            saveArrayOptions();
            try {
                int choice = Integer.valueOf(input.nextLine());
                switch (choice) {
                    case 1:
                        arrayObject.saveArrayToCSVFile();
                        break;
                    case 2:
                        arrayObject.saveArrayToTextFile();
                        break;
                    case 3:
                        num = 0;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid option entered");
                num = -1;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void loadArrayMenu() {
        int num = -1;
        while (num < 0) {
            loadArrayOptions();
            try {
                int choice = Integer.valueOf(input.nextLine());
                switch (choice) {
                    case 1:
                        arrayObject.loadArrayFromCSVFile();
                        break;
                    case 2:
                        arrayObject.loadArrayFromTextFile();
                        break;
                    case 3:
                        num = 0;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid option entered");
                num = -1;
            } catch (IOException e) {
                throw new RuntimeException(e);
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
        System.out.println("4: Save array to file");
        System.out.println("--------------------");
        System.out.println("5: Load array from file");
        System.out.println("--------------------");
        System.out.println("6: Back to main menu");
        System.out.println("--------------------");
    }

    private static void saveArrayOptions() {
        System.out.println("--------------------------------------------------");
        System.out.println("Please choose one of the following options:");
        System.out.println("--------------------");
        System.out.println("1: Save array to CSV");
        System.out.println("--------------------");
        System.out.println("2: Save array to Text file");
        System.out.println("--------------------");
        System.out.println("3: Go back");
        System.out.println("--------------------");
    }

    private static void loadArrayOptions() {
        System.out.println("--------------------------------------------------");
        System.out.println("Please choose one of the following options:");
        System.out.println("--------------------");
        System.out.println("1: Load data from CSV file");
        System.out.println("--------------------");
        System.out.println("2: Load data from text file");
        System.out.println("--------------------");
        System.out.println("3: Go back");
        System.out.println("--------------------");
    }
}
