public class ClothingItem {
    // Private fields
    private int itemId;
    private String name;
    private String size;
    private double price;
    private String brand;

    // конст параметр
    public ClothingItem(int itemId, String name, String size, double price, String brand) {
        this.itemId = itemId;
        this.name = name;
        this.size = size;
        this.price = price;
        this.brand = brand;
    }

    // дефалт канст-канст без параметр
    public ClothingItem() {
        this.itemId = 0;
        this.name = "Unknown Item";
        this.size = "M";
        this.price = 0.0;
        this.brand = "Generic";
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
    public void setPrice(double price) { this.price = price; }
    public void setBrand(String brand) { this.brand = brand; }

    // Addit method:
    public void applyDiscount(double percentage) {
        price = price * (1 - percentage / 100);
    }

    public boolean isPremium() {
        return price > 10000; // например, премиум если дороже 10 000
    }

    @Override
    public String toString() {
        return "ClothingItem{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }
}

