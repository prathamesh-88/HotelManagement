
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prathamesh
 */
public class Room {
    MY_CONNECTION connect=new MY_CONNECTION();
   public boolean CheckIn(int roomno,String CheckIn,String CheckOut){
        PreparedStatement ps;
        ResultSet rs;
        String SetQuery="UPDATE `rooms` SET `Check in`=?,`Checkout`=?,`Availability`=? WHERE `Room No.`=?";
        try {
            ps=connect.CreateConnection().prepareStatement(SetQuery);
            ps.setString(1,CheckIn);
            ps.setString(2,CheckOut);
            ps.setString(3, "Unavailable");
            ps.setInt(4, roomno);
             if(ps.executeUpdate()>0) {
                return true;
            } 
            else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
    }
   
   public boolean CheckOut(int roomno){
       PreparedStatement ps;
        ResultSet rs;
        String SetQuery="UPDATE `rooms` SET `Check in`=?,`Checkout`=?,`Availability`=? WHERE `Room No.`=?";
        try {
            ps=connect.CreateConnection().prepareStatement(SetQuery);
            ps.setDate(1,null);
            ps.setDate(2,null);
            ps.setString(3, "Available");
            ps.setInt(4, roomno);
             if(ps.executeUpdate()>0) {
                return true;
            } 
            else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
   }
     public void FillRoomJTable(JTable table)
    {
         PreparedStatement ps;
         ResultSet rs;
         String SetQuery="SELECT `Room No.`, `Type`, `Check in`, `Checkout`, `Availability` FROM `rooms`";
        try {
            ps=connect.CreateConnection().prepareStatement(SetQuery);
            rs=ps.executeQuery();
            DefaultTableModel objT= (DefaultTableModel) table.getModel();
            Object row[];
            while(rs.next())
            {
            row=new Object[5];
            row[0]=rs.getString(1);
            row[1]=rs.getString(2);
            row[2]=rs.getString(3);
            row[3]=rs.getString(4);
            row[4]=rs.getString(5);
            objT.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public boolean isAvailable(int roomno)
     {
     PreparedStatement ps;
     ResultSet rs;
     String setQuery="SELECT `Availability` FROM `rooms` WHERE `Room No.`=?";
        try {
            ps=connect.CreateConnection().prepareStatement(setQuery);
            ps.setInt(1,roomno);
            rs=ps.executeQuery();
           if(rs.next()){
            String check=rs.getString(1);
            return check.equals("Available");
           }
           else {
               return false;
           }
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     }
    
}
