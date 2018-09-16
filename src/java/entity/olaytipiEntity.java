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
public class olaytipiEntity {
    private int olayTipiId;
    private String olayTipiAdi,aciklama;

    public int getOlayTipiId() {
        return olayTipiId;
    }

    public olaytipiEntity() {
    }

    public olaytipiEntity(int olayTipiId, String olayTipiAdi, String aciklama) {
        this.olayTipiId = olayTipiId;
        this.olayTipiAdi = olayTipiAdi;
        this.aciklama = aciklama;
    }

    public void setOlayTipiId(int olayTipiId) {
        this.olayTipiId = olayTipiId;
    }

    public String getOlayTipiAdi() {
        return olayTipiAdi;
    }

    public void setOlayTipiAdi(String olayTipiAdi) {
        this.olayTipiAdi = olayTipiAdi;
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
        hash = 43 * hash + this.olayTipiId;
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
        final olaytipiEntity other = (olaytipiEntity) obj;
        if (this.olayTipiId != other.olayTipiId) {
            return false;
        }
        return true;
    }
    
}
