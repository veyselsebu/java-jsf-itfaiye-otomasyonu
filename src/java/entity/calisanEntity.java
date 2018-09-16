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
public class calisanEntity {
    private int calisanId;
    private ekipEntity ekip;
    private meslekEntity meslek;
    private int resimId;
    private vatandasEntity vatandas;
    private resimEntity resim; 
    public calisanEntity(int calisanId, ekipEntity ekip, meslekEntity meslek, resimEntity resim, vatandasEntity vatandas) {
        this.calisanId = calisanId;
        this.ekip = ekip;
        this.meslek = meslek;
        this.resim = resim;
        this.vatandas = vatandas;
    }

    public resimEntity getResim() {
        if(resim==null)
            resim=new resimEntity();
        return resim;
    }

    public void setResim(resimEntity resim) {
        this.resim = resim;
    }


    public vatandasEntity getVatandas() {
        if(vatandas==null)
            vatandas=new vatandasEntity();
        return vatandas;
    }

    public void setVatandas(vatandasEntity vatandas) {
        this.vatandas = vatandas;
    }
   
    
    
    
    public int getCalisanId() {
        return calisanId;
    }

    public void setCalisanId(int calisanId) {
        this.calisanId = calisanId;
    }

    public calisanEntity() {
    }



    public int getResimId() {
        return resimId;
    }

    public void setResimId(int resimId) {
        this.resimId = resimId;
    }



    public ekipEntity getEkip() {
        return ekip;
    }

    public void setEkip(ekipEntity ekip) {
        this.ekip = ekip;
    }

    public meslekEntity getMeslek() {
        return meslek;
    }

    public void setMeslek(meslekEntity meslek) {
        this.meslek = meslek;
    }
    
}
