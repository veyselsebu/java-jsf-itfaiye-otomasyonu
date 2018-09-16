/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.ekipEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import util.DBconnection;

/**
 *
 * @author veysels
 */
@ManagedBean
@RequestScoped
public class ekipDao {

   DBconnection db;
    Connection con;
   
    
    public ekipDao() {
         db=new DBconnection();
        try {
            con=db.GetConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ekipDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public ArrayList<ekipEntity> getlistele() throws SQLException{
        PreparedStatement st=con.prepareStatement("select * from ekip");
        ResultSet rs=st.executeQuery();
          ArrayList<ekipEntity> liste=new ArrayList<>();
        while(rs.next()){
            ekipEntity a=new ekipEntity(rs.getInt("ekipId"),rs.getString("ekipAdi"),rs.getString("aciklama"));
            liste.add(a);
        }
        
        return liste;
    }   
      public ekipEntity bul(int id) throws SQLException{
       ekipEntity a=null;
        PreparedStatement st=con.prepareStatement("select * from ekip where ekipId=?");
        st.setString(1, ""+id);
        ResultSet rs=st.executeQuery();
        rs.next();
        a=new ekipEntity(rs.getInt("ekipId"),rs.getString("ekipAdi"),rs.getString("aciklama"));
       
       
       return a;
   }  
     public void ekle(ekipEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("INSERT INTO ekip (ekipAdi,aciklama)VALUES (?,?)");
       
         st.setString(1, a.getEkipAdi());
         st.setString(2,a.getAciklama());
         st.executeUpdate();
    }
        public void sil(ekipEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("delete from ekip where ekipId=?");
         st.setString(1, ""+a.getEkipId());
         st.executeUpdate();
        
    }
     public void guncelle(ekipEntity a) throws SQLException{
          PreparedStatement st=con.prepareStatement("update ekip set ekipAdi=?,aciklama=? where ekipId=?");
         st.setString(1,a.getEkipAdi());
         st.setString(2, a.getAciklama());
         st.setInt(3,a.getEkipId());
        
         st.executeUpdate();
     }  
}
