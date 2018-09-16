/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.cinsiyetEntity;
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
public class cinsiyetDao {

    DBconnection db;
    Connection con;
   
    
    public cinsiyetDao() {
         db=new DBconnection();
        try {
            con=db.GetConnection();
        } catch (SQLException ex) {
            Logger.getLogger(yetkiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public ArrayList<cinsiyetEntity> getlistele() throws SQLException{
        PreparedStatement st=con.prepareStatement("select * from cinsiyet");
        ResultSet rs=st.executeQuery();
          ArrayList<cinsiyetEntity> liste=new ArrayList<>();
        while(rs.next()){
            cinsiyetEntity a=new cinsiyetEntity(rs.getInt("cinsiyetId"),rs.getString("cinciyetAd"));
            liste.add(a);
        }
        
        return liste;
    }   


   public cinsiyetEntity bul(int id) throws SQLException{
       cinsiyetEntity a=null;
        PreparedStatement st=con.prepareStatement("select * from cinsiyet where cinsiyetId=?");
        st.setString(1, ""+id);
        ResultSet rs=st.executeQuery();
        rs.next();
        a=new cinsiyetEntity(rs.getInt("cinsiyetId"),rs.getString("cinciyetAd"));
       
       
       return a;
   }     

    public void ekle(cinsiyetEntity yetki) {
      
    }

    public void sil(cinsiyetEntity yetki) {
    }

    public void guncelle(cinsiyetEntity yetki2) {
    }
}
