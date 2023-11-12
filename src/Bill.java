public abstract class Bill {
    protected double amount;
    protected String billType;
    protected String username;
    public void deductFromAccount(double amount) {
        //deduct from account
    }
    public Bill getBillContent(User u) {
        return null;
    }
    public double getAmount() {
        return amount;
    }
}