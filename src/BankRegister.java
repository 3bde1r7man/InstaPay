import java.util.Scanner;

public class BankRegister extends Register {
    public BankUser register() {
        Scanner sc = new Scanner(System.in);
        String userName, password, bankAccNum, phoneNum;
        while (true){
            System.out.println("Enter username: ");
            userName = sc.next();
            if (!InstaPay.database.isUniqueUserName(userName)) {
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
            break;
        }
        while (true) {
            System.out.println("Enter bank account number: ");
            bankAccNum = sc.next();
            BankProvider bankAPI = InstaPay.bankAPI;
            if(!bankAPI.validBankACC(bankAccNum, phoneNum)){
                System.out.println("Invalid Bank Account");
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
        BankUser user = new BankUser(userName, password, bankAccNum, phoneNum);
        return user;
    }
}