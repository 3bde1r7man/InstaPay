import java.util.Scanner;

public class InstaPay {
    public Database database;
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
        InstaPay instapay = new InstaPay();
        instapay.database = new Database();
        Scanner sc = new Scanner(System.in);
        // User u = new BankUser("1","2","1", 2000.0, "1");
        // instapay.database.saveUser(u);
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
                            instapay.database.saveUser(user);
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
                            instapay.database.saveUser(user);
                            user.LoadProfile();
                            break;
                        }
                        default:
                            System.out.println("Invalid choice");
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
            }
            sc.close();
        }
    }
        
}

