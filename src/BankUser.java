import java.util.Scanner;


public class BankUser extends User {
    private String bankAccNum;
    private BankTransfer transfer;
    private BankProvider bank = InstaPay.bankAPI;

    public BankUser(String userName, String password, String bankAccNum, String phoneNum) {
        this.userName = userName;
        this.password = password;
        this.bankAccNum = bankAccNum;
        this.accType = "Bank";
        this.phoneNum = phoneNum;
    }
    
    public String getBankAccNum() {
        return bankAccNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setBankTransfer(BankTransfer bt) {
        this.transfer = bt;
    }
    public void bankTransfer() {
        this.transfer.transfer();
    }
    public void LoadProfile(){
        while (true) {
            System.out.println("username: " + userName);
            System.out.println("balance: " + bank.accountBalance(bankAccNum));
            System.out.println("1. Bill");
            System.out.println("2. transfer to Bank");
            System.out.println("3. transfer to Instapay");
            System.out.println("4. transfer to Wallet");
            System.out.println("5. exit");
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
                        gas.gasBillOpitions("bank", bankAccNum);
                        break;
                    case 2:
                        ElectricityBill electricityBill=new ElectricityBill( "giza");
                        electricityBill.ElectricityBillOpitions("bank",bankAccNum);
                        break;
                    case 3:
                        WaterBill water=new WaterBill("giza");
                        water.waterBillOpitions("bank",bankAccNum);
                        break;
                    default:
                        System.err.println("invalid option!");
                        break;
                }
                break;
            case 2:
            {
                System.out.println("Enter bank account number: ");
                String receivedBankAccNum = sc.next();
                System.out.println("Enter amount: ");
                double amount = sc.nextDouble();

                transfer = new TransferToBank(bankAccNum ,receivedBankAccNum, amount);
                transfer.transfer();
                break;
            }
            case 3:
            {

                System.out.println("Enter username: ");
                String receivedUserName = sc.next();
                System.out.println("Enter amount: ");
                double amount = sc.nextDouble();
                String[] AccNum = {phoneNum, bankAccNum};
                transfer = new TransferToInstapay("Bank", AccNum, receivedUserName, amount);
                transfer.transfer();
                break;  
            }
            case 4:
            {
                System.out.println("Enter phone number: ");
                String receivedPhoneNum = sc.next();
                System.out.println("Enter amount: ");
                double amount = sc.nextDouble();
                transfer = new TransferToWallet(phoneNum, receivedPhoneNum, amount);
                transfer.transfer();
                break;
            }
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                break;
            }
        }
    }
}