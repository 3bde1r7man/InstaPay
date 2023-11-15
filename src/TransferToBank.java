public class TransferToBank implements BankTransfer {
    private String senderAccNum;
    private String receivedBankAccNum;
    private double amount;
    TransferToBank(String senderAccNum, String receivedBankAccNum, double amount) {
        this.senderAccNum = senderAccNum;
        this.receivedBankAccNum = receivedBankAccNum;
        this.amount = amount;
    }
    public void transfer() {
        InstaPay insta=new InstaPay();
        BankProvider BTransfer= InstaPay.bankAPI;
        if(BTransfer.validateBankAcc(receivedBankAccNum))
        {
            if(amount<= insta.maxAmountDaily)
            {
                
                if(BTransfer.transferMoney(senderAccNum ,receivedBankAccNum,amount))
                {
                    System.out.println("Transaction Successfully");
                }
                else{
                    System.err.println("Transaction Error");
                }
            }
            else{
                System.err.println("Maximum amount transaction exceeded");  
            }
        }
        else{
            System.err.println("Account not valid!");
        }
        
    }
}