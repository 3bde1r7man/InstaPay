import java.util.Scanner;

public class WalletRegister extends Register {
    public WalletUser register() {
        Database db = new Database();
        Scanner sc = new Scanner(System.in);
        String userName, password, phoneNum;
        while (true){
            System.out.println("Enter username: ");
            userName = sc.next();
            if (!db.isUniqueUserName(userName)) {
                System.out.println("Username already exists.");
                continue;
            }
            break;
        }
        while (true) {
            // @Abc1234
            System.out.println("Enter password: ");
            password = sc.next();
            if (!isStrongPassword(password)) {
                System.out.println("Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character.");
                continue;
            }
            break;
        }
        while (true) {
            System.out.println("Enter phone number: ");
            phoneNum = sc.next();
            if (!isEGYPhoneNum(phoneNum)) {
                System.out.println("Phone number must be 11 digits and start with 01.");
                continue;
            }
            WalletProvider walletAPI = new WalletProvider();
            if(!walletAPI.validWalletACC(phoneNum)){
                System.out.println("Invalid Wallet Account");
                return null;
            }
            break;
        }
        OTPService otp = new OTPService(phoneNum);
        System.out.println("Enter the received code: ");
        String receivedCode = sc.next();
        if(!otp.verifyOTP(receivedCode, phoneNum)){
            System.out.println("Invalid code");
            return null;
        }
        WalletUser user = new WalletUser(userName, password, phoneNum);
        return user;
    }
}