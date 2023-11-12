public abstract class User {
    protected String userName;
    protected String password;
    protected String phoneNum;
    protected double balance;
    public double payBill() {
        return 0;
    }
    public abstract void LoadProfile();
}