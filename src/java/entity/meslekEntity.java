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
public class meslekEntity {
    private int meslekId;
    private String meslekAdi,aciklama;

    public int getMeslekId() {
        return meslekId;
    }

    public void setMeslekId(int meslekId) {
        this.meslekId = meslekId;
    }

    public meslekEntity() {
    }

    public meslekEntity(int meslekId, String meslekAdi, String aciklama) {
        this.meslekId = meslekId;
        this.meslekAdi = meslekAdi;
        this.aciklama = aciklama;
    }

    public String getMeslekAdi() {
        return meslekAdi;
    }

    public void setMeslekAdi(String meslekAdi) {
        this.meslekAdi = meslekAdi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.meslekId;
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
        final meslekEntity other = (meslekEntity) obj;
        if (this.meslekId != other.meslekId) {
            return false;
        }
        return true;
    }
    
}
