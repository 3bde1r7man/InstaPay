import java.util.HashMap;

public class BankProvider {
    HashMap<String, Double> bankAcc = new HashMap<String, Double>();
    public BankProvider() {
        initDummy();
    }

    private void initDummy(){
        bankAcc.put("02222222222", 200000.0); // Instapay Bank Account
        bankAcc.put("03333333333", 300000.0); // elec bank acc
        bankAcc.put("04444444444", 400000.0); // gas bank acc
        bankAcc.put("05555555555", 500000.0); // water bank acc
        bankAcc.put("4", 600000.0);
        bankAcc.put("2", 700000.0);
        bankAcc.put("5", 900000.0);
    }
    
    public boolean validBankACC(String bankAccNum, String phoneNum) {
        return bankAcc.containsKey(bankAccNum);
    }

    boolean transferMoney(String from, String to, double amount) {
        if(!validBankACC(to, from)) {
            System.err.println("Invalid account number!");
            return false;
        }
        System.out.println("Transfering " + amount + " from " + from + " to " + to);
        System.out.println("Before transfer: " + bankAcc.get(from) + " " + bankAcc.get(to));
        bankAcc.put(from, bankAcc.get(from) - amount);
        bankAcc.put(to, bankAcc.get(to) + amount);
        System.out.println("After transfer: " + bankAcc.get(from) + " " + bankAcc.get(to));
        return true;
    }

    Double accountBalance(String BankAccNum){
        return bankAcc.get(BankAccNum);
    }

    boolean validateBankAcc(String account){
        return true;
    }
}
