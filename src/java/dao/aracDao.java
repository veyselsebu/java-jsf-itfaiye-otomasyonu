/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.adresEntity;
import entity.aracEntity;
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
public class aracDao {
    
    
    DBconnection db;
    Connection con;
   
    
    public aracDao() {
         db=new DBconnection();
        try {
            con=db.GetConnection();
        } catch (SQLException ex) {
            Logger.getLogger(aracDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public ArrayList<aracEntity> getlistele() throws SQLException{
        PreparedStatement st=con.prepareStatement("select * from arac");
        ResultSet rs=st.executeQuery();
          ArrayList<aracEntity> liste=new ArrayList<>();
        while(rs.next()){
            aracEntity a=new aracEntity(rs.getString("plaka"),rs.getString("marka"),rs.getString("model"),rs.getString("ozellikleri"),rs.getInt("kapasiteLitre"));
            liste.add(a);
        }
        
        return liste;
    }   
     public void ekle(aracEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("INSERT INTO arac (plaka, marka,model,ozellikleri,kapasiteLitre)VALUES ( ?, ?,?,?,?)");
         st.setString(1, a.getPlaka());
         st.setString(2,a.getMarka());
         st.setString(3, a.getModel());
         st.setString(4,a.getOzellikler());
         st.setInt(5, a.getKapasiteLitre());
         st.executeUpdate();
    }
        public void sil(aracEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("delete from arac where plaka=?");
         st.setString(1, ""+a.getPlaka());
         st.executeUpdate();
        
    }
     public void guncelle(aracEntity a) throws SQLException{
          PreparedStatement st=con.prepareStatement("update arac set marka=?,model=?,ozellikleri=?,kapasiteLitre=? where plaka=?");
         st.setString(1,a.getMarka());
         st.setString(2, a.getModel());
         st.setString(3,a.getOzellikler());
         st.setInt(4, a.getKapasiteLitre());
         st.setString(5, a.getPlaka());
         st.executeUpdate();
     }   
     
}
