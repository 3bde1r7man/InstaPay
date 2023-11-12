public class TransferToWallet implements WalletTransfer, BankTransfer {
    private String receivedPhoneNum;
    private double amount;
    TransferToWallet (String receivedPhoneNum, double amount) {
        this.receivedPhoneNum = receivedPhoneNum;
        this.amount = amount;
    }
    public void transfer() {
        //transfer to wallet
    }
}