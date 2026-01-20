package model;

public class Customer {

    private int customerId;
    private String name;
    private String phone;
    private int loyaltyPoints;

    public Customer(int customerId, String name, String phone, int loyaltyPoints) {
        setCustomerId(customerId);
        setName(name);
        setPhone(phone);
        setLoyaltyPoints(loyaltyPoints);
    }

    public void setCustomerId(int customerId) {
        if (customerId <= 0) {
            throw new IllegalArgumentException("Customer ID must be positive");
        }
        this.customerId = customerId;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        this.name = name;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone cannot be empty");
        }
        this.phone = phone;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints < 0) {
            throw new IllegalArgumentException("Points cannot be negative");
        }
        this.loyaltyPoints = loyaltyPoints;
    }

    public boolean isVIP() {
        return loyaltyPoints > 100;
    }

    @Override
    public String toString() {
        return name + " | Points: " + loyaltyPoints +
                (isVIP() ? " (VIP)" : "");
    }
}

