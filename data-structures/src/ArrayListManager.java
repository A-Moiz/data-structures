package src;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class ArrayListManager {
    private static String arrayListCSVFile = "arrayList_content.csv";
    private static  String arrayListTextFile = "arrayList_content.txt";
    static ArrayList<String> arrayList = new ArrayList<>();

    public ArrayListManager() {
    }

    public java.util.ArrayList<String> getArrayList() {
        return arrayList;
    }

    public void setArrayList(java.util.ArrayList<String> ArrayList) {
        arrayList = ArrayList;
    }

    public boolean isValidWord(String input) {
        return Pattern.matches("[a-zA-Z]+", input);
    }

    public String getInputForArrayList() {
        String input = "";
        while (!isValidWord(input)) {
            System.out.print("Add to ArrayList: ");
            input = main.input.nextLine();
        }
        return input;
    }

    public void addToArrayList() {
        String input = getInputForArrayList();
        arrayList.add(input);
        System.out.println("Added '" + input + "' to the ArrayList.");
    }

    public void viewArrayList() {
        if (arrayList.isEmpty()) {
            System.out.println("ArrayList is empty.");
        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.println(i + ": " + arrayList.get(i));
            }
        }
    }

    public int getIndexInputForArrayList() {
        System.out.println("--------------------------------------------------");
        viewArrayList();
        int index = -1;
        boolean validIndex = false;
        while (!validIndex) {
            System.out.print("Select the index of the item you want to remove: ");
            try {
                index = main.input.nextInt();
                main.input.nextLine();
                if (index >= 0 && index < arrayList.size()) {
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

    public void deleteFromArrayList() {
        if (arrayList.isEmpty()) {
            System.out.println("ArrayList is empty.");
        } else {
            int index = getIndexInputForArrayList();
            System.out.println(arrayList.get(index) + " has been removed from the ArrayList.");
            arrayList.remove(index);
        }
    }

    public void saveArrayListToCSVFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arrayListCSVFile))) {
            for (String element : arrayList) {
                if (element != null) {
                    writer.write(element);
                    writer.newLine();
                }
            }
            System.out.println("ArrayList content saved to file: " + arrayListCSVFile);
        } catch (IOException e) {
            System.out.println("Error occurred while saving ArrayList to file: " + e.getMessage());
            throw e;
        }
    }

    public void saveArrayListToTextFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arrayListTextFile))) {
            for (String element : arrayList) {
                if (element != null) {
                    writer.write(element);
                    writer.newLine();
                }
            }
            System.out.println("ArrayList content saved to file: " + arrayListTextFile);
        } catch (IOException e) {
            System.out.println("Error occurred while saving array to file: " + e.getMessage());
            throw e;
        }
    }

    public void loadArrayListFromCSVFile() throws IOException {
        arrayList.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(arrayListCSVFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                arrayList.add(line);
            }
            System.out.println("ArrayList content loaded from file: " + arrayListCSVFile);
        } catch (IOException e) {
            System.out.println("Error occurred while loading ArrayList from file: " + e.getMessage());
            throw e;
        }
    }

    public void loadArrayListFromTextFile() throws IOException {
        arrayList.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(arrayListTextFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                arrayList.add(line);
            }
            System.out.println("ArrayList content loaded from file: " + arrayListTextFile);
        } catch (IOException e) {
            System.out.println("Error occurred while loading ArrayList from file: " + e.getMessage());
            throw e;
        }
    }
}
