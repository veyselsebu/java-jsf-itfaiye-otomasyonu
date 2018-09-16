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
public class ilceEntity {
   private int ilceId;
    private String ilceAdi;

    public ilceEntity() {
    }

    public ilceEntity(int ilceId, String ilceAdi) {
        this.ilceId = ilceId;
        this.ilceAdi = ilceAdi;
    }

    public int getIlceId() {
        return ilceId;
    }

    public void setIlceId(int ilceId) {
        this.ilceId = ilceId;
    }

    public String getIlceAdi() {
        return ilceAdi;
    }

    public void setIlceAdi(String ilceAdi) {
        this.ilceAdi = ilceAdi;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.ilceId;
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
        final ilceEntity other = (ilceEntity) obj;
        if (this.ilceId != other.ilceId) {
            return false;
        }
        return true;
    }
  



}
