import java.util.Scanner;

public class GasBill extends GasBillProvider {
    //private double usage;
    private String sector;
    public GasBill(String sector) {//double amount, String billType, String username,
        // this.amount = amount;
        // this.billType = billType;
        // this.username = username;
        //this.usage = usage;
        this.sector = sector;
    }

    public void gasBillOpitions(){
        while(true)
        {
            System.out.println("1-Bills History");
            System.out.println("2-Unpaid Bills");
            System.out.println("3-Pay Bills");
            System.out.println("4-exit");
            Scanner sc = new Scanner(System.in);
        
            int choice = sc.nextInt();
            BillProvider bill=new GasBillProvider();

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
                    //System.exit(0);
                    break;
                default:
                    System.out.println("invalid option");
                    break;
            }
            break;
        }
        
    }
}
