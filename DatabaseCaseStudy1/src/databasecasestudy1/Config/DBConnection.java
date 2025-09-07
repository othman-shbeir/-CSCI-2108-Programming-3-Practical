
package databasecasestudy1.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnection {
    private Connection connection;
    private static DBConnection dBConnection;

    private DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = 
                    DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/school?Timezone=UTC","root","");
            System.out.println("Database Connection is created Successfully");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    Singltone Access Method
    public static synchronized DBConnection getDBConnection() {
        if(dBConnection == null){
            dBConnection = new DBConnection();
        }
        
        return dBConnection;
    }

    public Connection getConnection() {
        return connection;
    }
    
    
    
}
