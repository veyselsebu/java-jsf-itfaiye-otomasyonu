/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.caddeEntity;
import entity.mahalleEntity;
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
public class mahalleDao {
 DBconnection db;
    Connection con;
   ilceDao ilce=new ilceDao();

    public ilceDao getIlce() {
        return ilce;
    }

    public void setIlce(ilceDao ilce) {
        this.ilce = ilce;
    }
    
    public mahalleDao() {
         db=new DBconnection();
        try {
            con=db.GetConnection();
        } catch (SQLException ex) {
            Logger.getLogger(mahalleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public ArrayList<mahalleEntity> getlistele() throws SQLException{
        PreparedStatement st=con.prepareStatement("select * from mahalle");
        ResultSet rs=st.executeQuery();
          ArrayList<mahalleEntity> liste=new ArrayList<>();
        while(rs.next()){
            mahalleEntity a=new mahalleEntity(rs.getInt("mahalleId"),rs.getString("mahalleAdi"),ilce.bul(rs.getInt("ilceId")));
            liste.add(a);
        }
        
        return liste;
    } 
       public mahalleEntity bul(int ıd) throws SQLException{
        
         PreparedStatement st=con.prepareStatement("select * from mahalle where mahalleId=?");
         st.setInt(1, ıd);
        ResultSet rs=st.executeQuery();
        rs.next();
                   mahalleEntity a=new mahalleEntity(rs.getInt("mahalleId"),rs.getString("mahalleAdi"),ilce.bul(rs.getInt("ilceId")));

       
       
       return a;
     }
     public void ekle(mahalleEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("INSERT INTO mahalle ( mahalleAdi,ilceId)VALUES (?,?)");
        
         st.setString(1,a.getMahalleAdi());
  
         st.setInt(2,a.getIlce().getIlceId());
       
         st.executeUpdate();
    }
        public void sil(mahalleEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("delete from mahalle where mahalleId=?");
         st.setString(1, ""+a.getMahalleId());
         st.executeUpdate();
        
    }
     public void guncelle(mahalleEntity a) throws SQLException{
          PreparedStatement st=con.prepareStatement("update mahalle set mahalleAdi=?,ilceId=? where mahalleId=?");
         st.setString(1,a.getMahalleAdi());
         st.setInt(2, a.getIlce().getIlceId());
         st.setInt(3,a.getMahalleId());
      
    
         st.executeUpdate();
     }   
     
}
