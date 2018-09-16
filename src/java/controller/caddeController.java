/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.caddeDao;
import entity.caddeEntity;
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
@ManagedBean(name="cadde")
@SessionScoped
public class caddeController implements Serializable{
        private caddeEntity cadde=new caddeEntity();;
	private caddeDao caddeDao=new caddeDao();
	private ArrayList<caddeEntity> caddeList;
        public caddeEntity cadde2;
     
   
     	public String create() throws SQLException {
		caddeDao.ekle(cadde);
		return "/cadde/listele?faces-redirect=true";
	}   
        public ArrayList<caddeEntity> listele() throws SQLException {
		this.caddeList = new ArrayList();
		this.caddeList =  caddeDao.getlistele();
		return caddeList;
	}
        
        
        public void sil(caddeEntity cadde) throws SQLException {
		caddeDao.sil(cadde);
		//return "/cadde/listele?faces-redirect=true";
	}
       public void guncelle(caddeEntity cadde){
         
           this.cadde2=cadde;
          // return "/cadde/listele?faces-redirect=true";

       } 
          public void guncelleKaydet() throws SQLException{
           caddeDao.guncelle(cadde2);
           cadde2=null;
       //    return "/cadde/listele?faces-redirect=true";
       }
        public String detay(caddeEntity cadde){
             this.cadde2=cadde;
            return "/cadde/detay?faces-redirect=true";
        } 
      
    public caddeEntity getcadde2() {
        return cadde2;
    }

    public void setcadde2(caddeEntity cadde2) {
        this.cadde2 = cadde2;
    }
    
        
      
        
        
        public caddeEntity getcadde() {
        return cadde;
    }

    public void setcadde(caddeEntity cadde) {
        this.cadde = cadde;
    }

    public caddeDao getcaddeDao() {
        return caddeDao;
    }

    public void setcaddeDao(caddeDao caddeDao) {
        this.caddeDao = caddeDao;
    }

    public ArrayList<caddeEntity> getcaddeList() {
        return caddeList;
    }

    public void setcaddeList(ArrayList<caddeEntity> caddeList) {
        this.caddeList = caddeList;
    }
	


    
}
