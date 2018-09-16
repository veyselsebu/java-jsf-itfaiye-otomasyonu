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
public class aracEntity {

    public aracEntity(String plaka, String marka, String model, String ozellikler, int kapasiteLitre) {
        this.plaka = plaka;
        this.marka = marka;
        this.model = model;
        this.ozellikler = ozellikler;
        this.kapasiteLitre = kapasiteLitre;
    }

    public aracEntity() {
    }
    private String plaka;
    private String marka;
    private String model;
    private String ozellikler;
    private int kapasiteLitre;

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOzellikler() {
        return ozellikler;
    }

    public void setOzellikler(String ozellikler) {
        this.ozellikler = ozellikler;
    }

    public int getKapasiteLitre() {
        return kapasiteLitre;
    }

    public void setKapasiteLitre(int kapasiteLitre) {
        this.kapasiteLitre = kapasiteLitre;
    }
}
