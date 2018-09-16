/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ekipDao;
import entity.ekipEntity;
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
@ManagedBean(name="ekip")
@SessionScoped
public class ekipController implements Serializable{
        private ekipEntity ekip=new ekipEntity();
	private ekipDao ekipDao=new ekipDao();
	private ArrayList<ekipEntity> ekipList;
        public ekipEntity ekip2;
     
   
     	public String create() throws SQLException {
		ekipDao.ekle(ekip);
		return "/ekip/listele?faces-redirect=true";
	}   
        public ArrayList<ekipEntity> listele() throws SQLException {
               ekip.setEkipAdi("");
               ekip.setAciklama("");
            this.ekipList = new ArrayList();
		this.ekipList =  ekipDao.getlistele();
		return ekipList;
	}
        
        
        public void sil(ekipEntity ekip) throws SQLException {
		ekipDao.sil(ekip);
		//return "/ekip/listele?faces-redirect=true";
	}
       public void guncelle(ekipEntity ekip){
         
           this.ekip2=ekip;
           //return "/ekip/listele?faces-redirect=true";

       } 
          public String guncelleKaydet() throws SQLException{
           ekipDao.guncelle(ekip2);
           ekip2=null;
           return "/ekip/listele?faces-redirect=true";
       }
        public String detay(ekipEntity ekip){
             this.ekip2=ekip;
            return "/ekip/detay?faces-redirect=true";
        } 

    public ekipEntity getEkip() {
        return ekip;
    }

    public void setEkip(ekipEntity ekip) {
        this.ekip = ekip;
    }

    public ekipDao getEkipDao() {
        return ekipDao;
    }

    public void setEkipDao(ekipDao ekipDao) {
        this.ekipDao = ekipDao;
    }

    public ArrayList<ekipEntity> getEkipList() {
        return ekipList;
    }

    public void setEkipList(ArrayList<ekipEntity> ekipList) {
        this.ekipList = ekipList;
    }

    public ekipEntity getEkip2() {
        return ekip2;
    }

    public void setEkip2(ekipEntity ekip2) {
        this.ekip2 = ekip2;
    }
   

    
}
