public class Jacket extends ClothingItem {

    private String season;
    private boolean hasHood;

    public Jacket(int itemId, String name, String size, double price, String brand, String season, boolean hasHood) {
        super(itemId, name, size, price, brand);
        this.season = season;
        this.hasHood = hasHood;
    }

    @Override
    public void displayInfo() {
        System.out.println("   JACKET: " + name + " (" + brand + ")");
        System.out.println("   Size: " + size + ", Price: " + price + " KZT");
        System.out.println("   Season: " + season + ", Has Hood: " + (hasHood ? "Yes" : "No"));
    }

    @Override
    public String getCategory() {
        return "Jacket";
    }

    @Override
    public void use() {
        System.out.println("Wearing jacket " + name + " for " + season + " season");
    }

    public boolean isWaterproof() {
        return season.equalsIgnoreCase("Winter") || season.equalsIgnoreCase("Rainy");
    }

    public void toggleHood() {
        if (hasHood) {
            System.out.println("Hood is now on " + name);
        } else {
            System.out.println("This jacket has no hood");
        }
    }

    public String getSeason() { return season; }
    public boolean getHasHood() { return hasHood; }

    public void setSeason(String season) { this.season = season; }
    public void setHasHood(boolean hasHood) { this.hasHood = hasHood; }

    @Override
    public String toString() {
        return super.toString() + " | Season: " + season + " | Has Hood: " + (hasHood ? "Yes" : "No");
    }
}
