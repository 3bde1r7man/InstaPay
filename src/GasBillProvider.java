import java.util.HashMap;

public class GasBillProvider implements BillProvider {
    final String GAS_BANK_ACC_NUM = "04444444444";
    final String GAS_WALLET_ACC_NUM = "04444444444";
    HashMap<String, Double> bills = new HashMap<String, Double>();
    HashMap<String, Double> payedBills = new HashMap<String, Double>();

    public GasBillProvider(){

        bills.put("b1111", 200.0); 
        bills.put("b2222", 300.0);
        bills.put("b3333", 400.0);
        bills.put("b4444", 500.0);
    }
    boolean validBillCode(String code){
        return bills.containsKey(code);
    }
    public void billsHistory(){
        for(String bill:payedBills.keySet())
        {
            Double value = payedBills.get(bill);
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
        if(!validBillCode(code))
        {
            System.err.println("Invalid bill code!");
            return false;
        }
        
        if(accType=="bank")
        {
            BankProvider bank=InstaPay.bankAPI;
            if(bank.transferMoney(from, GAS_BANK_ACC_NUM, bills.get(code)))
            {
                payedBills.put(code,bills.get(code));
                bills.remove(code);
                return true;
            }
            else
            {
                return false;
            }
        }
        if(accType=="wallet")
        {
            WalletProvider wallet=InstaPay.walletAPI;
            if(wallet.transferMoney(from, GAS_WALLET_ACC_NUM, bills.get(code)))
            {
                payedBills.put(code,bills.get(code));
                bills.remove(code);
                return true;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}
