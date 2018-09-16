/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.adminEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import util.DBconnection;

/**
 *
 * @author veysels
 */
@ManagedBean
@RequestScoped
public class adminDao {
    DBconnection db;
    Connection con;
  
    public adminDao() throws SQLException {
    db=new DBconnection();
    con=db.GetConnection();
    }
    public void create(adminEntity a) throws SQLException{
         PreparedStatement st=con.prepareStatement("insert into admin(kullaniciAdi,sifre,adminYetkiId) values (?,?,?)");
        st.setString(1, a.getKullaniciAdi());
        st.setString(2, a.getSifre());
        st.setInt(3, a.getAdminYetki().getAdminYetkiId());
        st.executeUpdate();
  
    }
    public void delete(adminEntity a) throws SQLException{
      PreparedStatement st=con.prepareStatement("delete from admin where kullaniciAdi=?");
      st.setString(1, a.getKullaniciAdi());
      st.executeUpdate();
    }
    public adminEntity find (String kullaniciAdi) throws SQLException{
        adminYetkiDao ad=new adminYetkiDao();
        PreparedStatement st=con.prepareStatement("select * from admin where kullaniciAdi=?");
        st.setString(1, kullaniciAdi);
        ResultSet rs=st.executeQuery();
      adminEntity a=null;
        if( rs.next())
        a=new adminEntity(rs.getString("kullaniciAdi"),rs.getString("sifre"),ad.find(rs.getInt("adminYetkiId")));
        
       return a;
    }
    public ArrayList<adminEntity> list() throws SQLException{
        ArrayList<adminEntity> ab=new ArrayList <>();
          adminYetkiDao ad=new adminYetkiDao();
        PreparedStatement st=con.prepareStatement("select * from admin");
       
        ResultSet rs=st.executeQuery();
        while(rs.next()){
        adminEntity a=new adminEntity(rs.getString("kullaniciAdi"),rs.getString("sifre"),ad.find(rs.getInt("adminYetkiId")));
        ab.add(a);
        }
        
        return ab;
    }
    public void update(adminEntity a) throws SQLException{
    
    PreparedStatement st=con.prepareStatement("update admin set sifre=?,adminYetkiId=? where kullaniciAdi=?");
    st.setString(1, a.getSifre());
    st.setInt(2, a.getAdminYetki().getAdminYetkiId());
    st.setString(3, a.getKullaniciAdi());
    st.executeUpdate();
    }
    
}
