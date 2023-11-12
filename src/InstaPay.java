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
    public boolean login(String userName, String password) {
        return true;
    }
    public static void main(String[] args) {
        InstaPay instapay = new InstaPay();
        instapay.database = new Database();
        Scanner sc = new Scanner(System.in);
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
                        User user1 = instapay.Register();
                        if (user1 == null) {
                            System.out.println("Invalid Wallet Account");
                            break;
                        }
                        instapay.database.saveUser(user1);
                        user1.LoadProfile();
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
                if(instapay.login(userName, password)) {
                    System.out.println("Login successful");
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



// public class BankProvider {
//     public boolean validateBankAccount(String bankAccNum, String phoneNum) {
//         return true;
//     }
// }

// public class WalletProvider {
//     public boolean validateWalletAccount(String phoneNum) {
//         return true;
//     }
// }