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
public class ekipmanEntity {
    private int ekimanId;
    private String ekipmanAdi,icerik,kullanimAlani;

    public ekipmanEntity() {
    }

    public ekipmanEntity(int ekimanId, String ekipmanAdi, String icerik, String kullanimAlani) {
        this.ekimanId = ekimanId;
        this.ekipmanAdi = ekipmanAdi;
        this.icerik = icerik;
        this.kullanimAlani = kullanimAlani;
    }

    public int getEkimanId() {
        return ekimanId;
    }

    public void setEkimanId(int ekimanId) {
        this.ekimanId = ekimanId;
    }

    public String getEkipmanAdi() {
        return ekipmanAdi;
    }

    public void setEkipmanAdi(String ekipmanAdi) {
        this.ekipmanAdi = ekipmanAdi;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getKullanimAlani() {
        return kullanimAlani;
    }

    public void setKullanimAlani(String kullanimAlani) {
        this.kullanimAlani = kullanimAlani;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.ekimanId;
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
        final ekipmanEntity other = (ekipmanEntity) obj;
        if (this.ekimanId != other.ekimanId) {
            return false;
        }
        return true;
    }
    
}
