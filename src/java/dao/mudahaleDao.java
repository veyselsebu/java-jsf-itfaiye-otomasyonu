/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.mudahaleEntity;
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
public class mudahaleDao {

 
    DBconnection db;
    Connection con;
   
    
    public mudahaleDao() {
         db=new DBconnection();
        try {
            con=db.GetConnection();
        } catch (SQLException ex) {
            Logger.getLogger(mudahaleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public ArrayList<mudahaleEntity> getlistele() throws SQLException{
         ekipmanDao ekipmand=new ekipmanDao();
         olayDao olayd=new olayDao();
         ekipDao ekipd=new ekipDao();
        PreparedStatement st=con.prepareStatement("select * from mudahale");
        ResultSet rs=st.executeQuery();
          ArrayList<mudahaleEntity> liste=new ArrayList<>();
        while(rs.next()){
            mudahaleEntity a=new mudahaleEntity(rs.getInt("mudahaleId"),ekipmand.bul(rs.getInt("ekipmanId")),olayd.bul(rs.getInt("olayId")),ekipd.bul(rs.getInt("ekipId")),rs.getString("aracPlaka"));
            liste.add(a);
        }
        
        return liste;
    }   
     public void ekle(mudahaleEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("INSERT INTO mudahale ( ekipmanId,olayId,ekipId,aracPlaka)VALUES (?,?,?,?)");
        
         st.setInt(1,a.getEkipman().getEkimanId());
         st.setInt(2, a.getOlayId());
         st.setInt(3,a.getEkip().getEkipId());
         st.setString(4, a.getPlaka());
         st.executeUpdate();
    }
        public void sil(mudahaleEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("delete from mudahale where mudahaleId=?");
         st.setString(1, ""+a.getMudahaleId());
         st.executeUpdate();
        
    }
     public void guncelle(mudahaleEntity a) throws SQLException{
          PreparedStatement st=con.prepareStatement("update mudahale set ekipmanId=?,olayId=?,ekipId=?,aracPlaka=? where mudahaleId=?");
         st.setInt(1,a.getEkipman().getEkimanId());
         st.setInt(2, a.getOlay().getOlayId());
         st.setInt(3,a.getEkip().getEkipId());
         st.setString(4, a.getPlaka());
         st.setInt(5,a.getMudahaleId());
         st.executeUpdate();
     }   
     
}
