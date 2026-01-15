package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 0:
                    isRunning = false;
                    break;
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz:");
                    addItems(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Çıkarılmasını istediğiniz elemanları giriniz:");
                    removeItems(scanner.nextLine());
                    break;
                default:
                    break;
            }
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String product = item.trim();
            if (!product.isEmpty() && !checkItemIsInList(product)) {
                groceryList.add(product);
            }
        }

        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String product = item.trim();
            groceryList.remove(product);
        }

        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);

        for (String item : groceryList) {
            System.out.println(item);
        }
    }
}