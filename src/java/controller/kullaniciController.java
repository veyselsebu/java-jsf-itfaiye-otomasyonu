/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.adresDao;
import dao.kullaniciDao;
import dao.kullaniciDao;
import dao.yetkiDao;
import entity.adresEntity;
import entity.calisanEntity;
import entity.kullaniciEntity;
import entity.kullaniciEntity;
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
@ManagedBean(name="kullanici")
@SessionScoped
public class kullaniciController implements Serializable{
        private kullaniciEntity kullanici=new kullaniciEntity();;
	private kullaniciDao kullaniciDao=new kullaniciDao();
	private ArrayList<kullaniciEntity> kullaniciList;
        public kullaniciEntity kullanici2;
        private yetkiController ytk;
        private int page=1;
        private int pageSize=5;
        private int pageCount;
        
        public void ileri(){
          if(page==pageCount){
              page=1;
          }else
            page++;
            //return "/kullanici/listele?faces-redirect=true";
        }
        public void geri(){
           if(page==1){
               page=pageCount;
           }else
            page--;
            
           // return "/kullanici/listele?faces-redirect=true";
        }
     	public String create() throws SQLException {
            
		kullaniciDao.ekle(kullanici);
		return "/kullanici/listele?faces-redirect=true";
	}   
        public ArrayList<kullaniciEntity> listele() throws SQLException {
		this.kullaniciList = new ArrayList();
		this.kullaniciList =  kullaniciDao.getlistele();
		return kullaniciList;
	}
          public ArrayList<kullaniciEntity> paginationlistele() throws SQLException {
		this.kullaniciList = new ArrayList();
		this.kullaniciList =  kullaniciDao.findAll(page, pageSize);
		return kullaniciList;
	}
          public ArrayList<yetkiEntity> yetkilistele() throws SQLException {
		yetkiDao yetkim=new yetkiDao();
		return yetkim.getlistele();
	}
        
        public void sil(kullaniciEntity kullanici) throws SQLException {
		kullaniciDao.sil(kullanici);
		//return "/kullanici/listele?faces-redirect=true";
	}
       public void guncelle(kullaniciEntity kullanici){
         
           this.kullanici2=kullanici;
          // return "/kullanici/listele?faces-redirect=true";

       } 
           public String sifreguncelle(kullaniciEntity kullanici){
         
           this.kullanici2=kullanici;
           return "/guvenli/sifreguncelle?faces-redirect=true";

       } 
         public String sifreguncelleKaydet() throws SQLException{
           kullaniciDao.sifreGuncelle(kullanici2);
           kullanici2=null;
           return "/guvenli/listele?faces-redirect=true";
       }
          public String guncelleKaydet() throws SQLException{
           kullaniciDao.guncelle(kullanici2);
           kullanici2=null;
           return "/kullanici/listele?faces-redirect=true";
       }
        public String detay(kullaniciEntity kullanici){
             this.kullanici2=kullanici;
            return "/kullanici/detay?faces-redirect=true";
        } 
 
        public kullaniciEntity getKullanici() {
        return kullanici;
        }

    public void setKullanici(kullaniciEntity kullanici) {
        this.kullanici = kullanici;
    }

    public kullaniciDao getKullaniciDao() {
        return kullaniciDao;
    }

    public void setKullaniciDao(kullaniciDao kullaniciDao) {
        this.kullaniciDao = kullaniciDao;
    }

    public ArrayList<kullaniciEntity> getKullaniciList() {
        return kullaniciList;
    }

    public void setKullaniciList(ArrayList<kullaniciEntity> kullaniciList) {
        this.kullaniciList = kullaniciList;
    }

    public kullaniciEntity getKullanici2() {
        return kullanici2;
    }

    public void setKullanici2(kullaniciEntity kullanici2) {
        this.kullanici2 = kullanici2;
    }

    public yetkiController getYtk() {
        return ytk;
    }

    public void setYtk(yetkiController ytk) {
        this.ytk = ytk;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() throws SQLException {
        this.pageCount=(int)Math.ceil(this.kullaniciDao.count()/(double)pageSize); 
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
      
  
}
