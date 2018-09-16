/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.aracDao;
import entity.aracEntity;
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
@ManagedBean(name="arac")
@SessionScoped
public class aracController implements Serializable{
        private aracEntity arac=new aracEntity();;
	private aracDao aracDao=new aracDao();
	private ArrayList<aracEntity> aracList;
        public aracEntity arac2;
     
   
     	public String create() throws SQLException {
		aracDao.ekle(arac);
		return "/arac/listele?faces-redirect=true";
	}   
        public ArrayList<aracEntity> listele() throws SQLException {
		this.aracList = new ArrayList();
		this.aracList =  aracDao.getlistele();
		return aracList;
	}
        
        
        public String sil(aracEntity arac) throws SQLException {
		aracDao.sil(arac);
		return "/arac/listele?faces-redirect=true";
	}
       public String guncelle(aracEntity arac){
         
           this.arac2=arac;
           return "/arac/listele?faces-redirect=true";

       } 
          public String guncelleKaydet() throws SQLException{
           aracDao.guncelle(arac2);
           arac2=null;
           return "/arac/listele?faces-redirect=true";
       }
        public String detay(aracEntity arac){
             this.arac2=arac;
            return "/arac/detay?faces-redirect=true";
        } 

    public aracEntity getArac() {
        return arac;
    }

    public void setArac(aracEntity arac) {
        this.arac = arac;
    }

    public aracDao getAracDao() {
        return aracDao;
    }

    public void setAracDao(aracDao aracDao) {
        this.aracDao = aracDao;
    }

    public ArrayList<aracEntity> getAracList() {
        return aracList;
    }

    public void setAracList(ArrayList<aracEntity> aracList) {
        this.aracList = aracList;
    }

    public aracEntity getArac2() {
        return arac2;
    }

    public void setArac2(aracEntity arac2) {
        this.arac2 = arac2;
    }
      
  
    
}
