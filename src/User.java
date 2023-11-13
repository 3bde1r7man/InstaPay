public abstract class User {
    protected String userName;
    protected String password;
    protected String phoneNum;
    protected String accType;
    //protected double balance;

    // public void payBill(Bill bill) {
    //     if(bill == null) {
    //         System.out.println("Bill not found");
            
    //     }else{
    //         if(bill.getAmount() > balance) {
    //             System.out.println("Insufficient balance");
                
    //         }else{
    //             balance -= bill.getAmount();
    //             System.out.println("Bill paid successfully");
                
    //         }
    //     }
        
    // }
    public abstract void LoadProfile();
    
    public String getUserName() {
        return userName;
    }
}