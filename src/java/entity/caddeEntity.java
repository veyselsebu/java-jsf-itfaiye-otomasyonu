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
public class caddeEntity {
   private int caddeId;
   private int mahalleId;
   private mahalleEntity mahalle; 
   private String caddeAdi;

    public int getCaddeId() {
        return caddeId;
    }

    public caddeEntity() {
    }

    public caddeEntity(int caddeId, mahalleEntity mahalle, String caddeAdi) {
        this.caddeId = caddeId;
        this.mahalle = mahalle;
        this.caddeAdi = caddeAdi;
    }

    public caddeEntity(int caddeId, int mahalleId, String caddeAdi) {
        this.caddeId = caddeId;
        this.mahalleId = mahalleId;
        this.caddeAdi = caddeAdi;
    }

    public void setCaddeId(int caddeId) {
        this.caddeId = caddeId;
    }

    public int getMahalleId() {
        return mahalleId;
    }

    public void setMahalleId(int mahalleId) {
        this.mahalleId = mahalleId;
    }

    public String getCaddeAdi() {
        return caddeAdi;
    }

    public void setCaddeAdi(String caddeAdi) {
        this.caddeAdi = caddeAdi;
    }

    public mahalleEntity getMahalle() {
        return mahalle;
    }

    public void setMahalle(mahalleEntity mahalle) {
        this.mahalle = mahalle;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.caddeId;
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
        final caddeEntity other = (caddeEntity) obj;
        if (this.caddeId != other.caddeId) {
            return false;
        }
        return true;
    }
    
}
