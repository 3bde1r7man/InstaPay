import java.util.Scanner;

public class BankUser extends User {
    private String bankAccNum;
    private BankTransfer transfer;
    public void setBankTransfer(BankTransfer bt) {
        this.transfer = bt;
    }
    public void bankTransfer() {
        this.transfer.transfer();
    }
    public void LoadProfile(){
        System.out.println("username: " + userName);
        System.out.println("balance: " + balance);
        System.out.println("1. pay bill");
        System.out.println("2. transfer to Bank");
        System.out.println("3. transfer to Instapay");
        System.out.println("4. transfer to Wallet");
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
                System.out.println("Enter bank account number: ");
                String receivedBankAccNum = sc.next();
                System.out.println("Enter amount: ");
                double amount1 = sc.nextDouble();
                transfer = new transferToBank(receivedBankAccNum, amount1);
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
                double amount2 = sc.nextDouble();
                transfer = new transferToInstapay(receivedPhoneNum1, receivedUserName, amount2);
                transfer.transfer();
                break;  
            }
            case 4:
            {
                System.out.println("Enter phone number: ");
                String receivedPhoneNum = sc.next();
                System.out.println("Enter amount: ");
                double amount3 = sc.nextDouble();
                transfer = new transferToWallet(receivedPhoneNum, amount3);
                transfer.transfer();
                break;
            }
            default:
                System.out.println("Invalid choice");
        }
        sc.close();
    }
}