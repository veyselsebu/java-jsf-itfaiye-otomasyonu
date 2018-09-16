package controller;

import dao.adresDao;
import dao.meslekDao;
import dao.meslekDao;
import entity.adresEntity;
import entity.meslekEntity;
import entity.meslekEntity;
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
@ManagedBean(name="meslek")
@SessionScoped
public class meslekController implements Serializable{
        private meslekEntity meslek=new meslekEntity();;
	private meslekDao meslekDao=new meslekDao();
	private ArrayList<meslekEntity> meslekList;
        public meslekEntity meslek2;
     
   
     	public String create() throws SQLException {
		meslekDao.ekle(meslek);
		return "/meslek/listele?faces-redirect=true";
	}   
        public ArrayList<meslekEntity> listele() throws SQLException {
		this.meslekList = new ArrayList();
		this.meslekList =  meslekDao.getlistele();
		return meslekList;
	}
        
        
        public String sil(meslekEntity meslek) throws SQLException {
		meslekDao.sil(meslek);
		return "/meslek/listele?faces-redirect=true";
	}
       public String guncelle(meslekEntity meslek){
         
           this.meslek2=meslek;
           return "/meslek/listele?faces-redirect=true";

       } 
          public String guncelleKaydet() throws SQLException{
           meslekDao.guncelle(meslek2);
           meslek2=null;
           return "/meslek/listele?faces-redirect=true";
       }
        public String detay(meslekEntity meslek){
             this.meslek2=meslek;
            return "/meslek/detay?faces-redirect=true";
        } 

    public meslekEntity getMeslek() {
        return meslek;
    }

    public void setMeslek(meslekEntity meslek) {
        this.meslek = meslek;
    }

    public meslekDao getMeslekDao() {
        return meslekDao;
    }

    public void setMeslekDao(meslekDao meslekDao) {
        this.meslekDao = meslekDao;
    }

    public ArrayList<meslekEntity> getMeslekList() {
        return meslekList;
    }

    public void setMeslekList(ArrayList<meslekEntity> meslekList) {
        this.meslekList = meslekList;
    }

    public meslekEntity getMeslek2() {
        return meslek2;
    }

    public void setMeslek2(meslekEntity meslek2) {
        this.meslek2 = meslek2;
    }
        
        
        
        
}
