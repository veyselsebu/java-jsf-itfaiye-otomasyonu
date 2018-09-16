/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Statement;
import entity.kullaniciEntity;
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
public class kullaniciDao {


    DBconnection db;
    Connection con=null;
   yetkiDao yetkidao;
    
    public kullaniciDao() {
        if(con==null){
         db=new DBconnection();
        try {
            con=db.GetConnection();
        } catch (SQLException ex) {
            Logger.getLogger(kullaniciDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
     public ArrayList<kullaniciEntity> getlistele() throws SQLException{
        yetkidao=new yetkiDao();
        calisanDao calisandao=new calisanDao();
         PreparedStatement st=con.prepareStatement("select * from kullanici");
        ResultSet rs=st.executeQuery();
          ArrayList<kullaniciEntity> liste=new ArrayList<>();
        while(rs.next()){
            
            kullaniciEntity a=new kullaniciEntity(rs.getString("kullaniciAdi"),rs.getString("sifre"), calisandao.bul(rs.getInt("calisanId")),yetkidao.getkullaniciYetkilistele(rs.getString("kullaniciAdi")));
            liste.add(a);
        }
   
        return liste;
    }   
      public ArrayList<kullaniciEntity> findAll(int page , int pageSize) throws SQLException{
        yetkidao=new yetkiDao();
        int start=(page-1)*pageSize;
       
        calisanDao calisandao=new calisanDao();
         PreparedStatement st=con.prepareStatement("select * from kullanici order by kullaniciAdi asc limit "+start+" , "+pageSize);
        ResultSet rs=st.executeQuery();
          ArrayList<kullaniciEntity> liste=new ArrayList<>();
        while(rs.next()){
            
            kullaniciEntity a=new kullaniciEntity(rs.getString("kullaniciAdi"),rs.getString("sifre"), calisandao.bul(rs.getInt("calisanId")),yetkidao.getkullaniciYetkilistele(rs.getString("kullaniciAdi")));
            liste.add(a);
        }
   
        return liste;
    }  
      public int count() throws SQLException{
          int sayi=0;
          PreparedStatement st=con.prepareStatement("SELECT COUNT(*) AS toplam FROM kullanici");
        ResultSet rs=st.executeQuery();
         
        rs.next();
          sayi=rs.getInt("toplam");
          return sayi;
      }
 
      public kullaniciEntity bul(String ıd) throws SQLException{
          kullaniciEntity a=null;
          yetkidao=new yetkiDao();
        calisanDao calisandao=new calisanDao();
         PreparedStatement st=con.prepareStatement("select * from kullanici where kullaniciAdi=?");
         st.setString(1, ıd);
        ResultSet rs=st.executeQuery();
       if( rs.next())
         a=new kullaniciEntity(rs.getString("kullaniciAdi"),rs.getString("sifre"), calisandao.bul(rs.getInt("calisanId")),yetkidao.getkullaniciYetkilistele(rs.getString("kullaniciAdi")));
       
       
       return a;
     }
     public void ekle(kullaniciEntity a) throws SQLException{
       
         PreparedStatement st=con.prepareStatement("INSERT INTO kullanici ( kullaniciAdi,sifre,calisanId)VALUES (?,?,?)");
        
         st.setString(1,a.getKullaniciAdi());
         st.setString(2, a.getSifre());
         st.setInt(3,a.getCalisan().getCalisanId());
         st.executeUpdate();
         for(int i=0;i<a.getKullaniciYetkileri().size();i++){

                PreparedStatement st2=con.prepareStatement("INSERT INTO kullaniciyetki ( kullanciAdi,yetkiId)VALUES (?,?)");
                st2.setString(1,a.getKullaniciAdi());
                st2.setInt(2, a.getKullaniciYetkileri().get(i).getYetkiId());
                st2.executeUpdate();
         }
   
    }
        public void sil(kullaniciEntity a) throws SQLException{
             PreparedStatement st1=con.prepareStatement("delete from kullaniciyetki where kullanciAdi=?");
         st1.setString(1, ""+a.getKullaniciAdi());
         st1.executeUpdate();
         PreparedStatement st=con.prepareStatement("delete from kullanici where kullaniciAdi=?");
         st.setString(1, ""+a.getKullaniciAdi());
         st.executeUpdate();
        
    }
     public void guncelle(kullaniciEntity a) throws SQLException{
          PreparedStatement st=con.prepareStatement("update kullanici set sifre=?,calisanId=? where kullaniciAdi=?");
         st.setString(1,a.getSifre());
         st.setInt(2, a.getCalisan().getCalisanId());
         st.setString(3, a.getKullaniciAdi());  
         st.executeUpdate();
         PreparedStatement st2=con.prepareStatement("delete from kullaniciyetki where kullanciAdi=?");
         st2.setString(1, ""+a.getKullaniciAdi());
         st2.executeUpdate();
          for(int i=0;i<a.getKullaniciYetkileri().size();i++){

                PreparedStatement st3=con.prepareStatement("INSERT INTO kullaniciyetki ( kullanciAdi,yetkiId)VALUES (?,?)");
                st3.setString(1,a.getKullaniciAdi());
                st3.setInt(2, a.getKullaniciYetkileri().get(i).getYetkiId());
                st3.executeUpdate();
         }
         
     }  
     public void sifreGuncelle(kullaniciEntity kul) throws SQLException{
         PreparedStatement st=con.prepareStatement("update kullanici set sifre=? where kullaniciAdi=?");
          st.setString(1,kul.getSifre());
          st.setString(2, kul.getKullaniciAdi());  
          st.executeUpdate();
     }
     
     
}
