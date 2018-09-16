/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.cinsiyetDao;
import entity.cinsiyetEntity;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author veysels
 */
@ManagedBean(name="cinsiyet")
@SessionScoped
public class cinsiyetController implements Serializable{
        private cinsiyetEntity adres=new cinsiyetEntity();
	private cinsiyetDao cinsiyetDao=new cinsiyetDao();
	private ArrayList<cinsiyetEntity> adresList;
    
     
      
        public ArrayList<cinsiyetEntity> listele() throws SQLException {
		this.adresList = new ArrayList();
		this.adresList =  cinsiyetDao.getlistele();
		return adresList;
	}

    public cinsiyetEntity getAdres() {
        return adres;
    }

    public void setAdres(cinsiyetEntity adres) {
        this.adres = adres;
    }

    public cinsiyetDao getCinsiyetDao() {
        return cinsiyetDao;
    }

    public void setCinsiyetDao(cinsiyetDao cinsiyetDao) {
        this.cinsiyetDao = cinsiyetDao;
    }

    public ArrayList<cinsiyetEntity> getAdresList() {
        return adresList;
    }

    public void setAdresList(ArrayList<cinsiyetEntity> adresList) {
        this.adresList = adresList;
    }
        
    
  

        
      



    
}
