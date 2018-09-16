/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.ekipmanEntity;
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
public class ekipmanDao {

  
    DBconnection db;
    Connection con;
   
    
    public ekipmanDao() {
         db=new DBconnection();
        try {
            con=db.GetConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ekipmanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public ekipmanEntity bul(int id) throws SQLException{
       ekipmanEntity a=null;
        PreparedStatement st=con.prepareStatement("select * from ekipman where ekipmanId=?");
        st.setString(1, ""+id);
        ResultSet rs=st.executeQuery();
        rs.next();
        a=new ekipmanEntity(rs.getInt("ekipmanId"),rs.getString("ekipmanAdi"),rs.getString("icerik"),rs.getString("kullanimAlani"));
       
       return a;
   }     

     public ArrayList<ekipmanEntity> getlistele() throws SQLException{
        PreparedStatement st=con.prepareStatement("select * from ekipman");
        ResultSet rs=st.executeQuery();
          ArrayList<ekipmanEntity> liste=new ArrayList<>();
        while(rs.next()){
            ekipmanEntity a=new ekipmanEntity(rs.getInt("ekipmanId"),rs.getString("ekipmanAdi"),rs.getString("icerik"),rs.getString("kullanimAlani"));
            liste.add(a);
        }
        
        return liste;
    }   
     public void ekle(ekipmanEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("INSERT INTO ekipman ( ekipmanAdi,icerik,kullanimAlani)VALUES (?,?,?)");
        
         st.setString(1,a.getEkipmanAdi());
         st.setString(2, a.getIcerik());
  
            st.setString(3, a.getKullanimAlani());
         st.executeUpdate();
    }
        public void sil(ekipmanEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("delete from ekipman where ekipmanId=?");
         st.setString(1, ""+a.getEkimanId());
         st.executeUpdate();
        
    }
     public void guncelle(ekipmanEntity a) throws SQLException{
          PreparedStatement st=con.prepareStatement("update ekipman set ekipmanAdi=?,icerik=?,kullanimAlani=? where ekipmanId=?");
         st.setString(1,a.getEkipmanAdi());
         st.setString(2, a.getIcerik());
         st.setString(3,a.getKullanimAlani());
         st.setInt(4, a.getEkimanId());
        
         st.executeUpdate();
     }   
}
