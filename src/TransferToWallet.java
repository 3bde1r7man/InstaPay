public class TransferToWallet implements WalletTransfer, BankTransfer {
    private String senderAccNum;
    private String receivedPhoneNum;
    private double amount;
    TransferToWallet (String senderAccNum, String receivedPhoneNum, double amount) {
        this.senderAccNum = senderAccNum;
        this.receivedPhoneNum = receivedPhoneNum;
        this.amount = amount;
    }
    public void transfer() {
        WalletProvider WTransfer = new WalletProvider();
        InstaPay insta=new InstaPay();
        if(WTransfer.validateWalletAcc(receivedPhoneNum)){
            if(amount<=insta.maxAmountDaily)
            {
                if(WTransfer.transferMoney(senderAccNum, receivedPhoneNum, amount))
                {
                    System.out.println("Transaction Successfully");
                }
                else{
                    System.err.println("Transaction Error");
                }
            }
            else{
                System.err.println("Maximum limit amount exceeded");
            }
        }
        else{
            System.err.println("Account not valid!");
        }
    }
}