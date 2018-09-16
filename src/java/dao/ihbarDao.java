/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.ihbarEntity;
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
public class ihbarDao {

 
    DBconnection db;
    Connection con;
   
    
    public ihbarDao() {
         db=new DBconnection();
        try {
            con=db.GetConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ihbarDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public ArrayList<ihbarEntity> getlistele() throws SQLException{
         calisanDao cal=new calisanDao();
         vatandasDao vat=new vatandasDao();
         PreparedStatement st=con.prepareStatement("select * from ihbar");
        ResultSet rs=st.executeQuery();
          ArrayList<ihbarEntity> liste=new ArrayList<>();
        while(rs.next()){
            ihbarEntity a=new ihbarEntity(rs.getInt("ihbarId"),cal.bul(rs.getInt("calisanId")),vat.bul(rs.getString("tcNo")));
            liste.add(a);
        }
        
        return liste;
    }   
        public ihbarEntity bul (int id) throws SQLException{
      calisanDao cal=new calisanDao();
         vatandasDao vat=new vatandasDao();
      
       PreparedStatement st=con.prepareStatement("select * from ihbar where ihbarId=?");
       st.setInt(1, id);
        ResultSet rs=st.executeQuery();
         rs.next();
            ihbarEntity a=new ihbarEntity(rs.getInt("ihbarId"),cal.bul(rs.getInt("calisanId")),vat.bul(rs.getString("tcNo")));
        return a;
     }
     public void ekle(ihbarEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("INSERT INTO ihbar ( calisanId,tcNo)VALUES (?,?)");
        
         st.setInt(1,a.getCalisan().getCalisanId());
 
         st.setString(2, a.getVatandas().getTcNo());
         st.executeUpdate();
    }
        public void sil(ihbarEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("delete from ihbar where ihbarId=?");
         st.setString(1, ""+a.getIhbarId());
         st.executeUpdate();
        
    }
     public void guncelle(ihbarEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("update ihbar set calisanId=?,tcNo=? where ihbarId=?");
         st.setInt(1,a.getCalisan().getCalisanId());       
         st.setString(2, a.getVatandas().getTcNo());
         st.setInt(3, a.getIhbarId());
         st.executeUpdate();
     }   
     
}
