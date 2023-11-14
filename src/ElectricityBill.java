import java.util.Scanner;

public class ElectricityBill extends ElectricityBillProvider {
    private String sector;
    public ElectricityBill ( String sector) {
        this.sector = sector;
    }
    public void ElectricityBillOpitions(){
        while(true)
        {
            System.out.println("1-Bills History");
            System.out.println("2-Unpaid Bills");
            System.out.println("3-Pay Bills");
            System.out.println("4-Return");
            Scanner sc = new Scanner(System.in);
        
            int choice = sc.nextInt();
            BillProvider bill=new ElectricityBillProvider();

            switch ((choice)) {
                case 1:
                    bill.billsHistory();
                    break;
                case 2:
                    bill.unpaidBills();
                    break;
                case 3:
                    if(bill.payBill()){
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