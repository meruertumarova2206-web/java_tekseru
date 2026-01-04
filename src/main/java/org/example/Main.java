import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static ArrayList<ClothingItem> clothingItems = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        clothingItems.add(new ClothingItem(1, "Basic Pants", "M", 8000, "Generic"));
        clothingItems.add(new Jacket(2, "Winter Jacket", "L", 25000, "Nike", "Winter", true));
        clothingItems.add(new Shirt(3, "Formal Shirt", "M", 12000, "H&M", "Cotton", true));
        clothingItems.add(new Jacket(4, "Rain Coat", "S", 18000, "Adidas", "Rainy", false));
        clothingItems.add(new Shirt(5, "T-Shirt", "XL", 5000, "Zara", "Polyester", false));

        showMainMenu();
    }
    private static void showMainMenu() {
        while (true) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("    CLOTHING STORE MANAGEMENT SYSTEM");
            System.out.println("=".repeat(50));
            System.out.println("1. Add General Clothing Item");
            System.out.println("2. Add Jacket");
            System.out.println("3. Add Shirt");
            System.out.println("4. View All Items (Polymorphic List)");
            System.out.println("5. Use All Items (Polymorphism Demo)");
            System.out.println("6. View Jackets Only");
            System.out.println("7. View Shirts Only");
            System.out.println("8. Check Premium Items");
            System.out.println("9. Apply Discount to All");
            System.out.println("10. Exit");
            System.out.println("=".repeat(50));
            System.out.print("Enter your choice (1-10): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addGeneralItem();
                case 2 -> addJacket();
                case 3 -> addShirt();
                case 4 -> viewAllItems();
                case 5 -> demonstratePolymorphism();
                case 6 -> viewJacketsOnly();
                case 7 -> viewShirtsOnly();
                case 8 -> checkPremiumItems();
                case 9 -> applyDiscountToAll();
                case 10 -> {
                    System.out.println("Exiting program. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice! Please enter 1-10.");
            }
        }
    }
    private static void addGeneralItem() {
        System.out.println("\n--- ADD GENERAL CLOTHING ITEM ---");

        System.out.print("Enter Item ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Size (S/M/L/XL): ");
        String size = scanner.nextLine();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Brand: ");
        String brand = scanner.nextLine();
        ClothingItem item = new ClothingItem(id, name, size, price, brand);
        clothingItems.add(item);

        System.out.println("General clothing item added successfully!");
    }

    private static void addJacket() {
        System.out.println("\n--- ADD JACKET ---");

        System.out.print("Enter Item ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Size (S/M/L/XL): ");
        String size = scanner.nextLine();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter Season (Winter/Spring/Summer/Autumn/Rainy): ");
        String season = scanner.nextLine();

        System.out.print("Has Hood? (true/false): ");
        boolean hasHood = scanner.nextBoolean();
        scanner.nextLine();

        ClothingItem item = new Jacket(id, name, size, price, brand, season, hasHood);
        clothingItems.add(item);

        System.out.println("Jacket added successfully!");
    }

    private static void addShirt() {
        System.out.println("\n--- ADD SHIRT ---");

        System.out.print("Enter Item ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Size (S/M/L/XL): ");
        String size = scanner.nextLine();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter Material (Cotton/Polyester/Wool/Silk): ");
        String material = scanner.nextLine();

        System.out.print("Long Sleeve? (true/false): ");
        boolean longSleeve = scanner.nextBoolean();
        scanner.nextLine();
        ClothingItem item = new Shirt(id, name, size, price, brand, material, longSleeve);
        clothingItems.add(item);

        System.out.println("Shirt added successfully!");
    }
    private static void viewAllItems() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("               ALL CLOTHING ITEMS (POLYMORPHIC)");
        System.out.println("=".repeat(60));

        if (clothingItems.isEmpty()) {
            System.out.println("No items found.");
            return;
        }

        System.out.println("Total Items: " + clothingItems.size());
        System.out.println();

        for (int i = 0; i < clothingItems.size(); i++) {
            ClothingItem item = clothingItems.get(i);
            System.out.println((i + 1) + ". " + item);

            if (item instanceof Jacket jacket) {
                if (jacket.isWaterproof()) {
                    System.out.println("   Waterproof jacket");
                }
            } else if (item instanceof Shirt shirt) {
                if (shirt.isFormal()) {
                    System.out.println("   Formal shirt");
                }
            }
            System.out.println();
        }
    }

    private static void demonstratePolymorphism() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("        POLYMORPHISM DEMONSTRATION");
        System.out.println("=".repeat(50));
        System.out.println("Calling use() method on all items:");
        System.out.println();

        for (ClothingItem item : clothingItems) {
            item.use(); // ПОЛИМОРФИЗМ: один метод, разное поведение!
            // Для наглядности покажем тип объекта
            System.out.print("   (This is a " + item.getCategory() + ")");
            System.out.println("\n" + "-".repeat(40));
        }

        System.out.println("\n Notice: Same method name (use()), but different behavior!");
        System.out.println("   This is POLYMORPHISM in action!");
    }


    private static void viewJacketsOnly() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("               JACKETS ONLY");
        System.out.println("=".repeat(50));

        int jacketCount = 0;

        for (ClothingItem item : clothingItems) {
            if (item instanceof Jacket) { // INSTANCEOF проверка
                jacketCount++;
                Jacket jacket = (Jacket) item; // DOWNCASTING
                System.out.println(jacketCount + ". " + jacket.getName());
                System.out.println("   Season: " + jacket.getSeason());
                System.out.println("   Has Hood: " + (jacket.getHasHood() ? "Yes" : "No"));
                System.out.println("   Price: " + jacket.getPrice() + " KZT");

                // Вызов уникального метода Jacket
                if (jacket.isWaterproof()) {
                    System.out.println("   This jacket is waterproof!");
                }
                System.out.println();
            }
        }

        if (jacketCount == 0) {
            System.out.println("No jackets found.");
        } else {
            System.out.println("Total jackets: " + jacketCount);
        }
    }

    private static void viewShirtsOnly() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("               SHIRTS ONLY");
        System.out.println("=".repeat(50));

        int shirtCount = 0;

        for (ClothingItem item : clothingItems) {
            if (item instanceof Shirt) { // INSTANCEOF проверка
                shirtCount++;
                Shirt shirt = (Shirt) item; // DOWNCASTING
                System.out.println(shirtCount + ". " + shirt.getName());
                System.out.println("   Material: " + shirt.getMaterial());
                System.out.println("   Sleeve: " + (shirt.getLongSleeve() ? "Long" : "Short"));
                System.out.println("   Price: " + shirt.getPrice() + " KZT");

                // Вызов уникального метода Shirt
                if (shirt.isFormal()) {
                    System.out.println("   This is a formal shirt");
                }
                System.out.println();
            }
        }

        if (shirtCount == 0) {
            System.out.println("No shirts found.");
        } else {
            System.out.println("Total shirts: " + shirtCount);
        }
    }


    private static void checkPremiumItems() {
        System.out.println("\n--- PREMIUM ITEMS CHECK ---");

        int premiumCount = 0;
        for (ClothingItem item : clothingItems) {
            if (item.isPremium()) {
                premiumCount++;
                System.out.println(" " + item.getName() + " - " + item.getPrice() + " KZT (Premium)");
            }
        }

        System.out.println("\nTotal premium items: " + premiumCount + "/" + clothingItems.size());
    }

    private static void applyDiscountToAll() {
        System.out.print("\nEnter discount percentage (0-100): ");
        double discount = scanner.nextDouble();

        if (discount < 0 || discount > 100) {
            System.out.println("Invalid discount percentage!");
            return;
        }

        for (ClothingItem item : clothingItems) {
            double oldPrice = item.getPrice();
            item.applyDiscount(discount);
            double newPrice = item.getPrice();

            System.out.println(item.getName() + ": " + oldPrice + " → " + newPrice + " KZT (-" + discount + "%)");
        }

        System.out.println("\n Discount applied to all items!");
    }

}
