public class TransferToInstapay implements WalletTransfer, BankTransfer {
    private String senderAccType;
    private String []senderAccNum;
    private String receivedUserName;
    private double amount;

    TransferToInstapay(String senderAccType, String []senderAccNum, String receivedUserName, double amount) {
        this.senderAccType = senderAccType;
        this.senderAccNum = senderAccNum;
        this.receivedUserName = receivedUserName;
        this.amount = amount;
    }
    public void transfer() {
        
        InstaPay insta = new InstaPay();
        User user = InstaPay.database.getUser(receivedUserName);
        if (user == null) {
            System.err.println("User not found!");
            return;
        }
        if (user.accType == "Wallet") {
            WalletProvider WTransfer = InstaPay.walletAPI;
            if (WTransfer.validateWalletAcc(user.phoneNum)) {
                if (amount <= insta.maxAmountDaily) {
                    if (WTransfer.transferMoney(senderAccNum[0], user.phoneNum, amount)) { // sender phone num
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
                WalletProvider WTransfer = InstaPay.walletAPI;
                if (amount <= insta.maxAmountDaily){
                    if (WTransfer.transferMoney(senderAccNum[0], insta.WALLET, amount)) {
                        BankProvider BTransfer = InstaPay.bankAPI;
                        BankUser bankUser = (BankUser) user;
                        if (BTransfer.transferMoney(insta.BANK, bankUser.getBankAccNum(), amount)) {
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
            } else if (senderAccType == "Bank") {
                BankProvider BTransfer = InstaPay.bankAPI;
                if (BTransfer.validateBankAcc(user.phoneNum)) {
                    if (amount <= insta.maxAmountDaily) {
                        BankUser bankUser = (BankUser) user;
                        if (BTransfer.transferMoney(senderAccNum[1], bankUser.getBankAccNum(), amount)) {
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
