package model;

public class Shirt extends ClothingItem {

    private boolean hasPrint;

    public Shirt(int itemId, String name, String size, double price, boolean hasPrint) {
        super(itemId, name, size, price);
        this.hasPrint = hasPrint;
    }

    @Override
    public String getType() {
        return "Shirt";
    }

    @Override
    public void display() {
        System.out.println("Shirt: " + name +
                " | Print: " + (hasPrint ? "Yes" : "No"));
    }

    public boolean hasPrint() {
        return hasPrint;
    }
}
