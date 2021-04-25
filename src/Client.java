import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Client {
    MY_CONNECTION connect=new MY_CONNECTION();
    public boolean AddClient(String name,String cn,String idtype,String idno,int roomno){
        PreparedStatement ps;
        ResultSet rs;
        String SetQuery="INSERT INTO `client`(`Name`, `Contact no.`, `idtype`, `idnumber`, `Room No.`) VALUES (?,?,?,?,?)";
        try {
            ps=connect.CreateConnection().prepareStatement(SetQuery);
            ps.setString(1,name);
            ps.setString(2,cn);
            ps.setString(3,idtype);
            ps.setString(4,idno);
            ps.setInt(5,roomno);
            if(ps.executeUpdate()>0) {
                return true;
            } 
            else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
   
    public void FillClientJTable(JTable table)
    {
         PreparedStatement ps;
         ResultSet rs;
         String SetQuery="SELECT `Name`, `Contact no.`,`idtype`, `idnumber`, `Room No.` FROM `client`";
        try {
            ps=connect.CreateConnection().prepareStatement(SetQuery);
            rs=ps.executeQuery();
            DefaultTableModel objT= (DefaultTableModel) table.getModel();
            Object row[];
            while(rs.next())
            {
            row=new Object[5];
            row[0]=rs.getString(5);
            row[1]=rs.getString(1);
            row[2]=rs.getString(2);
            row[3]=rs.getString(3);
            row[4]=rs.getString(4);
            objT.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
    public boolean RemoveClient(int roomno){
        PreparedStatement ps;
        ResultSet rs;
        String deleteQuery="DELETE FROM `client` WHERE `room no.`=?";
        try {
            ps=connect.CreateConnection().prepareStatement(deleteQuery);
            ps.setInt(1,roomno);
            if(ps.executeUpdate()>0) {
                return true;
            } 
            else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
     public void FillCheckoutJTable(JTable table)
    {
         PreparedStatement ps;
         ResultSet rs;
         String SetQuery="SELECT client.`Room No.`,client.Name,client.`Contact no.`,client.idtype,client.idnumber,rooms.`Check in`,rooms.Checkout\n" +"FROM client,rooms\n" +"WHERE client.`Room No.`=rooms.`Room No.`";
        try {
            ps=connect.CreateConnection().prepareStatement(SetQuery);
            rs=ps.executeQuery();
            DefaultTableModel objT= (DefaultTableModel) table.getModel();
            Object row[];
            while(rs.next())
            {
            row=new Object[7];
            row[0]=rs.getString(1);
            row[1]=rs.getString(2);
            row[2]=rs.getString(3);
            row[3]=rs.getString(4);
            row[4]=rs.getString(5);
            row[5]=rs.getString(6);
            row[6]=rs.getString(7);
            objT.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
