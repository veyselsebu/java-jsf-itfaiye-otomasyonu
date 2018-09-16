/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.olayEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class olayDao {


    DBconnection db;
    Connection con;
   
    
    public olayDao() {
         db=new DBconnection();
        try {
            con=db.GetConnection();
        } catch (SQLException ex) {
            Logger.getLogger(olayDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public ArrayList<olayEntity> getlistele() throws SQLException{
         olayTipiDao olaytipi=new olayTipiDao();
         adresDao adres=new adresDao();
         ihbarDao ihbar=new ihbarDao();
        PreparedStatement st=con.prepareStatement("select * from olay");
        ResultSet rs=st.executeQuery();
          ArrayList<olayEntity> liste=new ArrayList<>();
        while(rs.next()){
            olayEntity a=new olayEntity(rs.getInt("olayId"),rs.getInt("oluSayisi"),rs.getInt("yaraliSayisi"),olaytipi.bul(rs.getInt("olayTipiId")),adres.bul(rs.getInt("adresId")),ihbar.bul(rs.getInt("ihbarId")),rs.getDate("olayTarihi"));
            liste.add(a);
        }
        
        return liste;
    } 
      public olayEntity bul(int id) throws SQLException{
       olayEntity a=null;
            olayTipiDao olaytipi=new olayTipiDao();
         adresDao adres=new adresDao();
         ihbarDao ihbar=new ihbarDao();
        PreparedStatement st=con.prepareStatement("select * from olay where olayId=?");
        st.setString(1, ""+id);
        ResultSet rs=st.executeQuery();
        rs.next();
        a=new olayEntity(rs.getInt("olayId"),rs.getInt("oluSayisi"),rs.getInt("yaraliSayisi"),olaytipi.bul(rs.getInt("olayTipiId")),adres.bul(rs.getInt("adresId")),ihbar.bul(rs.getInt("ihbarId")),rs.getDate("olayTarihi"));
       
       return a;
   }  
     public void ekle(olayEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("INSERT INTO olay ( oluSayisi,yaraliSayisi,olayTipiId,adresId,ihbarId,olayTarihi)VALUES (?,?,?,?,?,?)");
         java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(a.getOlayTarihi());
         st.setInt(1,a.getOluSayisi());
         st.setInt(2, a.getYaraliSayisi());
         st.setInt(3,a.getOlayTipi().getOlayTipiId());
         st.setInt(4,a.getAdres().getAdresId());
         st.setInt(5, a.getIhbar().getIhbarId());
         st.setString(6, currentTime);
         st.executeUpdate();
    }
         public void create(olayEntity a) throws SQLException{
       PreparedStatement st2=con.prepareStatement("INSERT INTO adres (acikAdres, caddeId)VALUES ( ?, ?)",Statement.RETURN_GENERATED_KEYS);
         st2.setString(1, a.getAdres().getAcikAdres());
         st2.setInt(2,a.getAdres().getCadde().getCaddeId());
       
         st2.executeUpdate();
             ResultSet gk=st2.getGeneratedKeys();
             int adresid;
             gk.next();
             adresid=gk.getInt(1);
           PreparedStatement st3=con.prepareStatement("INSERT INTO ihbar ( calisanId,tcNo)VALUES (?,?)",Statement.RETURN_GENERATED_KEYS);
        
         st3.setInt(1,a.getIhbar().getCalisan().getCalisanId());
 
         st3.setString(2, a.getIhbar().getVatandas().getTcNo());
       
         st3.executeUpdate();
             ResultSet gk1=st3.getGeneratedKeys();
             int ihbarid;
             gk1.next();
             ihbarid=gk1.getInt(1);
                 
             
         PreparedStatement st=con.prepareStatement("INSERT INTO olay ( oluSayisi,yaraliSayisi,olayTipiId,adresId,ihbarId,olayTarihi)VALUES (?,?,?,?,?,?)");
         java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(a.getOlayTarihi());
         st.setInt(1,a.getOluSayisi());
         st.setInt(2, a.getYaraliSayisi());
         st.setInt(3,a.getOlayTipi().getOlayTipiId());
         st.setInt(4,adresid);
         st.setInt(5, ihbarid);
         st.setString(6, currentTime);
         st.executeUpdate();
    }
        public void sil(olayEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("delete from olay where olayId=?");
         st.setString(1, ""+a.getOlayId());
         st.executeUpdate();
        
    }
     public void guncelle(olayEntity a) throws SQLException{
          PreparedStatement st=con.prepareStatement("update olay set oluSayisi=?,yaraliSayisi=?,olayTipiId=?,adresId=?,ihbarId=?,olayTarihi=? where olayId=?");
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(a.getOlayTarihi());
          
          st.setInt(1,a.getOluSayisi());
         st.setInt(2, a.getYaraliSayisi());
         st.setInt(3,a.getOlayTipi().getOlayTipiId());
         st.setInt(4,a.getAdres().getAdresId());
         st.setInt(5, a.getIhbar().getIhbarId());
         st.setString(6, currentTime);
         st.setInt(7,a.getOlayId());
         st.executeUpdate();
     }   
     
}
