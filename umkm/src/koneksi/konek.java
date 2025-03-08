package koneksi;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class konek {
    private static Connection conn;
    private static Statement st;

    public static Connection koneksi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/toko_kelontong_2";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi berhasil");
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Driver tidak ditemukan: " + e.getMessage());
        }
        return conn;
    }

    public static Connection getConnection() {
        if (conn == null) {
            try {
                return koneksi();
            } catch (Exception e) {
                Logger.getLogger(konek.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return conn;
    }
}



