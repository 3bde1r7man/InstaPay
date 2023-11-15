import java.util.HashMap;

public class WalletProvider {
    HashMap<String, Double> walletAcc = new HashMap<String, Double>();
    WalletProvider() {
        walletAcc.put("01111111111", 100000.0); // Instapay Wallet Account
        walletAcc.put("03333333333", 300000.0);
        walletAcc.put("04444444444", 400000.0);
        walletAcc.put("05555555555", 500000.0);
        walletAcc.put("01143022394", 600000.0);
        walletAcc.put("1", 800000.0);
        walletAcc.put("2", 700000.0);

    }
    public boolean validWalletACC(String phoneNum) {
        return true;
    }
    
    boolean transferMoney(String from, String to, double amount) {
        System.out.println("Transfering " + amount + " from " + from + " to " + to);
        System.out.println("Before transfer: " + walletAcc.get(from) + " " + walletAcc.get(to));
        walletAcc.put(from, walletAcc.get(from) - amount);
        walletAcc.put(to, walletAcc.get(to) + amount);
        System.out.println("After transfer: " + walletAcc.get(from) + " " + walletAcc.get(to));
        return true;
    }

    Double accountBalance(String walletAccNum){
        return walletAcc.get(walletAccNum);
    }

    boolean validateWalletAcc(String account){
        return true;
    }
}
