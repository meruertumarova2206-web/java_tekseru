public class ClothingItem {
    protected int itemId;
    protected String name;
    protected String size;
    protected double price;
    protected String brand;

    public ClothingItem(int itemId, String name, String size, double price, String brand) {
        this.itemId = itemId;
        this.name = name;
        this.size = size;
        this.price = price;
        this.brand = brand;
    }

    public ClothingItem() {
        this.itemId = 0;
        this.name = "Unknown Item";
        this.size = "M";
        this.price = 0.0;
        this.brand = "Generic";
    }

    public void displayInfo() {
        System.out.println(name + " (" + brand + ") - Size: " + size + ", Price: " + price + " KZT");
    }
    public String getCategory() {
        return "General Clothing";
    }
    public void use() {
        System.out.println("Wearing " + name);
    }


    // Get-вщзвращфет
    public int getItemId() { return itemId; }
    public String getName() { return name; }
    public String getSize() { return size; }
    public double getPrice() { return price; }
    public String getBrand() { return brand; }

    // Set- не возвр,менять
    public void setItemId(int itemId) { this.itemId = itemId; }
    public void setName(String name) { this.name = name; }
    public void setSize(String size) { this.size = size; }
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Price cannot be negative!");
        }
    }
    public void setBrand(String brand) { this.brand = brand; }

    // Addit method:
    public void applyDiscount(double percentage) {
        if (percentage >= 0 && percentage <= 100) {
            price = price * (1 - percentage / 100);
        }
    }

    public boolean isPremium() {
        return price > 10000;
    }

    @Override
    public String toString() {
        return "[" + getCategory() + "] " + name + " (ID: " + itemId +
                ", Size: " + size + ", Brand: " + brand + ", Price: " + price + " KZT)";
    }
}



