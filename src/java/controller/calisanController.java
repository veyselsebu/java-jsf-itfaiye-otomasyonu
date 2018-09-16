/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.calisanDao;
import dao.ekipDao;
import dao.meslekDao;
import entity.calisanEntity;
import entity.ekipEntity;
import entity.meslekEntity;
import java.io.IOException;
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
@ManagedBean(name="calisan")
@SessionScoped
public class calisanController implements Serializable{
        private calisanEntity calisan=new calisanEntity();;
	private calisanDao calisanDao=new calisanDao();
	private ArrayList<calisanEntity> calisanList;
        public calisanEntity calisan2;
        
     
   
     	public String create() throws SQLException, IOException {
		calisanDao.ekle(calisan);
		return "/calisan/listele?faces-redirect=true";
	}   
        public ArrayList<calisanEntity> listele() throws SQLException {
		this.calisanList = new ArrayList();
		this.calisanList =  calisanDao.getlistele();
		return calisanList;
	}
           public ArrayList<ekipEntity> ekiplistele() throws SQLException {
		ekipDao ek=new ekipDao();
		return ek.getlistele();
	}
        
            public ArrayList<meslekEntity> mesleklistele() throws SQLException {
		meslekDao ek=new meslekDao();
		return ek.getlistele();
	}
        
        
        public void sil(calisanEntity calisan) throws SQLException {
		calisanDao.sil(calisan);
		//return "/calisan/listele?faces-redirect=true";
	}
       public void guncelle(calisanEntity calisan){
         
           this.calisan2=calisan;
           //return "/calisan/listele?faces-redirect=true";

       } 
          public String guncelleKaydet() throws SQLException{
           calisanDao.guncelle(calisan2);
           calisan2=null;
           return "/calisan/listele?faces-redirect=true";
       }
             public String resimguncelle(calisanEntity calisan){
         
           this.calisan2=calisan;
             return "/guvenli/resimguncelle?faces-redirect=true";

       } 
          public String resimguncelleKaydet() throws SQLException, IOException{
           calisanDao.resimguncelle(calisan2);
           calisan2=null;
           return "/calisan/listele?faces-redirect=true";
       }
        public String detay(calisanEntity calisan){
             this.calisan2=calisan;
            return "/calisan/detay?faces-redirect=true";
        } 
      
    public calisanEntity getcalisan2() {
        return calisan2;
    }

    public void setcalisan2(calisanEntity calisan2) {
        this.calisan2 = calisan2;
    }
    
        
      
        
        
        public calisanEntity getCalisan() {
        return calisan;
    }

    public void setCalisan(calisanEntity calisan) {
        this.calisan = calisan;
    }

    public calisanDao getcalisanDao() {
        return calisanDao;
    }

    public void setcalisanDao(calisanDao calisanDao) {
        this.calisanDao = calisanDao;
    }

    public ArrayList<calisanEntity> getcalisanList() {
        return calisanList;
    }

    public void setcalisanList(ArrayList<calisanEntity> calisanList) {
        this.calisanList = calisanList;
    }
	


    
}
