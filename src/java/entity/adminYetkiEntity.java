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
public class adminYetkiEntity {
    private int adminYetkiId;
    private boolean ekleme;
    private boolean silme;
    private boolean guncelleme;
    private String ad;
    
    public adminYetkiEntity() {
    }

    public adminYetkiEntity(int adminYetkiId, boolean ekleme, boolean silme, boolean guncelleme, String ad) {
        this.adminYetkiId = adminYetkiId;
        this.ekleme = ekleme;
        this.silme = silme;
        this.guncelleme = guncelleme;
        this.ad = ad;
    }

    public int getAdminYetkiId() {
        return adminYetkiId;
    }

    public void setAdminYetkiId(int adminYetkiId) {
        this.adminYetkiId = adminYetkiId;
    }

    public boolean getEkleme() {
        return ekleme;
    }

    public void setEkleme(boolean ekleme) {
        this.ekleme = ekleme;
    }

    public boolean getSilme() {
        return silme;
    }

    public void setSilme(boolean silme) {
        this.silme = silme;
    }

    public boolean getGuncelleme() {
        return guncelleme;
    }

    public void setGuncelleme(boolean guncelleme) {
        this.guncelleme = guncelleme;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.adminYetkiId;
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
        final adminYetkiEntity other = (adminYetkiEntity) obj;
        if (this.adminYetkiId != other.adminYetkiId) {
            return false;
        }
        return true;
    }
    
}
