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
public class cinsiyetEntity {
    private int cinsiyetId;
    private String cinsiyetAdi;

    public cinsiyetEntity() {
    }

    public cinsiyetEntity(int cinsiyetId, String cinsiyetAdi) {
        this.cinsiyetId = cinsiyetId;
        this.cinsiyetAdi = cinsiyetAdi;
    }

    public int getCinsiyetId() {
        return cinsiyetId;
    }

    public void setCinsiyetId(int cinsiyetId) {
        this.cinsiyetId = cinsiyetId;
    }

    public String getCinsiyetAdi() {
        return cinsiyetAdi;
    }

    public void setCinsiyetAdi(String cinsiyetAdi) {
        this.cinsiyetAdi = cinsiyetAdi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.cinsiyetId;
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
        final cinsiyetEntity other = (cinsiyetEntity) obj;
        if (this.cinsiyetId != other.cinsiyetId) {
            return false;
        }
        return true;
    }
    
}
