package menu;

import database.ClothingItemDAO;
import model.*;

import java.util.Scanner;

public class MenuManager implements Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final ClothingItemDAO dao = new ClothingItemDAO();

    @Override
    public void displayMenu() {
        System.out.println("""
                ===== CLOTHING STORE =====
                1. Add Shirt
                2. Add Jacket
                3. View All Items
                4. Update Price
                5. Delete Item
                6. Search by Name
                7. Search by Min Price
                8. Search by Price Range
                9. View Jackets Only
                10. View Shirts Only
                11. Polymorphism Demo
                0. Exit
                """);
    }

    @Override
    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Choose: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> addShirt();
                    case 2 -> addJacket();
                    case 3 -> viewAll();
                    case 4 -> updatePrice();
                    case 5 -> deleteItem();
                    case 6 -> searchByName();
                    case 7 -> searchByMinPrice();
                    case 8 -> searchByPriceRange();  // ЖАҢА
                    case 9 -> viewJackets();
                    case 10 -> viewShirts();
                    case 11 -> polymorphismDemo();
                    case 0 -> System.exit(0);
                    default -> System.out.println("Invalid!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter number!");
            }
        }
    }

    private void addShirt() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Size: ");
        String size = scanner.nextLine();
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Has print (true/false): ");
        boolean print = Boolean.parseBoolean(scanner.nextLine());
        dao.insertItem(new Shirt(0, name, size, price, print));
    }

    private void addJacket() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Size: ");
        String size = scanner.nextLine();
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Has hood (true/false): ");
        boolean hood = Boolean.parseBoolean(scanner.nextLine());
        dao.insertItem(new Jacket(0, name, size, price, hood));
    }

    private void viewAll() {
        dao.getAllItems().forEach(System.out::println);
    }

    private void updatePrice() {
        System.out.print("Item ID: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            ClothingItem item = dao.getById(id);
            if (item == null) {
                System.out.println("Not found!");
                return;
            }
            System.out.println("Current: " + item);
            System.out.print("New price: ");
            double price = Double.parseDouble(scanner.nextLine());
            dao.updatePrice(id, price);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number!");
        }
    }

    private void deleteItem() {
        System.out.print("Item ID: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            ClothingItem item = dao.getById(id);
            if (item == null) {
                System.out.println("Not found!");
                return;
            }
            System.out.println("Delete this? " + item);
            System.out.print("Confirm (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                dao.deleteItem(id);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number!");
        }
    }

    private void searchByName() {
        System.out.print("Search name: ");
        dao.searchByName(scanner.nextLine()).forEach(System.out::println);
    }

    private void searchByMinPrice() {
        System.out.print("Min price: ");
        try {
            dao.searchByMinPrice(Double.parseDouble(scanner.nextLine()))
                    .forEach(System.out::println);
        } catch (NumberFormatException e) {
            System.out.println("Invalid price!");
        }
    }


    private void searchByPriceRange() {
        System.out.print("Min price: ");
        try {
            double min = Double.parseDouble(scanner.nextLine());
            System.out.print("Max price: ");
            double max = Double.parseDouble(scanner.nextLine());

            if (min > max) {
                System.out.println("Min cannot be > Max!");
                return;
            }

            dao.searchByPriceRange(min, max).forEach(System.out::println);
        } catch (NumberFormatException e) {
            System.out.println("Invalid price!");
        }
    }

    private void viewJackets() {
        dao.getAllItems().stream()
                .filter(item -> item instanceof Jacket)
                .forEach(System.out::println);
    }

    private void viewShirts() {
        dao.getAllItems().stream()
                .filter(item -> item instanceof Shirt)
                .forEach(System.out::println);
    }

    private void polymorphismDemo() {
        dao.getAllItems().forEach(ClothingItem::display);
    }
}