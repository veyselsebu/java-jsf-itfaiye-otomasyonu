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
public class ihbarEntity {
    private int ihbarId;
    private calisanEntity calisan;
    private vatandasEntity vatandas;
  

    public ihbarEntity(int ihbarId, calisanEntity calisan, vatandasEntity vatandas) {
        this.ihbarId = ihbarId;
        this.calisan = calisan;
        this.vatandas = vatandas;
    }

    
    
    
    
    
    public int getIhbarId() {
        return ihbarId;
    }

    public void setIhbarId(int ihbarId) {
        this.ihbarId = ihbarId;
    }

    public ihbarEntity() {
    }

    

    public calisanEntity getCalisan() {
        return calisan;
    }

    public void setCalisan(calisanEntity calisan) {
        this.calisan = calisan;
    }

    public vatandasEntity getVatandas() {
        if(vatandas==null)
            vatandas=new vatandasEntity();
        return vatandas;
    }

    public void setVatandas(vatandasEntity vatandas) {
        this.vatandas = vatandas;
    }
    
    
}
