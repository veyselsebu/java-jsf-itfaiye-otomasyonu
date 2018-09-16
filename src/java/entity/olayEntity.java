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
public class olayEntity {
    private int olayId,oluSayisi,yaraliSayisi;
    private olaytipiEntity olayTipi;
    private adresEntity adres;
    private ihbarEntity ihbar;
     private Date olayTarihi;
    public olayEntity() {
    }

    public olayEntity(int olayId, int oluSayisi, int yaraliSayisi, olaytipiEntity olayTipi, adresEntity adres, ihbarEntity ihbar, Date olayTarihi) {
        this.olayId = olayId;
        this.oluSayisi = oluSayisi;
        this.yaraliSayisi = yaraliSayisi;
        this.olayTipi = olayTipi;
        this.adres = adres;
        this.ihbar = ihbar;
        this.olayTarihi = olayTarihi;
    }

 

   

    public int getOlayId() {
        return olayId;
    }

    public void setOlayId(int olayId) {
        this.olayId = olayId;
    }

    public int getOluSayisi() {
        return oluSayisi;
    }

    public void setOluSayisi(int oluSayisi) {
        this.oluSayisi = oluSayisi;
    }

    public int getYaraliSayisi() {
        return yaraliSayisi;
    }

    public void setYaraliSayisi(int yaraliSayisi) {
        this.yaraliSayisi = yaraliSayisi;
    }

  

    public olaytipiEntity getOlayTipi() {
        return olayTipi;
    }

    public void setOlayTipi(olaytipiEntity olayTipi) {
        this.olayTipi = olayTipi;
    }

    public adresEntity getAdres() {
       
        if(adres==null)
       adres=new adresEntity();     
        return adres;
    }

    public void setAdres(adresEntity adres) {
        this.adres = adres;
    }

    public ihbarEntity getIhbar() {
        if(ihbar==null)
        ihbar=new ihbarEntity();
            return ihbar;
    }

    public void setIhbar(ihbarEntity ihbar) {
        this.ihbar = ihbar;
    }

    public Date getOlayTarihi() {
        return olayTarihi;
    }

    public void setOlayTarihi(Date olayTarihi) {
        this.olayTarihi = olayTarihi;
    }
}
