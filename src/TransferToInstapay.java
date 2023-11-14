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
        
        InstaPay insta = new InstaPay();
        User user = insta.database.getUser(receivedUserName);
        if (user == null) {
            System.err.println("User not found!");
            return;
        }
        if (user.accType == "wallet") {
            WalletProvider WTransfer = new WalletProvider();
            if (WTransfer.validateWalletAcc(user.phoneNum)) {
                if (amount <= insta.maxAmountDaily) {
                    if (WTransfer.transferMoney(receivedUserName, amount)) {
                        System.out.println("Transaction Successfully");
                    } else {
                        System.err.println("Transaction Error");
                    }
                } else {
                    System.err.println("Maximum limit amount exceeded");
                }
            } else {
                System.err.println("Account not valid!");
            }
        } else if (user.accType == "bank") {
            if (senderAccType == "wallet") {
                System.err.println("Can't transfer from wallet to bank");
            } else if (senderAccType == "bank") {
                BankProvider BTransfer = new BankProvider();
                if (BTransfer.validateBankAcc(user.phoneNum)) {
                    if (amount <= insta.maxAmountDaily) {

                        if (BTransfer.transferMoney(user.phoneNum, amount)) {
                            System.out.println("Transaction Successfully");
                        } else {
                            System.err.println("Transaction Error");
                        }
                    } else {
                        System.err.println("Maximum amount transaction exceeded");
                    }
                } else {
                    System.err.println("Account not valid!");
                }
            }
        }
    }
}
