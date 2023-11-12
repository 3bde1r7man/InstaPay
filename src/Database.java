import java.util.ArrayList;
import java.sql.*;



public class Database {
    ArrayList<User> users = new ArrayList<User>();
    public void saveUser(User user){
        users.add(user);
    }
    public User getUser(String userName){
        for(User user: users){
            if(user.getUserName().equals(userName)){
                return user;
            }
        }
        return null;
    }
    // Database(){
    //     try {
    //         Connection conn = DriverManager.getConnection("jdbc:sqlite:db.sqlite3");
    //         Statement stmt = conn.createStatement();
    //         stmt.execute("CREATE TABLE IF NOT EXISTS users (username TEXT, password TEXT, bankAccNum TEXT, balance REAL, phoneNum TEXT)");
    //         stmt.execute("CREATE TABLE IF NOT EXISTS bills (amount REAL, billType TEXT, username TEXT, usage REAL, sector TEXT)");
    //         stmt.close();
    //         conn.close();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
        
    //     // Bill bill = new WaterBill(100, "Water", "user1", 100, "sector1");
    //     // saveBill(bill);
    //     // bill = new ElectricityBill(200, "Electricity", "user2", 200, "sector2");
    //     // saveBill(bill);
    //     // bill = new GasBill(300, "Gas", "user3", 300, "sector3");
    //     // saveBill(bill);
    //     // User user = new BankUser("user1", "pass1", "bankAccNum1", 1000, "phoneNum1");
    //     // saveUser(user);
    // }
    // public static void main(String[] args) {
    //     Database db = new Database();
    //     System.out.println(db.bills);
    //     System.out.println(db.users);
    // }
}