/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.olaytipiEntity;
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
public class olayTipiDao {

 

    DBconnection db;
    Connection con;
   
    
    public olayTipiDao() {
         db=new DBconnection();
        try {
            con=db.GetConnection();
        } catch (SQLException ex) {
            Logger.getLogger(olayTipiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public ArrayList<olaytipiEntity> getlistele() throws SQLException{
        PreparedStatement st=con.prepareStatement("select * from olaytipi");
        ResultSet rs=st.executeQuery();
          ArrayList<olaytipiEntity> liste=new ArrayList<>();
        while(rs.next()){
            olaytipiEntity a=new olaytipiEntity(rs.getInt("olayTipiId"),rs.getString("olayTipiAdi"),rs.getString("aciklama"));           liste.add(a);
        }
        
        return liste;
    }   
     public void ekle(olaytipiEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("INSERT INTO olaytipi ( olayTipiAdi,aciklama)VALUES (?,?)");
        
         st.setString(1,a.getOlayTipiAdi());
         st.setString(2, a.getAciklama());
         st.executeUpdate();
    }
        public void sil(olaytipiEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("delete from olaytipi where olayTipiId=?");
         st.setString(1, ""+a.getOlayTipiId());
         st.executeUpdate();
        
    }
          public olaytipiEntity bul (int id) throws SQLException{
        olaytipiEntity olaytipi = null;
         
       PreparedStatement st=con.prepareStatement("select * from olaytipi where olayTipiId=?");
       st.setInt(1, id);
        ResultSet rs=st.executeQuery();
         rs.next();
            olaytipiEntity a=new olaytipiEntity(rs.getInt("olayTipiId"),rs.getString("olayTipiAdi"),rs.getString("aciklama"));
              return a;
     }
     public void guncelle(olaytipiEntity a) throws SQLException{
          PreparedStatement st=con.prepareStatement("update olaytipi set olayTipiAdi=?,aciklama=? where olayTipiId=?");
         st.setString(1,a.getOlayTipiAdi());
         st.setString(2, a.getAciklama());
         st.setInt(3,a.getOlayTipiId());
         st.executeUpdate();
     }   
     
}
