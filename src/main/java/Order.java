public class Order {
    private int orderId;
    private String customerName;
    private double total;
    private String status;

    // c.p.
    public Order(int orderId, String customerName, double total, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.total = total;
        this.status = status;
    }

    // d.c.
    public Order() {
        this.orderId = 0;
        this.customerName = "Unknown";
        this.total = 0.0;
        this.status = "Pending";
    }

    public int getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getTotal() { return total; }
    public String getStatus() { return status; }

    public void setOrderId(int orderId) { this.orderId = orderId; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setTotal(double total) { this.total = total; }
    public void setStatus(String status) { this.status = status; }

    public void completeOrder() { status = "Completed"; }
    public void cancelOrder() { status = "Cancelled"; }
    public void addAmount(double amount) { total += amount; }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", total=" + total +
                ", status='" + status + '\'' +
                '}';
    }
}
