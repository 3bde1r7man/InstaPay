import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    public final String BASE_USER_TABLE = "users";
    public final String WALLET_USER_TABLE = "walletUsers";
    public final String BANK_USER_TABLE = "bankUsers";
    public final String BANK_USER_TYPE = "bank";
    public final String WALLET_USER_TYPE = "wallet";


    public String databaseName;
    public String url;
    public Connection conn;


    public Database(String databaseName) {
        this.databaseName = databaseName;
        url = "jdbc:sqlite:D:/Java codes/InstaPay/src/instaPay.db"  ;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Database() {
        this("instaPay.db");
    }

    public void saveUser(User user) {
        if (user instanceof WalletUser) {
            createBaseUser(user.getUserName(), user.getPassword(), WALLET_USER_TYPE);
            int id = getLastId(BASE_USER_TABLE);
            createWalletUser(id, ((WalletUser) user).getPhoneNum());
        } else if (user instanceof BankUser) {
            createBaseUser(user.getUserName(), user.getPassword(), BANK_USER_TYPE);
            int id = getLastId(BASE_USER_TABLE);
            createBankUser(id, ((BankUser) user).getBankAccNum(), ((BankUser) user).getPhoneNum());
        }
    }

    public int getLastId(String tableName) {
        String sql = "SELECT id FROM " + tableName + " ORDER BY id DESC LIMIT 1";
        int id = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

    public void createBaseUser(String username, String password, String type) {
        String sql = "INSERT INTO " + BASE_USER_TABLE + "(username, password, type) VALUES(?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, type);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createWalletUser(int id, String phoneNum) {
        String sql = "INSERT INTO " + WALLET_USER_TABLE + "(user_id, phoneNum) VALUES(?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.setString(2, phoneNum);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createBankUser(int id, String bankAccNum, String phoneNum) {
        String sql = "INSERT INTO " + BANK_USER_TABLE + "(user_id, bankAccNum, phoneNum) VALUES(?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.setString(2, bankAccNum);
            pstmt.setString(3, phoneNum);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public User getUser(String userName) {
        String sql = "SELECT * FROM " + BASE_USER_TABLE + " WHERE username = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, userName);
            pstmt.executeQuery();
            if (pstmt.getResultSet().next()) {
                String type = pstmt.getResultSet().getString("type");
                if (type.equals(BANK_USER_TYPE)) {
                    return getBankUser(userName);
                } else if (type.equals(WALLET_USER_TYPE)) {
                    return getWalletUser(userName);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public User getBankUser(String userName) {
        String sql = "SELECT * FROM " + BASE_USER_TABLE + " JOIN " + BANK_USER_TABLE + " ON " + BASE_USER_TABLE
                + ".id = " + BANK_USER_TABLE + ".user_id WHERE username = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, userName);
            pstmt.executeQuery();
            if (pstmt.getResultSet().next()) {
                String password = pstmt.getResultSet().getString("password");
                String bankAccNum = pstmt.getResultSet().getString("bankAccNum");
                String phoneNum = pstmt.getResultSet().getString("phoneNum");
                return new BankUser(userName, password, bankAccNum, phoneNum);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public User getWalletUser(String userName) {
        String sql = "SELECT * FROM " + BASE_USER_TABLE + " JOIN " + WALLET_USER_TABLE + " ON " + BASE_USER_TABLE
                + ".id = " + WALLET_USER_TABLE + ".user_id WHERE username = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            pstmt.executeQuery();
            if (pstmt.getResultSet().next()) {
                String password = pstmt.getResultSet().getString("password");
                String phoneNum = pstmt.getResultSet().getString("phoneNum");
                return new WalletUser(userName, password, phoneNum);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean isUniqueUserName(String userName) {
        String sql = "SELECT * FROM " + BASE_USER_TABLE + " WHERE username = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, userName);
            pstmt.executeQuery();
            if (pstmt.getResultSet().next()) {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}