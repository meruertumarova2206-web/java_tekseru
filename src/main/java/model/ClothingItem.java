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

    // ABSTRACT METHODS (REQUIRED)
    public abstract void display();
    public abstract String getType();

    // SETTERS WITH EXCEPTIONS
    public void setItemId(int itemId) {
        if (itemId <= 0) {
            throw new IllegalArgumentException("Item ID must be positive");
        }
        this.itemId = itemId;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setSize(String size) {
        if (size == null || size.trim().isEmpty()) {
            throw new IllegalArgumentException("Size cannot be empty");
        }
        this.size = size;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" + getType() + "] " + name +
                " | Size: " + size +
                " | Price: " + price + " KZT";
    }
}

