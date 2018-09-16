/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author veysels
 */
public class kullaniciEntity {
    private String kullaniciAdi,sifre;
    private calisanEntity calisan;
    private ArrayList<yetkiEntity>kullaniciYetkileri;

    public kullaniciEntity(String kullaniciAdi, String sifre, calisanEntity calisan, ArrayList<yetkiEntity> kullaniciYetkileri) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.calisan = calisan;
        this.kullaniciYetkileri = kullaniciYetkileri;
    }
   
 
    public kullaniciEntity() {
    }

    public calisanEntity getCalisan() {
        if(calisan==null)
        calisan=new calisanEntity();
        return calisan;
    }

    public void setCalisan(calisanEntity calisan) {
        this.calisan = calisan;
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

    

    public ArrayList<yetkiEntity> getKullaniciYetkileri() {
        return kullaniciYetkileri;
    }

    public void setKullaniciYetkileri(ArrayList<yetkiEntity> kullaniciYetkileri) {
        this.kullaniciYetkileri = kullaniciYetkileri;
    }
    
}
