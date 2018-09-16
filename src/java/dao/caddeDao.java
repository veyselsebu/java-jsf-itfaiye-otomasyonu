/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.caddeEntity;
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
public class caddeDao {

 DBconnection db;
    Connection con;
   
    
    public caddeDao() {
         db=new DBconnection();
        try {
            con=db.GetConnection();
        } catch (SQLException ex) {
            Logger.getLogger(caddeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public ArrayList<caddeEntity> getlistele() throws SQLException{
         mahalleDao mahalle=new mahalleDao();
        PreparedStatement st=con.prepareStatement("select * from cadde");
        ResultSet rs=st.executeQuery();
          ArrayList<caddeEntity> liste=new ArrayList<>();
        while(rs.next()){
            caddeEntity a=new caddeEntity(rs.getInt("caddeId"),mahalle.bul(rs.getInt("mahalleId")),rs.getString("caddeAdi"));
            liste.add(a);
        }
        
        return liste;
    }   
       public caddeEntity bul(int ıd) throws SQLException{
          caddeEntity a=null;
         PreparedStatement st=con.prepareStatement("select * from cadde where caddeId=?");
         st.setInt(1, ıd);
        ResultSet rs=st.executeQuery();
        rs.next();
         a=new caddeEntity(rs.getInt("caddeId"),rs.getInt("mahalleId"),rs.getString("caddeAdi"));
       
       
       return a;
     }
     public void ekle(caddeEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("INSERT INTO cadde (caddeAdi, mahalleId,caddeId)VALUES ( ?, ?,?)");
         st.setString(1, a.getCaddeAdi());
         st.setInt(2,a.getMahalleId());
         st.setInt(3,a.getCaddeId());
         st.executeUpdate();
    }
        public void sil(caddeEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("delete from cadde where caddeId=?");
         st.setString(1, ""+a.getCaddeId());
         st.executeUpdate();
        
    }
     public void guncelle(caddeEntity a) throws SQLException{
          PreparedStatement st=con.prepareStatement("update cadde set caddeAdi=?,mahalleId=? where caddeId=?");
         st.setString(1,a.getCaddeAdi());
         st.setInt(2,a.getMahalleId());
         st.setInt(3,a.getCaddeId());
         st.executeUpdate();
     }   
     
    
}
