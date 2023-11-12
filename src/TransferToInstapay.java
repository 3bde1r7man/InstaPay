public class TransferToInstapay implements WalletTransfer, BankTransfer {
    private String receivedPhoneNum;
    private String receivedUserName;
    private double amount;
    TransferToInstapay(String receivedPhoneNum, String receivedUserName, double amount) {
        this.receivedPhoneNum = receivedPhoneNum;
        this.receivedUserName = receivedUserName;
        this.amount = amount;
    }
    public void transfer() {
        //transfer to instapay
    }
}
