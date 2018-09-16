/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.adresDao;
import dao.cinsiyetDao;
import dao.ilceDao;
import dao.vatandasDao;
import dao.vatandasDao;
import entity.adresEntity;
import entity.cinsiyetEntity;
import entity.ilceEntity;
import entity.vatandasEntity;
import entity.vatandasEntity;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author veysels
 */
@ManagedBean(name="vatandas")
@SessionScoped
public class vatandasController implements Serializable{
        private vatandasEntity vatandas;
	private vatandasDao vatandasDao=new vatandasDao();
	private ArrayList<vatandasEntity> vatandasList;
        public vatandasEntity vatandas2;
     public vatandasController(){
         vatandas=new vatandasEntity();
     }
        public String kayit()
        {
            vatandas=new vatandasEntity();
            return "/vatandas/ekle?faces-redirect=true";
        }
     	public String create() throws SQLException {
		vatandasDao.ekle(vatandas);
		return "/vatandas/listele?faces-redirect=true";
	}   
        public ArrayList<vatandasEntity> listele() throws SQLException {
		this.vatandasList = new ArrayList();
		this.vatandasList =  vatandasDao.getlistele();
		return vatandasList;
	}
            public ArrayList<cinsiyetEntity>getCinsiyetListele() throws SQLException{
            cinsiyetDao ilcem=new cinsiyetDao(); 
            return ilcem.getlistele();
        }
        
        public void sil(vatandasEntity vatandas) throws SQLException {
		vatandasDao.sil(vatandas);
		//return "/vatandas/listele?faces-redirect=true";
	}
       public void guncelle(vatandasEntity vatandas){
         
           this.vatandas2=vatandas;
          // return "/vatandas/listele?faces-redirect=true";

       } 
          public String guncelleKaydet() throws SQLException{
           vatandasDao.guncelle(vatandas2);
           vatandas2=null;
           return "/vatandas/listele?faces-redirect=true";
       }
        public String detay(vatandasEntity vatandas){
             this.vatandas2=vatandas;
            return "/vatandas/detay?faces-redirect=true";
        } 

    public vatandasEntity getVatandas() {
        return vatandas;
    }

    public void setVatandas(vatandasEntity vatandas) {
        this.vatandas = vatandas;
    }

    public vatandasDao getVatandasDao() {
        return vatandasDao;
    }

    public void setVatandasDao(vatandasDao vatandasDao) {
        this.vatandasDao = vatandasDao;
    }

    public ArrayList<vatandasEntity> getVatandasList() {
        return vatandasList;
    }

    public void setVatandasList(ArrayList<vatandasEntity> vatandasList) {
        this.vatandasList = vatandasList;
    }

    public vatandasEntity getVatandas2() {
        return vatandas2;
    }

    public void setVatandas2(vatandasEntity vatandas2) {
        this.vatandas2 = vatandas2;
    }
    

    
}
