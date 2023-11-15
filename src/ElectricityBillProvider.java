import java.util.HashMap;

public class ElectricityBillProvider implements BillProvider{
    HashMap<String, Double> bills = new HashMap<String, Double>();
    HashMap<String, Double> payedBills = new HashMap<String, Double>();
    public static HashMap<String, Double> bankAcc = new HashMap<String, Double>();
    HashMap<String, Double> walletAcc = new HashMap<String, Double>();

    public ElectricityBillProvider(){

        bankAcc.put("02222222222", 200000.0); // Instapay Bank Account
        bankAcc.put("03333333333", 300000.0);
        bankAcc.put("04444444444", 400000.0);
        bankAcc.put("05555555555", 500000.0);
        bankAcc.put("4", 600000.0);
        bankAcc.put("2", 700000.0);

        walletAcc.put("01111111111", 100000.0); // Instapay Wallet Account
        walletAcc.put("03333333333", 300000.0);
        walletAcc.put("04444444444", 400000.0);
        walletAcc.put("05555555555", 500000.0);
        walletAcc.put("01143022394", 600000.0);
        walletAcc.put("1", 800000.0);
        walletAcc.put("2", 700000.0);

        bills.put("b1111", 200.0); 
        bills.put("b2222", 300.0);
        bills.put("b3333", 400.0);
        bills.put("b4444", 500.0);
    }
    
    public void billsHistory(){
        for(String bill:payedBills.keySet())
        {
            double value=bills.get(bill);
            System.out.println(bill+": "+value);
        }
    }

    public void unpaidBills(){

        for(String bill:bills.keySet())
        {
            double value=bills.get(bill);
            System.out.println(bill+": "+value);
        }
    }

    public boolean payBill(String accType,String from,String code)
    {
        if(accType=="bank")
        {
            bankAcc.put(from, bankAcc.get(from) -bills.get(code));
            payedBills.put(code,bills.get(code));
            bills.remove(code);
        }
        if(accType=="wallet")
        {
            walletAcc.put(from, walletAcc.get(from) -bills.get(code));
            payedBills.put(code,bills.get(code));
            bills.remove(code);
        }
        return true;
    }
}
