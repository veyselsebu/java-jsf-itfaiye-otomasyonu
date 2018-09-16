/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.adresEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class adresDao {
   DBconnection db;
    Connection con;
   
    
    public adresDao() {
         db=new DBconnection();
        try {
            con=db.GetConnection();
        } catch (SQLException ex) {
            Logger.getLogger(adresDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public adresEntity bul (int id) throws SQLException{
        adresEntity olaytipi = null;
         caddeDao cad=new caddeDao();
       PreparedStatement st=con.prepareStatement("select * from adres where adresId=?");
       st.setInt(1, id);
        ResultSet rs=st.executeQuery();
         rs.next();
        adresEntity a=new adresEntity(rs.getInt("adresId"),cad.bul(rs.getInt("caddeId")),rs.getString("acikAdres"));
        return a;
     }
     public ArrayList<adresEntity> getlistele() throws SQLException{
         caddeDao cad=new caddeDao();
        PreparedStatement st=con.prepareStatement("select * from adres");
        ResultSet rs=st.executeQuery();
          ArrayList<adresEntity> liste=new ArrayList<>();
        while(rs.next()){
            adresEntity a=new adresEntity(rs.getInt("adresId"),cad.bul(rs.getInt("caddeId")),rs.getString("acikAdres"));
            liste.add(a);
        }
        
        return liste;
    }   
     public void ekle(adresEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("INSERT INTO adres (acikAdres, caddeId)VALUES ( ?, ?)");
         st.setString(1, a.getAcikAdres());
         st.setInt(2,a.getCadde().getCaddeId());
         st.executeUpdate();
    }
        public void sil(adresEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("delete from adres where adresId=?");
         st.setString(1, ""+a.getAdresId());
         st.executeUpdate();
        
    }
     public void guncelle(adresEntity a) throws SQLException{
          PreparedStatement st=con.prepareStatement("update adres set acikAdres=?,caddeId=? where adresId=?");
         st.setString(1,a.getAcikAdres());
         st.setInt(2,a.getCadde().getCaddeId());
         st.setInt(3,a.getAdresId());
         st.executeUpdate();
     }   
     
}
