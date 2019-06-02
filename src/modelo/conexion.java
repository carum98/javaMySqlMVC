
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class conexion {
    
    private static final String URL= "jdbc:mysql://localhost:3306/javamvc?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    
    public Connection getConection()
    {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.URL, this.USERNAME, this.PASSWORD);
            JOptionPane.showMessageDialog(null, "Conexion exitosa");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    } 
}
