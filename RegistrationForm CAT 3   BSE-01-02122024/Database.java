import java.sql.*;

public class Database {
    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:users.db");
            createTableIfNotExists(conn);
        } catch (Exception e) {
            System.out.println("DB connection error");
            e.printStackTrace();
        }
        return conn;
    }

    private static void createTableIfNotExists(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                     "id TEXT PRIMARY KEY," +
                     "name TEXT," +
                     "contact TEXT," +
                     "gender TEXT," +
                     "dob TEXT," +
                     "address TEXT" +
                     ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insert(String id, String name, String contact, String gender, String dob, String address) {
        System.out.println("Insert method called");
        String sql = "INSERT INTO users(id, name, contact, gender, dob, address) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, contact);
            pstmt.setString(4, gender);
            pstmt.setString(5, dob);
            pstmt.setString(6, address);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}