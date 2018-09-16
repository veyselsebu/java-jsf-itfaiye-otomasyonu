/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ekipmanDao;
import entity.ekipmanEntity;
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
@ManagedBean(name="ekipman")
@SessionScoped
public class ekipmanController implements Serializable{
        private ekipmanEntity ekipman=new ekipmanEntity();;
	private ekipmanDao ekipmanDao=new ekipmanDao();
	private ArrayList<ekipmanEntity> ekipmanList;
        public ekipmanEntity ekipman2;
     
   
     	public String create() throws SQLException {
		ekipmanDao.ekle(ekipman);
		return "/ekipman/listele?faces-redirect=true";
	}   
        public ArrayList<ekipmanEntity> listele() throws SQLException {
		this.ekipmanList = new ArrayList();
		this.ekipmanList =  ekipmanDao.getlistele();
		return ekipmanList;
	}
        
        
        public String sil(ekipmanEntity ekipman) throws SQLException {
		ekipmanDao.sil(ekipman);
		return "/ekipman/listele?faces-redirect=true";
	}
       public String guncelle(ekipmanEntity ekipman){
         
           this.ekipman2=ekipman;
           return "/ekipman/listele?faces-redirect=true";

       } 
          public String guncelleKaydet() throws SQLException{
           ekipmanDao.guncelle(ekipman2);
           ekipman2=null;
           return "/ekipman/listele?faces-redirect=true";
       }
        public String detay(ekipmanEntity ekipman){
             this.ekipman2=ekipman;
            return "/ekipman/detay?faces-redirect=true";
        } 
      
    public ekipmanEntity getekipman2() {
        return ekipman2;
    }

    public void setekipman2(ekipmanEntity ekipman2) {
        this.ekipman2 = ekipman2;
    }
    
        
      
        
        
        public ekipmanEntity getekipman() {
        return ekipman;
    }

    public void setekipman(ekipmanEntity ekipman) {
        this.ekipman = ekipman;
    }

    public ekipmanDao getekipmanDao() {
        return ekipmanDao;
    }

    public void setekipmanDao(ekipmanDao ekipmanDao) {
        this.ekipmanDao = ekipmanDao;
    }

    public ArrayList<ekipmanEntity> getekipmanList() {
        return ekipmanList;
    }

    public void setekipmanList(ArrayList<ekipmanEntity> ekipmanList) {
        this.ekipmanList = ekipmanList;
    }
	


    
}
