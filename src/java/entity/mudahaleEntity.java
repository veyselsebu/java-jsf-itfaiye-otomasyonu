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
public class mudahaleEntity {
  
    private int mudahaleId, ekipmanId,olayId,ekipId;
    private ekipmanEntity ekipman;
    private olayEntity olay;
    private ekipEntity ekip;
    private String plaka;

    public mudahaleEntity() {
    }

    public mudahaleEntity(int mudahaleId, ekipmanEntity ekipman, olayEntity olay, ekipEntity ekip, String plaka) {
        this.mudahaleId = mudahaleId;
        this.ekipman = ekipman;
        this.olay = olay;
        this.ekip = ekip;
        this.plaka = plaka;
    }

    public mudahaleEntity(int mudahaleId, int ekipmanId, int olayId, int ekipId, String plaka) {
        this.mudahaleId = mudahaleId;
        this.ekipmanId = ekipmanId;
        this.olayId = olayId;
        this.ekipId = ekipId;
        this.plaka = plaka;
    }
    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public int getEkipmanId() {
        return ekipmanId;
    }

    public void setEkipmanId(int ekipmanId) {
        this.ekipmanId = ekipmanId;
    }

    public int getOlayId() {
        return olayId;
    }

    public void setOlayId(int olayId) {
        this.olayId = olayId;
    }

    public int getMudahaleId() {
        return mudahaleId;
    }

    public void setMudahaleId(int mudahaleId) {
        this.mudahaleId = mudahaleId;
    }

    public int getEkipId() {
        return ekipId;
    }

    public void setEkipId(int ekipId) {
        this.ekipId = ekipId;
    }

    public ekipmanEntity getEkipman() {
        return ekipman;
    }

    public void setEkipman(ekipmanEntity ekipman) {
        this.ekipman = ekipman;
    }

    public olayEntity getOlay() {
        return olay;
    }

    public void setOlay(olayEntity olay) {
        this.olay = olay;
    }

    public ekipEntity getEkip() {
        return ekip;
    }

    public void setEkip(ekipEntity ekip) {
        this.ekip = ekip;
    }
    
}
