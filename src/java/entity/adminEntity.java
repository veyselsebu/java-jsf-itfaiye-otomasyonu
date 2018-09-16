/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author veysels
 */
@ManagedBean
@RequestScoped
public class adminEntity {
    private String kullaniciAdi;
    private String sifre;
    private adminYetkiEntity adminYetki;
    public adminEntity() {
    }

    public adminEntity(String kullaniciAdi, String sifre, adminYetkiEntity adminYetki) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.adminYetki = adminYetki;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
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
