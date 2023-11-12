public class TransferToBank implements BankTransfer {
    private String receivedBankAccNum;
    private double amount;
    TransferToBank(String receivedBankAccNum, double amount) {
        this.receivedBankAccNum = receivedBankAccNum;
        this.amount = amount;
    }
    public void transfer() {
        //transfer to bank
    }
}