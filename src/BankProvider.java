import java.util.HashMap;

public class BankProvider {
    HashMap<String, Double> bankAcc = new HashMap<String, Double>();
    public BankProvider() {
        bankAcc.put("02222222222", 200000.0); // Instapay Bank Account
        bankAcc.put("03333333333", 300000.0);
        bankAcc.put("04444444444", 400000.0);
        bankAcc.put("05555555555", 500000.0);
    }
    public boolean validBankACC(String bankAccNum, String phoneNum) {
        return true;
    }

    boolean transferMoney(String from, String to, double amount) {
        bankAcc.put(from, bankAcc.get(from) - amount);
        bankAcc.put(to, bankAcc.get(to) + amount);
        return true;
    }

    double accountBalance(String BankAccNum){
        return bankAcc.get(BankAccNum);
    }

    boolean validateBankAcc(String account){
        return true;
    }
}
