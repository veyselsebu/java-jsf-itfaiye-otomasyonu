/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.adminYetkiEntity;
import entity.adresEntity;
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
public class adminYetkiDao {
     DBconnection baglanti;
     Connection con;
     
    public adminYetkiDao() {
          baglanti=new DBconnection();
        try {
            con=baglanti.GetConnection();
        } catch (SQLException ex) {
            Logger.getLogger(adresDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void create (adminYetkiEntity a) throws SQLException{
       PreparedStatement st=con.prepareStatement("insert into adminYetki(ekleme,silme,guncelleme,ad) values (?,?,?,?)");
        st.setBoolean(1, a.getEkleme());
        st.setBoolean(2, a.getSilme());
        st.setBoolean(3, a.getGuncelleme());
        st.setString(4,a.getAd());
        st.executeUpdate();
    }
    public void delete(adminYetkiEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("delete from adminYetki where adminYetkiId=?");
         st.setInt(1, a.getAdminYetkiId());
         st.executeUpdate();
         
    }
    public void update (adminYetkiEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("update adminYetki set ekleme=?,silme=?,guncelleme=?,ad=? where adminYetkiId=?");
        st.setBoolean(1, a.getEkleme());
        st.setBoolean(2, a.getSilme());
        st.setBoolean(3, a.getGuncelleme());
        st.setString(4,a.getAd());
        st.setInt(5, a.getAdminYetkiId());
        st.executeUpdate();
        
    }
   public adminYetkiEntity find(int id) throws SQLException{
     
       PreparedStatement st=con.prepareStatement("select * from adminYetki where adminYetkiId=?");
       st.setInt(1, id);
       ResultSet rs=st.executeQuery();
       rs.next();
       adminYetkiEntity a=new adminYetkiEntity(rs.getInt("adminYetkiId"),rs.getBoolean("ekleme"),rs.getBoolean("silme"),rs.getBoolean("guncelleme"),rs.getString("ad"));
       return a;
   }
    
   public ArrayList<adminYetkiEntity> list() throws SQLException{
       ArrayList<adminYetkiEntity> listem=new ArrayList<>(); 
       PreparedStatement st=con.prepareStatement("select * from adminYetki");
       ResultSet rs=st.executeQuery();
       while(rs.next()){
          adminYetkiEntity a=new adminYetkiEntity(rs.getInt("adminYetkiId"),rs.getBoolean("ekleme"),rs.getBoolean("silme"),rs.getBoolean("guncelleme"),rs.getString("ad")); 
           listem.add(a);
          
       }
       
     return listem;  
   }
    
    public DBconnection getBaglanti() {
        if(baglanti==null)
            baglanti=new DBconnection();
        return baglanti;
    }

    public void setBaglanti(DBconnection baglanti) {
        this.baglanti = baglanti;
    }

   
    
}
