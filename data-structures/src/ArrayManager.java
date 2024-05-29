package src;

import java.io.*;
import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class ArrayManager {
    private static int arrayLength = 10;
    private static String[] array = new String[arrayLength];
    private static String arrayCSVFile = "array_content.csv";
    private static String arrayTextFile = "array_content.txt";

    public ArrayManager() {
    }

    public int getArrayLength() {
        return arrayLength;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        ArrayManager.array = array;
    }

    public String getArrayCSVFile() {
        return arrayCSVFile;
    }

    public String getArrayTextFile() {
        return arrayTextFile;
    }

    public void addToArray() {
        String input = getInputForArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = input;
                System.out.println("Added '" + input + "' to the array.");
                break;
            }
        }
    }

    public String getInputForArray() {
        String input = "";
        while (!isValidWord(input)) {
            System.out.print("Add to Array: ");
            input = main.input.nextLine();
        }
        return input;
    }

    public boolean isValidWord(String input) {
        return Pattern.matches("[a-zA-Z]+", input);
    }

    public void viewArray() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                System.out.println(i + ": " + "Empty");
            } else {
                System.out.println(i + ": " + array[i]);
            }
        }
    }

    public void checkArray() {
        if (array[array.length - 1] != null) {
            System.out.println("Array is full right now, remove an item before adding something new.");
        } else {
            addToArray();
        }
    }

    public int getIndexInput() {
        System.out.println("--------------------------------------------------");
        viewArray();
        int index = -1;
        boolean validIndex = false;
        while (!validIndex) {
            System.out.print("Select the index of the item you want to remove: ");
            try {
                index = main.input.nextInt();
                main.input.nextLine();
                if (index >= 0 && index < array.length) {
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

    public void deleteFromArray() {
        int index = getIndexInput();
        if (array[index] != null) {
            System.out.println(array[index] + " has been removed from the Array.");
            array[index] = null;
        } else {
            System.out.println("The index selected is already null.");
        }
    }

    public void saveArrayToCSVFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arrayCSVFile))) {
            for (String element : array) {
                if (element != null) {
                    writer.write(element);
                    writer.newLine();
                }
            }
            System.out.println("Array content saved to file: " + arrayCSVFile);
        } catch (IOException e) {
            System.out.println("Error occurred while saving array to file: " + e.getMessage());
            throw e;
        }
    }

    public void saveArrayToTextFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arrayTextFile))) {
            for (String element : array) {
                if (element != null) {
                    writer.write(element);
                    writer.newLine();
                }
            }
            System.out.println("Array content saved to file: " + arrayTextFile);
        } catch (IOException e) {
            System.out.println("Error occurred while saving array to file: " + e.getMessage());
            throw e;
        }
    }

    public void loadArrayFromCSVFile() throws IOException {
        clearArray();
        try (BufferedReader reader = new BufferedReader(new FileReader(arrayCSVFile))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                array[index++] = line;
            }
            System.out.println("Array content loaded from file: " + arrayCSVFile);
        } catch (IOException e) {
            System.out.println("Error occurred while loading array from file: " + e.getMessage());
            throw e;
        }
    }

    public void loadArrayFromTextFile() throws IOException {
        clearArray();
        try (BufferedReader reader = new BufferedReader(new FileReader(arrayTextFile))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                array[index++] = line;
            }
            System.out.println("Array content loaded from file: " + arrayTextFile);
        } catch (IOException e) {
            System.out.println("Error occurred while loading array from file: " + e.getMessage());
            throw e;
        }
    }

    public void clearArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }
}
