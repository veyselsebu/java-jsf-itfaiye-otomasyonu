/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


import java.util.Date;

/**
 *
 * @author veysels
 */
public class vatandasEntity {
    
    private String tcNo,ad,soyad,telefonNumarasi;
    private cinsiyetEntity cinsiyet;
    private Date dogumTarihi;
    public vatandasEntity() {
    }

    public vatandasEntity(String tcNo, String ad, String soyad, String telefonNumarasi, cinsiyetEntity cinsiyet, Date dogumTarihi) {
        this.tcNo = tcNo;
        this.ad = ad;
        this.soyad = soyad;
        this.telefonNumarasi = telefonNumarasi;
        this.cinsiyet = cinsiyet;
        this.dogumTarihi = dogumTarihi;
    }

    
 

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getTelefonNumarasi() {
        return telefonNumarasi;
    }

    public void setTelefonNumarasi(String telefonNumarasi) {
        this.telefonNumarasi = telefonNumarasi;
    }

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public cinsiyetEntity getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(cinsiyetEntity cinsiyet) {
        this.cinsiyet = cinsiyet;
    }
    
    
}
