/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.adresDao;
import entity.adresEntity;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author veysels
 */
@ManagedBean(name="adres")
@SessionScoped
public class adresController implements Serializable{
        private adresEntity adres=new adresEntity();
	private adresDao adresDao=new adresDao();
	private ArrayList<adresEntity> adresList;
        public adresEntity adres2;
        public String ekleme(){
            adresEntity adres=new adresEntity();
            return "/adres/ekle?faces-redirect=true";
        }  
        public String temizle(){
            adres2=null;
            return "/adres/listele?faces-redirect=true";
        }
     	public String create() throws SQLException {
		adresDao.ekle(adres);
		return "/adres/listele?faces-redirect=true";
	}   
        public ArrayList<adresEntity> listele() throws SQLException {
		this.adresList = new ArrayList();
		this.adresList =  adresDao.getlistele();
		return adresList;
	}
        
            public String sil2() throws SQLException {
		adresDao.sil(adres2);
		return "/adres/listele?faces-redirect=true";
	}
        public void sil(adresEntity adres) throws SQLException {
		adres2=adres;
		//return "/adres/listele?faces-redirect=true";
	}
       public String guncelle(adresEntity adres){
         
           this.adres2=adres;
           return "/adres/listele?faces-redirect=true";

       } 
          public String guncelleKaydet() throws SQLException{
           adresDao.guncelle(adres2);
           adres2=null;
           return "/adres/listele?faces-redirect=true";
       }
        public String detay(adresEntity adres){
             this.adres2=adres;
            return "/adres/detay?faces-redirect=true";
        } 
      
    public adresEntity getAdres2() {
        return adres2;
    }

    public void setAdres2(adresEntity adres2) {
        this.adres2 = adres2;
    }
    
        
      
        
        
        public adresEntity getAdres() {
        return adres;
    }

    public void setAdres(adresEntity adres) {
        this.adres = adres;
    }

    public adresDao getAdresDao() {
        return adresDao;
    }

    public void setAdresDao(adresDao adresDao) {
        this.adresDao = adresDao;
    }

    public ArrayList<adresEntity> getAdresList() {
        return adresList;
    }

    public void setAdresList(ArrayList<adresEntity> adresList) {
        this.adresList = adresList;
    }
	


    
}
