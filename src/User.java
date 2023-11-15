public abstract class User {
    protected String userName;
    protected String password;
    protected String phoneNum;
    protected String accType;
    public abstract void LoadProfile();
    
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
}