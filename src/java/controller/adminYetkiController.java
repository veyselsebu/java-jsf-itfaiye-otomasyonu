/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.adminYetkiDao;
import entity.adminYetkiEntity;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author veysels
 */
@ManagedBean(name="adminYetki")
@SessionScoped
public class adminYetkiController implements Serializable {
   adminYetkiDao adminYetkidao=new adminYetkiDao();
   adminYetkiEntity adminYetki;
    
   public String ekleme() throws SQLException{

       adminYetkidao.create(adminYetki);
       adminYetki=null;
       return "/admin/adminYetki/listele?faces-redirect=true";
       
   }
  public String guncelle(adminYetkiEntity a){
      adminYetki=a;
      
      return "/admin/adminYetki/listele?faces-redirect=true";
      
  }
  public String guncelleKaydet() throws SQLException{
      adminYetkidao.update(adminYetki);
      adminYetki=null;
      return "/admin/adminYetki/listele?faces-redirect=true";

  }
   public ArrayList<adminYetkiEntity> listele() throws SQLException
   {
    return adminYetkidao.list();
   }   
   public String silme(adminYetkiEntity a) throws SQLException{
       adminYetkidao.delete(a);
      return "/admin/adminYetki/listele?faces-redirect=true";
   }
   
   
    
    
    public adminYetkiController() {
    }

    public adminYetkiDao getAdminYetkidao() {
        if(adminYetkidao==null)
            adminYetkidao=new adminYetkiDao();
        return adminYetkidao;
    }

    public void setAdminYetkidao(adminYetkiDao adminYetkidao) {
        this.adminYetkidao = adminYetkidao;
    }

    public adminYetkiEntity getAdminYetki() {
        if(adminYetki==null)
            adminYetki=new adminYetkiEntity();
        return adminYetki;
    }

    public void setAdminYetki(adminYetkiEntity adminYetki) {
        this.adminYetki = adminYetki;
    }
    
}
