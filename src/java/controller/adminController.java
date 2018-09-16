/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.adminDao;
import entity.adminEntity;
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
@ManagedBean(name="admin")
@SessionScoped
public class adminController implements Serializable {
    adminEntity admin;
    adminDao admindao;
    public adminController() throws SQLException {
        admindao=new adminDao();
    }
  public String temzile() throws SQLException{
          admin=null;
        return "/admin/admin/listele?faces-redirect=true";
    }
    public String ekle() throws SQLException{
        admindao.create(admin);
        admin=null;
        return "/admin/admin/listele?faces-redirect=true";
    }
    public String sil(adminEntity a) throws SQLException{
        
    admindao.delete(a);
        return "/admin/admin/listele?faces-redirect=true";

    }
     public String guncelle(adminEntity a){
     admin=a;
        return "/admin/admin/listele?faces-redirect=true";

    }
    public String guncelleKaydet() throws SQLException{
        admindao.update(admin);
        admin=null;
        return "/admin/admin/listele?faces-redirect=true";

    }
    public ArrayList<adminEntity> listele() throws SQLException{
      return admindao.list();
    }
    
    
    
    
    
    
    
    public adminEntity getAdmin() {
        if(admin==null)
            admin=new adminEntity();
        return admin;
    }

    public void setAdmin(adminEntity admin) {
        this.admin = admin;
    }

    public adminDao getAdmindao() {
        return admindao;
    }

    public void setAdmindao(adminDao admindao) {
        this.admindao = admindao;
    }
   
     
    
    
}
