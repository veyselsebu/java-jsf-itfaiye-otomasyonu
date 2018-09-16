/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.yetkiEntity;
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
public class yetkiDao {

    DBconnection db;
    Connection con;
   
    
    public yetkiDao() {
         db=new DBconnection();
        try {
            con=db.GetConnection();
        } catch (SQLException ex) {
            Logger.getLogger(yetkiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public ArrayList<yetkiEntity> getlistele() throws SQLException{
        PreparedStatement st=con.prepareStatement("select * from yetki");
        ResultSet rs=st.executeQuery();
          ArrayList<yetkiEntity> liste=new ArrayList<>();
        while(rs.next()){
            yetkiEntity a=new yetkiEntity(rs.getInt("yetkiId"),rs.getString("yetkiAd"),rs.getString("aciklama"));
            liste.add(a);
        }
        
        return liste;
    }   
     public ArrayList<yetkiEntity> getkullaniciYetkilistele(String kullaniciAdi) throws SQLException{
        PreparedStatement st=con.prepareStatement("select * from kullaniciyetki where kullanciAdi=?");
        st.setString(1, kullaniciAdi);
        ResultSet rs=st.executeQuery();
          ArrayList<yetkiEntity> liste=new ArrayList<>();
        while(rs.next()){
            
            liste.add(bul(rs.getInt("yetkiId")));
        }
        
        return liste;
    }   

   public yetkiEntity bul(int id) throws SQLException{
       yetkiEntity a=null;
        PreparedStatement st=con.prepareStatement("select * from yetki where yetkiId=?");
        st.setString(1, ""+id);
        ResultSet rs=st.executeQuery();
        rs.next();
        a=new yetkiEntity(rs.getInt("yetkiId"),rs.getString("yetkiAd"),rs.getString("aciklama"));
       
       
       return a;
   }     

    public void ekle(yetkiEntity yetki) throws SQLException {
      PreparedStatement st=con.prepareStatement("INSERT INTO yetki (yetkiAd,aciklama)VALUES (?,?)");
      
         st.setString(1,yetki.getYetkiAd());
         st.setString(2, yetki.getAciklama());
         
         st.executeUpdate();
    }

    public void sil(yetkiEntity yetki) throws SQLException {
         PreparedStatement st=con.prepareStatement("delete from yetki where yetkiId=?");
         st.setString(1, ""+yetki.getYetkiId());
         st.executeUpdate();
    }

    public void guncelle(yetkiEntity yetki2) throws SQLException {
          PreparedStatement st=con.prepareStatement("update yetki set yetkiAd=?,aciklama=? where yetkiId=?");
        
         st.setString(1, yetki2.getYetkiAd());
         st.setString(2,yetki2.getAciklama());
         
         st.setInt(3, yetki2.getYetkiId());
        
         st.executeUpdate();
        
    }
}
