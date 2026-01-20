package menu;

import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    private ArrayList<ClothingItem> items = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public MenuManager() {
        items.add(new Shirt(1, "T-Shirt", "L", 7000, true));
        items.add(new Jacket(2, "Winter Jacket", "XL", 25000, true));
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== CLOTHING STORE SYSTEM ===");
        System.out.println("1. Add Shirt");
        System.out.println("2. Add Jacket");
        System.out.println("3. View All Items");
        System.out.println("4. Polymorphism Demo");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> addShirt();
                    case 2 -> addJacket();
                    case 3 -> viewAll();
                    case 4 -> demo();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addShirt() {
        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Size: ");
            String size = scanner.nextLine();

            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Has print (true/false): ");
            boolean print = Boolean.parseBoolean(scanner.nextLine());

            items.add(new Shirt(items.size() + 1, name, size, price, print));
            System.out.println("Shirt added!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addJacket() {
        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Size: ");
            String size = scanner.nextLine();

            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Has hood (true/false): ");
            boolean hood = Boolean.parseBoolean(scanner.nextLine());

            items.add(new Jacket(items.size() + 1, name, size, price, hood));
            System.out.println("Jacket added!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void viewAll() {
        for (ClothingItem item : items) {
            System.out.println(item);
        }
    }

    private void demo() {
        for (ClothingItem item : items) {
            item.display();
        }
    }
}
