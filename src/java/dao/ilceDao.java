/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.ilceEntity;
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
public class ilceDao {


    DBconnection db;
    Connection con;
   
    
    public ilceDao() {
         db=new DBconnection();
        try {
            con=db.GetConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ilceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public ArrayList<ilceEntity> getlistele() throws SQLException{
        PreparedStatement st=con.prepareStatement("select * from ilce");
        ResultSet rs=st.executeQuery();
          ArrayList<ilceEntity> liste=new ArrayList<>();
        while(rs.next()){
            ilceEntity a=new ilceEntity(rs.getInt("ilceId"),rs.getString("ilceAdi"));
            liste.add(a);
        }
        
        return liste;
    }   
     public void ekle(ilceEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("INSERT INTO ilce (ilceAdi)VALUES (?)");
        
        
         st.setString(1, a.getIlceAdi());
         st.executeUpdate();
    }
        public void sil(ilceEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("delete from ilce where ilceId=?");
         st.setString(1, ""+a.getIlceId());
         st.executeUpdate();
        
    }
     public void guncelle(ilceEntity a) throws SQLException{
          PreparedStatement st=con.prepareStatement("update ilce set ilceAdi=? where ilceId=?");
      
         st.setString(1, a.getIlceAdi());
         st.setInt(2, a.getIlceId());
         st.executeUpdate();
     }   
     public ilceEntity bul(int id) throws SQLException{
         ilceEntity ilcem;
        
             PreparedStatement st=con.prepareStatement("select * from ilce where ilceId=?");
             st.setInt(1,id);
              ResultSet rs=st.executeQuery();
              rs.next();
                ilcem=new ilceEntity(rs.getInt("ilceId"),rs.getString("ilceAdi"));
            
       return ilcem;
     }
    
}
