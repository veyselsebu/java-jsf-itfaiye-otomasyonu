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
public class adresEntity {
   private int adresId;
   private caddeEntity cadde;
   private String acikAdres;
    
    
    
    
    public adresEntity() {
    }

    public adresEntity(int adresId, caddeEntity caddeId, String acikAdres) {
        this.adresId = adresId;
        this.cadde = caddeId;
        this.acikAdres = acikAdres;
    }
 

  
    public int getAdresId() {
        return adresId;
    }

    public void setAdresId(int adresId) {
        this.adresId = adresId;
    }

    public caddeEntity getCadde() {
        return cadde;
    }

    public void setCadde(caddeEntity cadde) {
        this.cadde = cadde;
    }

 

    public String getAcikAdres() {
        return acikAdres;
    }

    public void setAcikAdres(String acikAdres) {
        this.acikAdres = acikAdres;
    }
}
