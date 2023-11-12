import java.util.Scanner;

public class WalletUser extends User {
    private WalletTransfer transfer;
    public WalletUser(String userName, String password, double balance, String phoneNum) {
        this.userName = userName;
        this.password = password;
        this.balance = balance;
        this.phoneNum = phoneNum;
    }
    public void setWalletTransfer(WalletTransfer wt) {
        this.transfer = wt;
    }
    public void walletTransfer() {
        this.transfer.transfer();
    }

    public void LoadProfile() {
        System.out.println("username: " + userName);
        // System.out.println("balance: " + balance);
        System.out.println("1. pay bill");
        System.out.println("2. transfer to Wallet");
        System.out.println("3. transfer to Instapay");
        System.out.println("4. exit");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice) {
            case 1:
                // System.out.println("Enter bill type: ");
                // String billType = sc.next();
                // Bill bill = database.getBill(userName);
                // if(bill == null) {
                //     System.out.println("Bill not found");
                //     break;
                // }
                
                
                
                // break;
            case 2:
            {
                System.out.println("Enter phone number: ");
                String receivedPhoneNum = sc.next();
                System.out.println("Enter amount: ");
                double amount = sc.nextDouble();
                if (amount > balance) {
                    System.out.println("Insufficient balance");
                    break;
                }
                transfer = new TransferToWallet(receivedPhoneNum, amount);
                transfer.transfer();
                break;
            }
            case 3:
            {
                System.out.println("Enter phone number: ");
                String receivedPhoneNum1 = sc.next();
                System.out.println("Enter username: ");
                String receivedUserName = sc.next();
                System.out.println("Enter amount: ");
                double amount = sc.nextDouble();
                if (amount > balance) {
                    System.out.println("Insufficient balance");
                    break;
                }
                transfer = new TransferToInstapay(receivedPhoneNum1, receivedUserName, amount);
                transfer.transfer();
                break;  
            }
            case 4:
                System.exit(0);
            default:
                System.out.println("Invalid choice");
        }
        sc.close();
    }
}