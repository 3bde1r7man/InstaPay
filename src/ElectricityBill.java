import java.util.Scanner;

public class ElectricityBill{
    private String sector;
    public BillProvider bill=InstaPay.electricityProvider;
    public ElectricityBill ( String sector) {
        this.sector = sector;
    }
    public void ElectricityBillOpitions(String accType,String accNum){
        while(true)
        {
            System.out.println("1-Bills History");
            System.out.println("2-Unpaid Bills");
            System.out.println("3-Pay Bills");
            System.out.println("4-Return");
            Scanner sc = new Scanner(System.in);
        
            int choice = sc.nextInt();
            

            switch ((choice)) {
                case 1:
                    bill.billsHistory();
                    break;
                case 2:
                    bill.unpaidBills();
                    break;
                case 3:
                    System.out.println("Enter bill code: ");
                    String code=sc.next();
                    if(bill.payBill(accType,accNum,code)){
                        System.out.println("Paid Successfully");
                    }
                    else{
                        System.err.println("Paid fail!");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("invalid option");
                    break;
                    
            }
            break;
        }
        
    }

    
}