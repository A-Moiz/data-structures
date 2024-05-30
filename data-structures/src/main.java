package src;

import java.io.*;
import java.util.Scanner;

public class main {

    // Scanner
    static Scanner input = new Scanner(System.in);

    // Array
    static ArrayManager arrayObject = new ArrayManager();

    // Array list
    static ArrayListManager arrayListObject = new ArrayListManager();

    // Queue
    static QueueManager queueObject = new QueueManager();

    // Menu Options
    static MenuOptions options = new MenuOptions();

    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        int num = -1;
        while (num < 0) {
            options.mainMenuOptions();
            try {
                int choice = Integer.valueOf(input.nextLine());
                switch (choice) {
                    case 1:
                        arrayMenu();
                        break;
                    case 2:
                        arrayListMenu();
                        break;
                    case 3:
                        queueMenu();
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

    private  static void queueMenu() {
        int num = -1;
        while (num < 0) {
            options.queueOptions();
            try {
                int choice = Integer.valueOf(input.nextLine());
                switch (choice) {
                    case 1:
                        queueObject.addToQueue();
                        break;
                    case 2:
                        queueObject.viewList();
                        break;
                    case 3:
                        queueObject.viewQueue();
                        break;
                    case 4:
                        queueObject.removeItem();
                        break;
                    case 5:
                        queueObject.removeFromQueue();
                        break;
                    case 6:
                        saveListMenu();
                        break;
                    case 7:
                        loadListMenu();
                        break;
                    case 8:
                        num = 0;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid option entered");
                num = -1;
            }
        }
    }

    private static void saveListMenu() {
        int num = -1;
        while (num < 0) {
            options.saveListOptions();
            try {
                int choice = Integer.valueOf(input.nextLine());
                switch (choice) {
                    case 1:
                        queueObject.saveListToCSVFile();
                        break;
                    case 2:
                        queueObject.saveListToTextFile();
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

    private static void loadListMenu() {
        int num = -1;
        while (num < 0) {
            options.loadListOptions();
            try {
                int choice = Integer.valueOf(input.nextLine());
                switch (choice) {
                    case 1:
                        queueObject.loadListFromCSVFile();
                        break;
                    case 2:
                        queueObject.loadListFromTextFile();
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

    private static void arrayListMenu() {
        int num = -1;
        while (num < 0) {
            options.arrayListOptions();
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

    private static void saveArrayListMenu() {
        int num = -1;
        while (num < 0) {
            options.saveArrayListOptions();
            //saveArrayListOptions();
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

    private static void loadArrayListMenu() {
        int num = -1;
        while (num < 0) {
            options.loadArrayListOptions();
            //loadArrayListOptions();
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

    private static void arrayMenu() {
        int num = -1;
        while (num < 0) {
            options.arrayOptions();
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
            options.saveArrayOptions();
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
            options.loadArrayOptions();
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
}
