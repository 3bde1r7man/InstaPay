public class WaterBill extends Bill {
    private double usage;
    private String sector;
    public WaterBill(double amount, String billType, String username, double usage, String sector) {
        this.amount = amount;
        this.billType = billType;
        this.username = username;
        this.usage = usage;
        this.sector = sector;
    }
}
