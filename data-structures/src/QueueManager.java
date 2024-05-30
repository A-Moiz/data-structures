package src;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class QueueManager {

    private static int listLength = 10;
    static Queue<String> queue = new LinkedList<>();
    static ArrayList<String> list = new ArrayList<>();
    private static String listCSVFile = "list_content.csv";
    private static String listTextFile = "list_content.txt";

    public static int getListLength() {
        return listLength;
    }

    public static void setListLength(int listLength) {
        QueueManager.listLength = listLength;
    }

    public static Queue<String> getQueue() {
        return queue;
    }

    public static void setQueue(Queue<String> queue) {
        QueueManager.queue = queue;
    }

    public static ArrayList<String> getList() {
        return list;
    }

    public static void setList(ArrayList<String> waitingList) {
        QueueManager.list = list;
    }

    public boolean isValidWord(String input) {
        return Pattern.matches("[a-zA-Z]+", input);
    }

    public void addToQueue() {
        String input = getInputForList();
        if (list.size() < listLength) {
            list.add(input);
            System.out.println("Added '" + input + "' to the list.");
        } else {
            queue.add(input);
            System.out.println("List is full, '" + input + "' has been added to the queue.");
        }
    }

    public String getInputForList() {
        String input = "";
        while (!isValidWord(input)) {
            System.out.print("Add to List: ");
            input = main.input.nextLine();
        }
        return input;
    }

    public void viewQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            int index = 0;
            for (String item : queue) {
                System.out.println(index + ": " + item);
                index++;
            }
        }
    }

    public void viewList() {
        if (list.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            int index = 0;
            for (String item : list) {
                System.out.println(index + ": " + item);
                index++;
            }
        }
    }

    public int getIndex() {
        System.out.println("--------------------------------------------------");
        viewList();
        int index = -1;
        boolean validIndex = false;
        while (!validIndex) {
            System.out.print("Select the index of the item you want to remove: ");
            try {
                index = main.input.nextInt();
                main.input.nextLine();
                if (index >= 0 && index < list.size()) {
                    validIndex = true;
                } else {
                    System.out.println("Invalid index. Please enter a valid index.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid index.");
                main.input.next();
            }
        }
        return index;
    }

    public void removeItem() {
        if (list.isEmpty()) {
            System.out.println("List is already empty.");
        } else {
            int index = getIndex();
            System.out.println(list.get(index) + " has been removed from the list.");
            list.remove(index);
            if (!(queue.isEmpty())) {
                queueToList();
            }
        }
    }

    public void queueToList() {
        String element = "";
        for (String item : queue) {
            element = item;
            break;
        }
        queue.remove(element);
        list.add(element);
        System.out.println(element + " has been removed from the queue and added to the List.");
    }

    public int getIndexForQueue() {
        System.out.println("--------------------------------------------------");
        viewQueue();
        int index = -1;
        boolean validIndex = false;
        while (!validIndex) {
            System.out.print("Select the index of the item you want to remove: ");
            try {
                index = main.input.nextInt();
                main.input.nextLine();
                if (index >= 0 && index < queue.size()) {
                    validIndex = true;
                } else {
                    System.out.println("Invalid index. Please enter a valid index.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid index.");
                main.input.next();
            }
        }
        return index;
    }

    public void removeFromQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is already empty.");
        } else {
            int index = getIndexForQueue();
            String element = "";
            for (int i = 0; i < queue.size(); i++) {
                for (String item : queue) {
                    if (index == i) {
                        element = item;
                    }
                    break;
                }
                break;
            }
            queue.remove(element);
            System.out.println(element + " has been removed from the queue.");
        }
    }

    public void saveListToCSVFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(listCSVFile))) {
            for (String element : list) {
                if (element != null) {
                    writer.write(element);
                    writer.newLine();
                }
            }
            System.out.println("List saved to file: " + listCSVFile);
        } catch (IOException e) {
            System.out.println("Error occurred while saving list to file: " + e.getMessage());
            throw e;
        }
    }

    public void saveListToTextFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(listTextFile))) {
            for (String element : list) {
                if (element != null) {
                    writer.write(element);
                    writer.newLine();
                }
            }
            System.out.println("List saved to file: " + listTextFile);
        } catch (IOException e) {
            System.out.println("Error occurred while saving list to file: " + e.getMessage());
            throw e;
        }
    }

    public void loadListFromCSVFile() throws IOException {
        list.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(listCSVFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            System.out.println("List loaded from file: " + listCSVFile);
        } catch (IOException e) {
            System.out.println("Error occurred while loading list from file: " + e.getMessage());
            throw e;
        }
    }

    public void loadListFromTextFile() throws IOException {
        list.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(listTextFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            System.out.println("List loaded from file: " + listTextFile);
        } catch (IOException e) {
            System.out.println("Error occurred while loading list from file: " + e.getMessage());
            throw e;
        }
    }
}
