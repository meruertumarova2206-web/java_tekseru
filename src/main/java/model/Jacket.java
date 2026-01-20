package model;

import util.Discountable;

public class Jacket extends ClothingItem implements Discountable {

    private boolean hasHood;

    public Jacket(int itemId, String name, String size, double price, boolean hasHood) {
        super(itemId, name, size, price);
        this.hasHood = hasHood;
    }

    @Override
    public String getType() {
        return "Jacket";
    }

    @Override
    public void display() {
        System.out.println("Jacket: " + name +
                " | Hood: " + (hasHood ? "Yes" : "No"));
    }

    @Override
    public double getDiscount() {
        return price * 0.10; // 10% discount
    }

    public boolean hasHood() {
        return hasHood;
    }
}
