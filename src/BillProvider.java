public interface BillProvider {

    public void billsHistory();
    public void unpaidBills();
    public boolean payBill(String accType,String from,String code);
}

