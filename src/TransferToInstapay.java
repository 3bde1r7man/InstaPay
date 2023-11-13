public class TransferToInstapay implements WalletTransfer, BankTransfer {
    private String senderAccType;
    private String receivedUserName;
    private double amount;
    TransferToInstapay(String senderAccType, String receivedUserName, double amount) {
        this.senderAccType = senderAccType;
        this.receivedUserName = receivedUserName;
        this.amount = amount;
    }
    // check if the user exists in the database then check the received acctype, 
    // if the recived is bank then check if the sender is also bank else cant transfer.
    public void transfer() {
        
    }
}
