/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.aracEntity;
import entity.calisanEntity;
import java.io.IOException;
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
import javax.servlet.http.Part;
import util.DBconnection;

/**
 *
 * @author veysels
 */
@ManagedBean
@RequestScoped
public class calisanDao {

 
    DBconnection db;
    Connection con;
   
    
    public calisanDao() {
         db=new DBconnection();
        try {
            con=db.GetConnection();
        } catch (SQLException ex) {
            Logger.getLogger(calisanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public ArrayList<calisanEntity> getlistele() throws SQLException{
          vatandasDao dav=new vatandasDao();  
          ekipDao ek=new ekipDao();
          meslekDao mes=new meslekDao();
          resimDao resim=new resimDao();
        PreparedStatement st=con.prepareStatement("select * from calisan");
        ResultSet rs=st.executeQuery();
          ArrayList<calisanEntity> liste=new ArrayList<>();
        while(rs.next()){
                     
            calisanEntity a=new calisanEntity(rs.getInt("calisanId"),ek.bul(rs.getInt("ekipId")),mes.bul(rs.getInt("meslekId")),resim.bul(rs.getInt("resimId")),dav.bul(rs.getString("tcNo")));
            liste.add(a);
        }
        
        return liste;
    } 
     public calisanEntity bul (int id) throws SQLException{
        calisanEntity calisanim = null;
          vatandasDao dav=new vatandasDao(); 
          ekipDao ekip=new ekipDao();
          meslekDao meslek=new meslekDao();
          resimDao resim=new resimDao();
        PreparedStatement st=con.prepareStatement("select * from calisan where calisanId=?");
        st.setInt(1, id);
        ResultSet rs=st.executeQuery();
        rs.next();
        calisanim=new calisanEntity(rs.getInt("calisanId"),ekip.bul(rs.getInt("ekipId")),meslek.bul(rs.getInt("meslekId")),resim.bul(rs.getInt("resimId")),dav.bul(rs.getString("tcNo")));
        return calisanim;
     }
     
     public void ekle(calisanEntity a) throws SQLException, IOException{
         if(a.getResim().getDosya()==null){
             
         PreparedStatement st=con.prepareStatement("INSERT INTO calisan ( ekipId,meslekId,resimId,tcNo)VALUES (?,?,?,?)");
        
         st.setInt(1,a.getEkip().getEkipId());
         st.setInt(2, a.getMeslek().getMeslekId());
         st.setInt(3,1);
         st.setString(4, a.getVatandas().getTcNo());
         st.executeUpdate();
         }else{
             a.getResim().getDosya().write("C:\\Users\\veysels\\Documents\\NetBeansProjects\\itfaiye\\resim\\"+a.getCalisanId()+resIsim(a.getResim().getDosya()));
             String resimUz="C:\\Users\\veysels\\Documents\\NetBeansProjects\\itfaiye\\resim\\"+a.getCalisanId()+resIsim(a.getResim().getDosya());
                PreparedStatement st2=con.prepareStatement("INSERT INTO resim (dosyaUzantisi)VALUES (?)",Statement.RETURN_GENERATED_KEYS);        
         st2.setString(1,resimUz);
         st2.executeUpdate();
             ResultSet gk=st2.getGeneratedKeys();
             int id;
             gk.next();
             id=gk.getInt(1);
             
             PreparedStatement st=con.prepareStatement("INSERT INTO calisan ( ekipId,meslekId,resimId,tcNo)VALUES (?,?,?,?)");
        
             
         st.setInt(1,a.getEkip().getEkipId());
         st.setInt(2, a.getMeslek().getMeslekId());
         st.setInt(3,id);
         st.setString(4, a.getVatandas().getTcNo());
         st.executeUpdate();
         }
    }
        public void sil(calisanEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("delete from calisan where calisanId=?");
         st.setString(1, ""+a.getCalisanId());
         st.executeUpdate();
        
    }
           public void resimguncelle(calisanEntity a) throws SQLException, IOException{
               if(a.getResim().getDosya()!=null){
                 a.getResim().getDosya().write("C:\\Users\\veysels\\Documents\\NetBeansProjects\\itfaiye\\resim\\"+a.getCalisanId()+resIsim(a.getResim().getDosya()));
             String resimUz="C:\\Users\\veysels\\Documents\\NetBeansProjects\\itfaiye\\resim\\"+a.getCalisanId()+resIsim(a.getResim().getDosya());
                PreparedStatement st2=con.prepareStatement("INSERT INTO resim (dosyaUzantisi)VALUES (?)",Statement.RETURN_GENERATED_KEYS);        
         st2.setString(1,resimUz);
         st2.executeUpdate();
             ResultSet gk=st2.getGeneratedKeys();
             int id;
             gk.next();
             id=gk.getInt(1);
               
          PreparedStatement st=con.prepareStatement("update calisan set resimId=? where calisanId=?");
         st.setInt(1,id);
         st.setInt(2, a.getCalisanId());
       
         st.executeUpdate();
               }
     } 
     public void guncelle(calisanEntity a) throws SQLException{
          PreparedStatement st=con.prepareStatement("update calisan set ekipId=?,meslekId=?,tcNo=? where calisanId=?");
         st.setInt(1,a.getEkip().getEkipId());
         st.setInt(2, a.getMeslek().getMeslekId());
       
         st.setString(4, a.getVatandas().getTcNo());
         st.setInt(5, a.getCalisanId());
         st.executeUpdate();
     }   
      public String resIsim(Part part)
    {
         String filename=null;
        for(String cd:part.getHeader("content-disposition").split(";"))
            if(cd.trim().startsWith("filename")){
               filename=cd.substring(cd.indexOf('=')+1).trim().replace("\"", "");
               
            }
        
 
   System.out.println("adres = " +filename);
   	int index = filename.lastIndexOf("\\");
      String isim=filename.substring(index + 1);
      return isim;
    }
     
}
