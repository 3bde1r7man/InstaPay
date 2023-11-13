import java.util.Scanner;

public class BankRegister extends Register {
    public BankUser register() {
        Database db = new Database();
        Scanner sc = new Scanner(System.in);
        String userName, password, bankAccNum, phoneNum;
        while (true){
            System.out.println("Enter username: ");
            userName = sc.next();
            // @Abc1234
            System.out.println("Enter password: ");
            password = sc.next();
            System.out.println("Enter bank account number: ");
            bankAccNum = sc.next();
            System.out.println("Enter phone number: ");
            phoneNum = sc.next();
            BankAPI bankAPI = new BankAPI();
            
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
            if(!bankAPI.validBankACC(bankAccNum, phoneNum)){
                System.out.println("Invalid Bank Account");
                return null;
            }
            if (isStrongPassword(password) && isEGYPhoneNum(phoneNum) && db.isUniqueUserName(userName)) {
                break;
            }       
        }
        BankUser user = new BankUser(userName, password, bankAccNum, phoneNum);
        return user;
    }
}