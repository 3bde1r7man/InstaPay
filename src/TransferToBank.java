public class TransferToBank implements BankTransfer {
    private String receivedBankAccNum;
    private double amount;
    TransferToBank(String receivedBankAccNum, double amount) {
        this.receivedBankAccNum = receivedBankAccNum;
        this.amount = amount;
    }
    public void transfer() {
        InstaPay insta=new InstaPay();
        BankProvider BTransfer=new BankProvider();
        if(BTransfer.validateBankAcc(receivedBankAccNum))
        {
            if(amount<= insta.maxAmountDaily)
            {
                
                if(BTransfer.transferMoney(receivedBankAccNum,amount))
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