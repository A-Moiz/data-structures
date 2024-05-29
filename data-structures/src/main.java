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
                        queueObject.viewQueue();
                        break;
                    case 3:
                        queueObject.viewWaitingList();
                        break;
                    case 4:
                        queueObject.removeFromQueue();
                        break;
                    case 5:
                        queueObject.removeFromWaitingList();
                        break;
                    case 6:
                        saveQueueMenu();
                        break;
                    case 7:
                        loadQueueMenu();
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

    private static void saveQueueMenu() {
        int num = -1;
        while (num < 0) {
            options.saveQueueOptions();
            try {
                int choice = Integer.valueOf(input.nextLine());
                switch (choice) {
                    case 1:
                        queueObject.saveQueueToCSVFile();
                        break;
                    case 2:
                        queueObject.saveQueueToTextFile();
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

    private static void loadQueueMenu() {
        int num = -1;
        while (num < 0) {
            options.loadQueueOptions();
            try {
                int choice = Integer.valueOf(input.nextLine());
                switch (choice) {
                    case 1:
                        queueObject.loadQueueFromCSVFile();
                        break;
                    case 2:
                        queueObject.loadQueueFromTextFile();
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
