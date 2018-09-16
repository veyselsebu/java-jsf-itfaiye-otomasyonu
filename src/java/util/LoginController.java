/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.kullaniciDao;
import entity.kullaniciEntity;
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
public class LoginController implements Serializable {
       kullaniciEntity kullanici1;
       kullaniciEntity kullanici2;

       public String login() throws SQLException{
           kullaniciDao kd=new kullaniciDao();
           kullanici2=new kullaniciEntity();
           kullanici2=kd.bul(kullanici1.getKullaniciAdi());
           String ad=kullanici2.getKullaniciAdi();
           String sifre=kullanici2.getSifre();
           if(ad.equals(kullanici1.getKullaniciAdi())&&sifre.equals(kullanici1.getSifre())){
               FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", kullanici2);
                    if(kullanici2.getKullaniciYetkileri().get(0).getYetkiId()==5)
                   return "/callcenter/index?faces-redirect=true";
               else if(kullanici2.getKullaniciYetkileri().get(0).getYetkiId()==2)
                    return "/admin/admin?faces-redirect=true";
                else if(kullanici2.getKullaniciYetkileri().get(0).getYetkiId()==1)
                    return "/depoSorumlusu/index?faces-redirect=true";
               else
               return "/guvenli/listele?faces-redirect=true";
           }else
           {    kullanici2=null;
               FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("hatalı kullanici adı yada şifre"));
           return "/login?faces-redirect=true";
           }
       }
       public String cik(){
           kullanici2=null;
           return "/logout?faces-redirect=true";
       }
       
    public kullaniciEntity getKullanici1() {
        if(kullanici1==null)
            kullanici1=new kullaniciEntity();
        return kullanici1;
    }

    public void setKullanici1(kullaniciEntity kullanici1) {
        this.kullanici1 = kullanici1;
    }

    public kullaniciEntity getKullanici2() {
        
          
        return kullanici2;
    }

    public void setKullanici2(kullaniciEntity kullanici2) {
        this.kullanici2 = kullanici2;
    }
  
       
       
       
    
}
