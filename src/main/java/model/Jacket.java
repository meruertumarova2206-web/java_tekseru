package model;

import util.Discountable;

public class Jacket extends ClothingItem implements Discountable {

    private boolean hasHood;

    public Jacket(int id, String name, String size, double price, boolean hasHood) {
        super(id, name, size, price);
        this.hasHood = hasHood;
    }

    @Override
    public String getType() {
        return "JACKET";
    }

    @Override
    public void display() {
        System.out.println("Jacket: " + name +
                " | Hood: " + (hasHood ? "Yes" : "No"));
    }

    @Override
    public double getDiscount() {
        return price * 0.1;
    }

    public boolean hasHood() {
        return hasHood;
    }
}
