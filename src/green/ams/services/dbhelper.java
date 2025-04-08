
package green.ams.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbhelper {

  
    public dbhelper() {
       
    }  
    
    
    public Connection getConnection(){
         
        Connection access_conn = null;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            String db_file_path = "src\\green\\ams\\db\\green.accdb";

            String conn_url = "jdbc:ucanaccess://" + db_file_path;

            access_conn = DriverManager.getConnection(conn_url);
            
        } catch (Exception e) {
            System.out.println("Error in Connection" + e.getMessage());
        }
         
        
        return (access_conn != null)? access_conn : null;
    }
    
    
    public static void main(String[] args) {
        
    }
    
}
