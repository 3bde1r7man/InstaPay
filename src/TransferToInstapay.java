public class TransferToInstapay implements WalletTransfer, BankTransfer {
    private String receivedUserName;
    private double amount;
    TransferToInstapay(String receivedUserName, double amount) {
        this.receivedUserName = receivedUserName;
        this.amount = amount;
    }
    public void transfer() {
        //transfer to instapay
    }
}
