import java.util.Scanner;

public class InstaPay {
    // dummy data
    public static Database database;
    public static BankProvider bankAPI;
    public static WalletProvider walletAPI;
    public static ElectricityBillProvider electricityProvider;
    public static GasBillProvider gasProvider;
    public static WaterBillProvider waterProvider;
    // ---------------------------------
    public final String WALLET = "01111111111", BANK = "02222222222";
    public double maxAmountDaily=120000;
    private Register register;
    public void setRegister(Register r) {
        this.register = r;
    }
    public User Register() {
        return this.register.register();
    }
    public User login(String userName, String password) {
        return database.getUser(userName);
    }
    public static void main(String[] args) {
        // dummy data
        InstaPay instapay = new InstaPay();
        InstaPay.database = new Database();
        InstaPay.bankAPI = new BankProvider();
        InstaPay.walletAPI = new WalletProvider();
        InstaPay.electricityProvider = new ElectricityBillProvider();
        InstaPay.gasProvider = new GasBillProvider();
        InstaPay.waterProvider = new WaterBillProvider();
        // ---------------------------------
        Scanner sc = new Scanner(System.in);

        User u = new BankUser("1","1","2","1");
        InstaPay.database.saveUser(u);
        u = new WalletUser("2","2","2");
        InstaPay.database.saveUser(u);
        u = new BankUser("3","3","4", "4");
        InstaPay.database.saveUser(u);
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                {
                    System.out.println("1. Bank Register");
                    System.out.println("2. Wallet Register");
                    int choice1 = sc.nextInt();
                    switch(choice1) {
                        case 1:
                        {
                            instapay.setRegister(new BankRegister());
                            User user = instapay.Register();
                            if (user == null) {
                                System.out.println("Invalid Bank Account");
                                break;
                            }
                            InstaPay.database.saveUser(user);
                            user.LoadProfile();
                            break;
                        }
                        case 2:
                        {
                            instapay.setRegister(new WalletRegister());
                            User user = instapay.Register();
                            if (user == null) {
                                System.out.println("Invalid Wallet Account");
                                break;
                            }
                            InstaPay.database.saveUser(user);
                            user.LoadProfile();
                            break;
                        }
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                    break;
                }
                case 2:
                {
                    System.out.println("Enter username: ");
                    String userName = sc.next();
                    System.out.println("Enter password: ");
                    String password = sc.next();
                    User user = instapay.login(userName, password);
                    if(user != null) {
                        System.out.println("Login successful");
                        user.LoadProfile();
                    } else {
                        System.out.println("Login failed");
                    }
                    break;
                }
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
        
}

