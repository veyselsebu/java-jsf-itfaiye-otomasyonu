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
public class ekipEntity {
    private int ekipId;
    private String ekipAdi,aciklama;

    public int getEkipId() {
        return ekipId;
    }

    public ekipEntity() {
    }

    public ekipEntity(int ekipId, String ekipAdi, String aciklama) {
        this.ekipId = ekipId;
        this.ekipAdi = ekipAdi;
        this.aciklama = aciklama;
    }

    public void setEkipId(int ekipId) {
        this.ekipId = ekipId;
    }

    public String getEkipAdi() {
        return ekipAdi;
    }

    public void setEkipAdi(String ekipAdi) {
        this.ekipAdi = ekipAdi;
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
        hash = 29 * hash + this.ekipId;
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
        final ekipEntity other = (ekipEntity) obj;
        if (this.ekipId != other.ekipId) {
            return false;
        }
        return true;
    }
    
    
}
