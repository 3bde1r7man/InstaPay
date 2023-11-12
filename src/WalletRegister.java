import java.util.Scanner;

public class WalletRegister implements Register {
    public WalletUser register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username: ");
        String userName = sc.next();
        System.out.println("Enter password: ");
        String password = sc.next();
        System.out.println("Enter wallet balance: ");
        double balance = sc.nextDouble();
        System.out.println("Enter phone number: ");
        String phoneNum = sc.next();
        WalletAPI walletAPI = new WalletAPI();
        if(!walletAPI.validWalletACC(phoneNum)){
            System.out.println("Invalid Wallet Account");
            sc.close();
            return null;
        }
        WalletUser user = new WalletUser(userName, password, balance, phoneNum);
        sc.close();
        return user;
    }
}