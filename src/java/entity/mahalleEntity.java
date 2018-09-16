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
public class mahalleEntity {
    private int mahalleId;
    private String mahalleAdi;
    private ilceEntity ilce;

    public mahalleEntity(int mahalleId, String mahalleAdi, ilceEntity ilce) {
        this.mahalleId = mahalleId;
        this.mahalleAdi = mahalleAdi;
        this.ilce = ilce;
    }

    public ilceEntity getIlce() {
        return ilce;
    }

    public void setIlce(ilceEntity ilce) {
        this.ilce = ilce;
    }

    public int getMahalleId() {
        return mahalleId;
    }

    public mahalleEntity() {
    }
    public void setMahalleId(int mahalleId) {
        this.mahalleId = mahalleId;
    }
    public String getMahalleAdi() {
        return mahalleAdi;
    }

    public void setMahalleAdi(String mahalleAdi) {
        this.mahalleAdi = mahalleAdi;
    }
    
}
