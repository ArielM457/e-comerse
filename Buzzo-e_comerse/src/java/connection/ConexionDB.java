
package connection;
import java.sql.*;
public class ConexionDB {
    public static Connection getConnection(){
             Connection con=null;
             try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","Ariel77241886");  
                    
                    System.out.println("Conexion Satisfactoria");
                   }catch(Exception e){
                       System.out.println("Error --->:"+e);
                                       }
        return con;
    }
    public static void main(String[] args) {
              ConexionDB.getConnection();
    }
}
