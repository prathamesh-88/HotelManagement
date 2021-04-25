
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Prathamesh
 */
public class MY_CONNECTION {
    public Connection CreateConnection(){
        Connection connect=null;
        MysqlDataSource con=new MysqlDataSource();
        con.setServerName("localhost");
        con.setPortNumber(3306);
        con.setUser("root");
        con.setPassword("");
        con.setDatabaseName("hotelmanagement");
               
        try {
            connect=con.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MY_CONNECTION.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connect;
    }
    
}
