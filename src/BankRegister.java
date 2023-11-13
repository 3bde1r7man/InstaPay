import java.util.Scanner;

public class BankRegister implements Register {
    public BankUser register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username: ");
        String userName = sc.next();
        System.out.println("Enter password: ");
        String password = sc.next();
        System.out.println("Enter bank account number: ");
        String bankAccNum = sc.next();
        // System.out.println("Enter balance: ");
        // double balance = sc.nextDouble();
        System.out.println("Enter phone number: ");
        String phoneNum = sc.next();
        BankAPI bankAPI = new BankAPI();
        if(!bankAPI.validBankACC(bankAccNum, phoneNum)){
            System.out.println("Invalid Bank Account");
            return null;
        }
        BankUser user = new BankUser(userName, password, bankAccNum, phoneNum);
        return user;
    }
}