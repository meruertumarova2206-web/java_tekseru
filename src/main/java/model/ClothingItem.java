package model;

public abstract class ClothingItem {

    protected int itemId;
    protected String name;
    protected String size;
    protected double price;

    public ClothingItem(int itemId, String name, String size, double price) {
        setItemId(itemId);
        setName(name);
        setSize(size);
        setPrice(price);
    }

    public abstract void display();
    public abstract String getType();

    // Геттеры для доступа к полям
    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        if (itemId < 0)
            throw new IllegalArgumentException("ID cannot be negative");
        this.itemId = itemId;
    }


    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name is empty");
        this.name = name;
    }

    public void setSize(String size) {
        if (size == null || size.isBlank())
            throw new IllegalArgumentException("Size is empty");
        this.size = size;
    }

    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("Price < 0");
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" + getType() + "] ID: " + itemId +
                " | " + name +
                " | Size: " + size +
                " | Price: " + price;
    }
}
