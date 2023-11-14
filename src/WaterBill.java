import java.util.Scanner;

public class WaterBill extends WaterBillProvider {
    //private double usage;
    private String sector;
    public WaterBill(  String sector) {//double amount, String billType, String username,
        // this.amount = amount;
        // this.billType = billType;
        // this.username = username;
        //this.usage = usage;
        this.sector = sector;
    }

    public void waterBillOpitions(){
        while(true)
        {
            System.out.println("1-Bills History");
            System.out.println("2-Unpaid Bills");
            System.out.println("3-Pay Bills");
            System.out.println("4-Return");
            Scanner sc = new Scanner(System.in);
        
            int choice = sc.nextInt();
            BillProvider bill=new WaterBillProvider();

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
