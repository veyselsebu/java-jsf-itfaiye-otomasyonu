/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.adminDao;
import entity.adminEntity;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author veysels
 */
@ManagedBean
@SessionScoped
public class adminLoginController implements Serializable {
    adminEntity admin1;
    adminEntity admin2;
    
    
    
    
    public String login() throws SQLException{
        adminDao ad=new adminDao();
        admin2=ad.find(admin1.getKullaniciAdi());
        if(admin2!=null){
        if(admin2.getSifre().equals(admin1.getSifre())){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_admin", admin2);
           return "/admin/admin?faces-redirect=true";  
        }
        else
        {
             admin2=null;
             FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("hatalı şifre"));
            return "/admin/login?faces-redirect=true";  

        }
        }else{
            admin2=null;
             FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("böyle bir kullanıcı adı bulunamadı"));
            return "/admin/login?faces-redirect=true";   
        }
        
    }
    public String cik(){
        admin2=null;
       return "/logout?faces-redirect=true";  

        
    }
    
    
    public adminLoginController() {
    }

    public adminEntity getAdmin1() {
        if(admin1==null)
            admin1=new adminEntity();
        return admin1;
    }

    public void setAdmin1(adminEntity admin1) {
        this.admin1 = admin1;
    }

    public adminEntity getAdmin2() {
    
        return admin2;
    }

    public void setAdmin2(adminEntity admin2) {
        this.admin2 = admin2;
    }
    
}
