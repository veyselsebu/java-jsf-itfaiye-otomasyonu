/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ihbarDao;
import entity.ihbarEntity;
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
@ManagedBean(name="ihbar")
@SessionScoped
public class ihbarController implements Serializable{
        private ihbarEntity ihbar=new ihbarEntity();;
	private ihbarDao ihbarDao=new ihbarDao();
	private ArrayList<ihbarEntity> ihbarList;
        public ihbarEntity ihbar2;

    public ihbarEntity getIhbar() {
        return ihbar;
    }

    public void setIhbar(ihbarEntity ihbar) {
        this.ihbar = ihbar;
    }

    public ihbarDao getIhbarDao() {
        return ihbarDao;
    }

    public void setIhbarDao(ihbarDao ihbarDao) {
        this.ihbarDao = ihbarDao;
    }

    public ArrayList<ihbarEntity> getIhbarList() {
        return ihbarList;
    }

    public void setIhbarList(ArrayList<ihbarEntity> ihbarList) {
        this.ihbarList = ihbarList;
    }

    public ihbarEntity getIhbar2() {
        return ihbar2;
    }

    public void setIhbar2(ihbarEntity ihbar2) {
        this.ihbar2 = ihbar2;
    }
     
   
     	public String create() throws SQLException {
		ihbarDao.ekle(ihbar);
		return "/ihbar/listele?faces-redirect=true";
	}   
        public ArrayList<ihbarEntity> listele() throws SQLException {
		this.ihbarList = new ArrayList();
		this.ihbarList =  ihbarDao.getlistele();
		return ihbarList;
	}
        
        
        public void sil(ihbarEntity ihbar) throws SQLException {
		ihbarDao.sil(ihbar);
		//return "/ihbar/listele?faces-redirect=true";
	}
       public void guncelle(ihbarEntity ihbar){
         
           this.ihbar2=ihbar;
           //return "/ihbar/listele?faces-redirect=true";

       } 
          public String guncelleKaydet() throws SQLException{
           ihbarDao.guncelle(ihbar2);
           ihbar2=null;
           return "/ihbar/listele?faces-redirect=true";
       }
        public String detay(ihbarEntity ihbar){
             this.ihbar2=ihbar;
            return "/ihbar/detay?faces-redirect=true";
        } 
      
    public ihbarEntity getihbar2() {
        return ihbar2;
    }

    public void setihbar2(ihbarEntity ihbar2) {
        this.ihbar2 = ihbar2;
    }
    
        
      
        
        
        public ihbarEntity getihbar() {
        return ihbar;
    }

    public void setihbar(ihbarEntity ihbar) {
        this.ihbar = ihbar;
    }

    public ihbarDao getihbarDao() {
        return ihbarDao;
    }

    public void setihbarDao(ihbarDao ihbarDao) {
        this.ihbarDao = ihbarDao;
    }

    public ArrayList<ihbarEntity> getihbarList() {
        return ihbarList;
    }

    public void setihbarList(ArrayList<ihbarEntity> ihbarList) {
        this.ihbarList = ihbarList;
    }
	


    
}
