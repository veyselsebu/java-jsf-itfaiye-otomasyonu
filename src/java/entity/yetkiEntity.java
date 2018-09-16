/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author veysels
 */
public class yetkiEntity {
    private int yetkiId;
    private String yetkiAd,aciklama;

    public yetkiEntity(int yetkiId, String yetkiAd, String aciklama) {
        this.yetkiId = yetkiId;
        this.yetkiAd = yetkiAd;
        this.aciklama = aciklama;
    }

    public yetkiEntity() {
        
    }

    public int getYetkiId() {
        return yetkiId;
    }

    public void setYetkiId(int yetkiId) {
        this.yetkiId = yetkiId;
    }

    public String getYetkiAd() {
        return yetkiAd;
    }

    public void setYetkiAd(String yetkiAd) {
        this.yetkiAd = yetkiAd;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.yetkiId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final yetkiEntity other = (yetkiEntity) obj;
        if (this.yetkiId != other.yetkiId) {
            return false;
        }
        return true;
    }
    
}
