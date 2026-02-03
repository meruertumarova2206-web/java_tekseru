package model;

public class Shirt extends ClothingItem {

    private boolean hasPrint;

    public Shirt(int id, String name, String size, double price, boolean hasPrint) {
        super(id, name, size, price);
        this.hasPrint = hasPrint;
    }

    @Override
    public String getType() {
        return "SHIRT";
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
