import java.util.Scanner;

public class WalletRegister extends Register {
    public WalletUser register() {
        Database db = new Database();
        Scanner sc = new Scanner(System.in);
        String userName, password, phoneNum;
        double balance;
        while (true){
            System.out.println("Enter username: ");
            userName = sc.next();
            // @Abc1234
            System.out.println("Enter password: ");
            password = sc.next();
            System.out.println("Enter wallet balance: ");
            balance = sc.nextDouble();
            System.out.println("Enter phone number: ");
            phoneNum = sc.next();
            WalletAPI walletAPI = new WalletAPI();
            
            if (!isStrongPassword(password)) {
                System.out.println("Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character.");
                continue;
            }
            if (!isEGYPhoneNum(phoneNum)) {
                System.out.println("Phone number must be 11 digits and start with 01.");
                continue;
            }
            if (!db.isUniqueUserName(userName)) {
                System.out.println("Username already exists.");
                continue;
            }
            if(!walletAPI.validWalletACC(phoneNum)){
                System.out.println("Invalid Wallet Account");
                return null;
            }
            if (isStrongPassword(password) && isEGYPhoneNum(phoneNum) && db.isUniqueUserName(userName)) {
                break;
            }
        }
        WalletUser user = new WalletUser(userName, password, balance, phoneNum);
        return user;
    }
}