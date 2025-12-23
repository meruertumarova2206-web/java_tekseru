public class Main {
    public static void main(String[] args) {
        System.out.println("Clothing Store Management System \n");

        ClothingItem item1 = new ClothingItem(1, "Jacket", "L", 12000, "Armani");
        ClothingItem item2 = new ClothingItem(2, "Jeans", "M", 8000, "Levis");
        ClothingItem item3 = new ClothingItem(); //d.c.

        Customer customer1 = new Customer(101, "Alice", "L", 50);
        Customer customer2 = new Customer(102, "Bob", "M", 120);
        Customer customer3 = new Customer(); //d.c.

        Order order1 = new Order(201, "Alice", 12000, "Pending");
        Order order2 = new Order(); //d.c.

        System.out.println("CLOTHING ITEMS");
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);

        System.out.println("\n CUSTOMERS");
        System.out.println(customer1);
        System.out.println(customer2);

        System.out.println("\n ORDERS");
        System.out.println(order1);
        System.out.println(order2);


        System.out.println("\n TESTING SETTERS");
        item3.setName("T-Shirt");
        item3.setPrice(5000);
        item3.setSize("S");
        item3.setBrand("H&M");
        System.out.println(item3);

        customer1.addPoints(60);
        System.out.println(customer1.getName() + " points: " + customer1.getPoints());
        System.out.println(customer1.getName() + " VIP? " + customer1.isVIP());

        order2.setCustomerName("Charlie");
        order2.addAmount(7000);
        order2.completeOrder();
        System.out.println(order2);


        System.out.println("\n TESTING ITEM METHODS");
        System.out.println(item1.getName() + " is premium? " + item1.isPremium());
        item2.applyDiscount(10);
        System.out.println(item2.getName() + " new price after 10% discount: " + item2.getPrice());

        System.out.println("\n Program Complete");
    }
}
