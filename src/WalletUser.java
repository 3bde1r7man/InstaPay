import java.util.Scanner;

public class WalletUser extends User {
    private WalletTransfer transfer;
    private WalletProvider wallet= InstaPay.walletAPI;
    public WalletUser(String userName, String password, String phoneNum) {
        this.userName = userName;
        this.password = password;
        this.accType = "Wallet";
        this.phoneNum = phoneNum;
    }
    public void setWalletTransfer(WalletTransfer wt) {
        this.transfer = wt;
    }

    public void walletTransfer() {
        this.transfer.transfer();
    }
    
    public String getPhoneNum() {
        return phoneNum;
    }

    public void LoadProfile() {
        while (true) {
            System.out.println("username: " + userName);
            System.out.println("balance: " + wallet.accountBalance(phoneNum));
            System.out.println("1. Bill");
            System.out.println("2. transfer to Wallet");
            System.out.println("3. transfer to Instapay");
            System.out.println("4. exit");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                System.out.println("choose bill:");
                System.out.println("1-Gas Bill");
                System.out.println("2-Electricity Bill");
                System.out.println("3-Water Bill");
                int Billchoice = sc.nextInt();

                switch ((Billchoice)) {
                    case 1:
                        GasBill gas=new GasBill("giza");
                        gas.gasBillOpitions("wallet",phoneNum);
                        break;
                    case 2:
                        ElectricityBill electricityBill=new ElectricityBill( "giza");
                        electricityBill.ElectricityBillOpitions("wallet",phoneNum);
                        break;
                    case 3:
                        WaterBill water=new WaterBill("giza");
                        water.waterBillOpitions("wallet",phoneNum);
                        break;
                    default:
                    System.err.println("invalid option!");
                        break;
                }
                case 2:
                {
                    System.out.println("Enter phone number: ");
                    String receivedPhoneNum = sc.next();
                    System.out.println("Enter amount: ");
                    double amount = sc.nextDouble();
                    transfer = new TransferToWallet(phoneNum, receivedPhoneNum, amount);
                    transfer.transfer();
                    break;
                }
                case 3:
                {
                    System.out.println("Enter username: ");
                    String receivedUserName = sc.next();
                    System.out.println("Enter amount: ");
                    double amount = sc.nextDouble();
                    transfer = new TransferToInstapay("Wallet", phoneNum, receivedUserName, amount);
                    transfer.transfer();
                    break;  
                }
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
            
    }
}