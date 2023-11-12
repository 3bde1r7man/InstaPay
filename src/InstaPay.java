import java.util.Scanner;

interface Database {
    public void saveUser(User user);
    public void saveBill(Bill bill);
    public User getUser(String userName);
    public Bill getBill(String userName);
}

abstract class User {
    protected String userName;
    protected String password;
    protected String phoneNum;
    protected double balance;
    public double payBill() {
        return 0;
    }
}



class WalletUser extends User {
    private WalletTransfer transfer;
    private Database database;
    public void setWalletTransfer(WalletTransfer wt) {
        this.transfer = wt;
    }
    public void walletTransfer() {
        this.transfer.transfer();
    }

    public void LoadProfile() {
        System.out.println("username: " + userName);
        System.out.println("balance: " + balance);
        System.out.println("1. pay bill");
        System.out.println("2. transfer to Wallet");
        System.out.println("3. transfer to Instapay");

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
                double amount1 = sc.nextDouble();
                transfer = new transferToWallet(receivedPhoneNum, amount1);
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
            default:
                System.out.println("Invalid choice");
        }
        sc.close();
    }
}

interface WalletTransfer {
    public void transfer();
}

interface BankTransfer {
    public void transfer();
}

class transferToBank implements BankTransfer {
    private String receivedBankAccNum;
    private double amount;
    transferToBank(String receivedBankAccNum, double amount) {
        this.receivedBankAccNum = receivedBankAccNum;
        this.amount = amount;
    }
    public void transfer() {
        //transfer to bank
    }
}

class transferToWallet implements WalletTransfer, BankTransfer {
    private String receivedPhoneNum;
    private double amount;
    transferToWallet (String receivedPhoneNum, double amount) {
        this.receivedPhoneNum = receivedPhoneNum;
        this.amount = amount;
    }
    public void transfer() {
        //transfer to wallet
    }
}

class transferToInstapay implements WalletTransfer, BankTransfer {
    private String receivedPhoneNum;
    private String receivedUserName;
    private double amount;
    transferToInstapay(String receivedPhoneNum, String receivedUserName, double amount) {
        this.receivedPhoneNum = receivedPhoneNum;
        this.receivedUserName = receivedUserName;
        this.amount = amount;
    }
    public void transfer() {
        //transfer to instapay
    }
}

abstract class Bill {
    protected double amount;
    protected String billType;
    protected String username;
    public void deductFromAccount(double amount) {
        //deduct from account
    }
    public Bill getBillContent(User u) {
        return null;
    }
}

class WaterBill extends Bill {
    private double usage;
    private String sector;
}

class ElectricityBill extends Bill {
    private double usage;
    private String sector;
}

class GasBill extends Bill {
    private double usage;
    private String sector;
}

class BankAPI {
    public boolean validBankACC(String bankAccNum, String phoneNum) {
        return true;
    }
}

class walletAPI {
    public boolean validWalletACC(String phoneNum) {
        return true;
    }
}

interface Register {
    public User register();
}

class BankRegister implements Register {
    public User register() {
        return null;
    }
}


class WalletRegister implements Register {
    public User register() {
        return null;
    }
}

class InstaPay {
    private Database database;
    private Register register;
    public void setRegister(Register r) {
        this.register = r;
    }
    public User Register() {
        return this.register.register();
    }
    public boolean login(String userName, String password) {
        return true;
    }
    public static void main(String[] args) {
        InstaPay instapay = new InstaPay();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        int choice = sc.nextInt();
        switch(choice) {
            case 1:
                System.out.println("1. Bank Register");
                System.out.println("2. Wallet Register");
                int choice1 = sc.nextInt();
            switch(choice1) {
                case 1:
                    instapay.setRegister(new BankRegister());
                    User user = instapay.Register();
                    instapay.database.saveUser(user);
                    break;
                case 2:
                    instapay.setRegister(new WalletRegister());
                    User user1 = instapay.Register();
                    instapay.database.saveUser(user1);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            break;
            case 2:
                System.out.println("Enter username: ");
                String userName = sc.next();
                System.out.println("Enter password: ");
                String password = sc.next();
                if(instapay.login(userName, password)) {
                    System.out.println("Login successful");
                } else {
                    System.out.println("Login failed");
                }
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }
        sc.close();
    }
}



class BankProvider {
    public boolean validateBankAccount(String bankAccNum, String phoneNum) {
        return true;
    }
}

class WalletProvider {
    public boolean validateWalletAccount(String phoneNum) {
        return true;
    }
}