/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.servlet.http.Part;

/**
 *
 * @author veysels
 */
public class resimEntity {
    private int resimId;
    private String uzanti;
    private Part dosya;
    
    public resimEntity() {
    }

    public resimEntity(int resimId, String uzanti) {
        this.resimId = resimId;
        this.uzanti = uzanti;
    }

    public Part getDosya() {
        return dosya;
    }

    public void setDosya(Part dosya) {
        this.dosya = dosya;
    }


    public int getResimId() {
        return resimId;
    }

    public void setResimId(int resimId) {
        this.resimId = resimId;
    }

    public String getUzanti() {
        return uzanti;
    }

    public void setUzanti(String uzanti) {
        this.uzanti = uzanti;
    }
}
