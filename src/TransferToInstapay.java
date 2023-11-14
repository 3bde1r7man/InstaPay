public class TransferToInstapay implements WalletTransfer, BankTransfer {
    private String senderAccType;
    private String senderAccNum;
    private String receivedUserName;
    private double amount;

    TransferToInstapay(String senderAccType, String senderAccNum, String receivedUserName, double amount) {
        this.senderAccType = senderAccType;
        this.senderAccNum = senderAccNum;
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
        if (user.accType == "Wallet") {
            WalletProvider WTransfer = new WalletProvider();
            if (WTransfer.validateWalletAcc(user.phoneNum)) {
                if (amount <= insta.maxAmountDaily) {
                    if (WTransfer.transferMoney(senderAccNum, receivedUserName, amount)) {
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
        } else if (user.accType == "Bank") {
            if (senderAccType == "Wallet") {
                WalletProvider WTransfer = new WalletProvider();
                if (amount <= insta.maxAmountDaily){
                    if (WTransfer.transferMoney(insta.WALLET, receivedUserName, amount)) {
                        BankProvider BTransfer = new BankProvider();
                        if (BTransfer.transferMoney(insta.BANK, receivedUserName, amount)) {
                            System.out.println("Transaction Successfully");
                        } else {
                            System.err.println("Transaction Error");
                        }
                        
                    } else {
                        System.err.println("Transaction Error");
                    }
                }
                else {
                    System.err.println("Maximum amount transaction exceeded");
                }
            } else if (senderAccType == "bank") {
                BankProvider BTransfer = new BankProvider();
                if (BTransfer.validateBankAcc(user.phoneNum)) {
                    if (amount <= insta.maxAmountDaily) {

                        if (BTransfer.transferMoney(senderAccNum, user.phoneNum, amount)) {
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
