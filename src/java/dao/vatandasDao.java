/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class vatandasDao {

    DBconnection db;
    Connection con;
    cinsiyetDao cinsiyetim =new cinsiyetDao();
    
    public vatandasDao() {
         db=new DBconnection();
        try {
            con=db.GetConnection();
        } catch (SQLException ex) {
            Logger.getLogger(vatandasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public ArrayList<vatandasEntity> getlistele() throws SQLException{
        PreparedStatement st=con.prepareStatement("select * from vatandas");
        ResultSet rs=st.executeQuery();
          ArrayList<vatandasEntity> liste=new ArrayList<>();
        while(rs.next()){
            vatandasEntity a=new vatandasEntity(rs.getString("tcNo"),rs.getString("isim"),rs.getString("soyIsim"),rs.getString("telefonNumarasi"),cinsiyetim.bul(rs.getInt("cinsiyetId")),rs.getDate("dogumTarihi"));
            liste.add(a);
        }
        
        return liste;
    }   
     public void ekle(vatandasEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("INSERT INTO vatandas (tcNo,isim,soyIsim,telefonNumarasi,cinsiyetId,dogumTarihi )VALUES (?,?,?,?,?,?)");
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(a.getDogumTarihi());
         st.setString(1,a.getTcNo());
         st.setString(2, a.getAd());
         st.setString(3,a.getSoyad());
         st.setString(4,a.getTelefonNumarasi());
         st.setInt(5, a.getCinsiyet().getCinsiyetId());
         st.setString(6, currentTime);
         st.executeUpdate();
    }
     
     public vatandasEntity bul(String tc) throws SQLException{
        vatandasEntity calisanim = null;
        PreparedStatement st=con.prepareStatement("select * from vatandas where tcNo=?");
        st.setString(1, tc);
        ResultSet rs=st.executeQuery();
        rs.next();
        calisanim=new vatandasEntity(rs.getString("tcNo"),rs.getString("isim"),rs.getString("soyIsim"),rs.getString("telefonNumarasi"),cinsiyetim.bul(rs.getInt("cinsiyetId")),rs.getDate("dogumTarihi"));
        return calisanim;
         
     }
        public void sil(vatandasEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("delete from vatandas where tcNo=?");
         st.setString(1, ""+a.getTcNo());
         st.executeUpdate();
        
    }
     public void guncelle(vatandasEntity a) throws SQLException{
          PreparedStatement st=con.prepareStatement("update vatandas set isim=?,soyIsim=?,telefonNumarasi=?,cinsiyetId=?,dogumTarihi=? where tcNo=?");
          java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(a.getDogumTarihi());
         st.setString(1, a.getAd());
         st.setString(2,a.getSoyad());
         st.setString(3,a.getTelefonNumarasi());
         st.setInt(4, a.getCinsiyet().getCinsiyetId());
         st.setString(5, currentTime);
         st.setString(6,a.getTcNo());
         st.executeUpdate();
     }   

    public cinsiyetDao getCinsiyetim() {
        return cinsiyetim;
    }

    public void setCinsiyetim(cinsiyetDao cinsiyetim) {
        this.cinsiyetim = cinsiyetim;
    }
     
}
