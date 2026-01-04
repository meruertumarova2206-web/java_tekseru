public class Shirt extends ClothingItem {
    private String material;
    private boolean longSleeve;

    public Shirt(int itemId, String name, String size, double price, String brand, String material, boolean longSleeve) {
        super(itemId, name, size, price, brand);
        this.material = material;
        this.longSleeve = longSleeve;
    }


    @Override
    public void displayInfo() {
        System.out.println("   SHIRT: " + name + " (" + brand + ")");
        System.out.println("   Size: " + size + ", Price: " + price + " KZT");
        System.out.println("   Material: " + material + ", Sleeve: " + (longSleeve ? "Long" : "Short"));
    }

    @Override
    public String getCategory() {
        return "Shirt";
    }

    @Override
    public void use() {
        System.out.println("Wearing shirt " + name + " made of " + material);
    }


    public boolean isFormal() {
        return material.equalsIgnoreCase("Cotton") && longSleeve;
    }

    public void rollUpSleeves() {
        if (longSleeve) {
            System.out.println("Rolling up sleeves of " + name);
        } else {
            System.out.println("This is a short sleeve shirt");
        }
    }

    public String getMaterial() { return material; }
    public boolean getLongSleeve() { return longSleeve; }

    public void setMaterial(String material) { this.material = material; }
    public void setLongSleeve(boolean longSleeve) { this.longSleeve = longSleeve; }

    @Override
    public String toString() {
        return super.toString() + " | Material: " + material + " | Sleeve: " + (longSleeve ? "Long" : "Short");
    }
}