import java.util.HashMap;

public class WalletProvider {
    HashMap<String, Double> walletAcc = new HashMap<String, Double>();
    WalletProvider() {
        walletAcc.put("01111111111", 100000.0); // Instapay Wallet Account
        walletAcc.put("03333333333", 300000.0);
        walletAcc.put("04444444444", 400000.0);
        walletAcc.put("05555555555", 500000.0);
    }
    public boolean validWalletACC(String phoneNum) {
        return true;
    }
    
    boolean transferMoney(String from, String to, double amount) {
        walletAcc.put(from, walletAcc.get(from) - amount);
        walletAcc.put(to, walletAcc.get(to) + amount);
        return true;
    }

    double accountBalance(String walletAccNum){
        return walletAcc.get(walletAccNum);
    }

    boolean validateWalletAcc(String account){
        return true;
    }
    public static void main(String[] args) {
        WalletProvider wallet = new WalletProvider();
        System.out.println(wallet.accountBalance("01111111111"));
        System.out.println(wallet.accountBalance("03333333333"));
        wallet.transferMoney("01111111111", "03333333333", 1000);
        System.out.println(wallet.accountBalance("01111111111"));
        System.out.println(wallet.accountBalance("03333333333"));
    }
}
