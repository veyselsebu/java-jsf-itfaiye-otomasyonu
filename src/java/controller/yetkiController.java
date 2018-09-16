/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.adresDao;
import dao.yetkiDao;
import dao.yetkiDao;
import entity.adresEntity;
import entity.yetkiEntity;
import entity.yetkiEntity;
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
@ManagedBean(name="yetki")
@SessionScoped
public class yetkiController implements Serializable{
        private yetkiEntity yetki;
	private yetkiDao yetkiDao=new yetkiDao();
	private ArrayList<yetkiEntity> yetkiList;
        public yetkiEntity yetki2;
     public yetkiController(){
         yetki=new yetkiEntity();
     }
        public String kayit()
        {
            yetki=new yetkiEntity();
            return "/yetki/ekle?faces-redirect=true";
        }
     	public String create() throws SQLException {
		yetkiDao.ekle(yetki);
		return "/yetki/listele?faces-redirect=true";
	}   
        public ArrayList<yetkiEntity> listele() throws SQLException {
		this.yetkiList = new ArrayList();
		this.yetkiList =  yetkiDao.getlistele();
		return yetkiList;
	}
        
        
        public String sil(yetkiEntity yetki) throws SQLException {
		yetkiDao.sil(yetki);
		return "/yetki/listele?faces-redirect=true";
	}
       public String guncelle(yetkiEntity yetki){
         
           this.yetki2=yetki;
           return "/yetki/listele?faces-redirect=true";

       } 
          public String guncelleKaydet() throws SQLException{
           yetkiDao.guncelle(yetki2);
           yetki2=null;
           return "/yetki/listele?faces-redirect=true";
       }
        public String detay(yetkiEntity yetki){
             this.yetki2=yetki;
            return "/yetki/detay?faces-redirect=true";
        } 

    public yetkiEntity getYetki() {
        return yetki;
    }

    public void setYetki(yetkiEntity yetki) {
        this.yetki = yetki;
    }

    public yetkiDao getyetkiDao() {
        return yetkiDao;
    }

    public void setyetkiDao(yetkiDao yetkiDao) {
        this.yetkiDao = yetkiDao;
    }

    public ArrayList<yetkiEntity> getyetkiList() {
        return yetkiList;
    }

    public void setyetkiList(ArrayList<yetkiEntity> yetkiList) {
        this.yetkiList = yetkiList;
    }

    public yetkiEntity getYetki2() {
        return yetki2;
    }

    public void setYetki2(yetkiEntity yetki2) {
        this.yetki2 = yetki2;
    }
    

    
}
