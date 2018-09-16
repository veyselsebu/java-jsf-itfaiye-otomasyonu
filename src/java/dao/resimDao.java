/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.resimEntity;
import entity.vatandasEntity;
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
public class resimDao {


    DBconnection db;
    Connection con;
   
    
    public resimDao() {
         db=new DBconnection();
        try {
            con=db.GetConnection();
        } catch (SQLException ex) {
            Logger.getLogger(resimDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public ArrayList<resimEntity> getlistele() throws SQLException{
        PreparedStatement st=con.prepareStatement("select * from resim");
        ResultSet rs=st.executeQuery();
          ArrayList<resimEntity> liste=new ArrayList<>();
        while(rs.next()){
            resimEntity a=new resimEntity(rs.getInt("resimId"),rs.getString("dosyaUzantisi"));
            liste.add(a);
        }
        
        return liste;
    }   
     public void ekle(resimEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("INSERT INTO resim ( dosyaUzantisi)VALUES (?)");
        
         st.setString(1,a.getUzanti());
         st.executeUpdate();
    }
        public void sil(resimEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("delete from resim where resimId=?");
         st.setString(1, ""+a.getResimId());
         st.executeUpdate();
        
    }
         public resimEntity bul(int ıd) throws SQLException{
        resimEntity resim = null;
        PreparedStatement st=con.prepareStatement("select * from resim where resimId=?");
        st.setInt(1, ıd);
        ResultSet rs=st.executeQuery();
        rs.next();
        resim=new resimEntity(rs.getInt("resimId"),rs.getString("dosyaUzantisi"));
        return resim;
         
     }
    
}
