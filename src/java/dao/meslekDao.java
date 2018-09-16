/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.meslekEntity;
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
public class meslekDao {
 DBconnection db;
    Connection con;
   
    
    public meslekDao() {
         db=new DBconnection();
        try {
            con=db.GetConnection();
        } catch (SQLException ex) {
            Logger.getLogger(meslekDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public ArrayList<meslekEntity> getlistele() throws SQLException{
        PreparedStatement st=con.prepareStatement("select * from meslek");
        ResultSet rs=st.executeQuery();
          ArrayList<meslekEntity> liste=new ArrayList<>();
        while(rs.next()){
            meslekEntity a=new meslekEntity(rs.getInt("meslekId"),rs.getString("meslekAd"),rs.getString("aciklama"));
            liste.add(a);
        }
        
        return liste;
    }   
        public meslekEntity bul(int id) throws SQLException{
       meslekEntity a=null;
        PreparedStatement st=con.prepareStatement("select * from meslek where meslekId=?");
        st.setString(1, ""+id);
        ResultSet rs=st.executeQuery();
        rs.next();
        a=new  meslekEntity(rs.getInt("meslekId"),rs.getString("meslekAd"),rs.getString("aciklama"));
       
       
       return a;
   }  
     
     public void ekle(meslekEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("INSERT INTO meslek ( meslekAd,aciklama)VALUES (?,?)");
        
         st.setString(1,a.getMeslekAdi());
         st.setString(2, a.getAciklama());
        
         st.executeUpdate();
    }
        public void sil(meslekEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("delete from meslek where meslekId=?");
         st.setString(1, ""+a.getMeslekId() );
         st.executeUpdate();
        
    }
     public void guncelle(meslekEntity a) throws SQLException{
          PreparedStatement st=con.prepareStatement("update meslek set meslekAd=?,aciklama=? where meslekId=?");
         st.setString(1,a.getMeslekAdi());
         st.setString(2, a.getAciklama());
         st.setInt(3,a.getMeslekId());
      
         st.executeUpdate();
     }   
     
  	
}
