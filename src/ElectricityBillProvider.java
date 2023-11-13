public class ElectricityBillProvider implements BillProvider{
    public void billsHistory(){
        String bills[]={"1","2","3"};
        for(String bill : bills)
        { 
            System.out.println(bill);
        }
    }

    public void unpaidBills(){
        String bills[]={"1","2","3"};
        for(String bill : bills)
        { 
            System.out.println(bill);
        }
    }
    public boolean payBill()
    {
        return true;
    }
}
