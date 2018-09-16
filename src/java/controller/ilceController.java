/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.adresDao;
import dao.ilceDao;
import dao.ilceDao;
import entity.adresEntity;
import entity.ilceEntity;
import entity.ilceEntity;
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
@ManagedBean(name="ilce")
@SessionScoped
public class ilceController implements Serializable{
        private ilceEntity ilce=new ilceEntity();;
	private ilceDao ilceDao=new ilceDao();
	private ArrayList<ilceEntity> ilceList;
        public ilceEntity ilce2;
     
   
     	public String create() throws SQLException {
		ilceDao.ekle(ilce);
		return "/ilce/listele?faces-redirect=true";
	}   
        public ArrayList<ilceEntity> listele() throws SQLException {
		this.ilceList = new ArrayList();
		this.ilceList =  ilceDao.getlistele();
		return ilceList;
	}
        
        
        public String sil(ilceEntity ilce) throws SQLException {
		ilceDao.sil(ilce);
		return "/ilce/listele?faces-redirect=true";
	}
       public String guncelle(ilceEntity ilce){
         
           this.ilce2=ilce;
           return "/ilce/listele?faces-redirect=true";

       } 
          public String guncelleKaydet() throws SQLException{
           ilceDao.guncelle(ilce2);
           ilce2=null;
           return "/ilce/listele?faces-redirect=true";
       }
        public String detay(ilceEntity ilce){
             this.ilce2=ilce;
            return "/ilce/detay?faces-redirect=true";
        } 
      
    public ilceEntity getilce2() {
        return ilce2;
    }

    public void setilce2(ilceEntity ilce2) {
        this.ilce2 = ilce2;
    }
    
        
      
        
        
        public ilceEntity getilce() {
        return ilce;
    }

    public void setilce(ilceEntity ilce) {
        this.ilce = ilce;
    }

    public ilceDao getilceDao() {
        return ilceDao;
    }

    public void setilceDao(ilceDao ilceDao) {
        this.ilceDao = ilceDao;
    }

    public ArrayList<ilceEntity> getilceList() {
        return ilceList;
    }

    public void setilceList(ArrayList<ilceEntity> ilceList) {
        this.ilceList = ilceList;
    }
	


    
}
