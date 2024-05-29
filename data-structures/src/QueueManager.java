package src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class QueueManager {

    private static int queueLength = 10;
    static Queue<String> queue = new LinkedList<>();
    static ArrayList<String> waitingList = new ArrayList<>();

    public static int getQueueLength() {
        return queueLength;
    }

    public static void setQueueLength(int queueLength) {
        QueueManager.queueLength = queueLength;
    }

    public static Queue<String> getQueue() {
        return queue;
    }

    public static void setQueue(Queue<String> queue) {
        QueueManager.queue = queue;
    }

    public static ArrayList<String> getWaitingList() {
        return waitingList;
    }

    public static void setWaitingList(ArrayList<String> waitingList) {
        QueueManager.waitingList = waitingList;
    }

    public boolean isValidWord(String input) {
        return Pattern.matches("[a-zA-Z]+", input);
    }

    public void addToQueue() {
        String input = getInputForQueue();
        if (queue.size() < queueLength) {
            queue.add(input);
            System.out.println("Added '" + input + "' to the queue.");
        } else {
            waitingList.add(input);
            System.out.println("Queue is full, '" + input + "' has been added to the waiting list.");
        }
    }

    public String getInputForQueue() {
        String input = "";
        while (!isValidWord(input)) {
            System.out.print("Add to Queue: ");
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

    public void viewWaitingList() {
        if (waitingList.isEmpty()) {
            System.out.println("Waiting list is empty.");
        } else {
            int index = 0;
            for (String item : waitingList) {
                System.out.println(index + ": " + item);
                index++;
            }
        }
    }

    public int getIndexInputForQueue() {
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
            int index = getIndexInputForQueue();
            int targetIndex = 0;
            String element = "";
            for (String item : queue) {
                if (targetIndex == index) {
                    element = item;
                    break;
                }
                targetIndex++;
            }
            System.out.println(element + " has been removed from the Queue.");
            queue.remove(element);
            if (!(waitingList.isEmpty())) {
                waitingListToQueue();
            }
        }
    }

    public void waitingListToQueue() {
        String element = "";
        element = waitingList.get(0);
        waitingList.remove(0);
        queue.add(element);
        System.out.println(element + " has been removed from the waiting list and added to the Queue.");
    }
}
