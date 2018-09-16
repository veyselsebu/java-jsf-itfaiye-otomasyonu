package controller;

import dao.adresDao;
import dao.ilceDao;
import dao.mahalleDao;
import dao.mahalleDao;
import entity.adresEntity;
import entity.ilceEntity;
import entity.mahalleEntity;
import entity.mahalleEntity;
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
@ManagedBean(name="mahalle")
@SessionScoped

public class mahalleController implements Serializable{
     
        private mahalleEntity mahalle=new mahalleEntity();;
	private mahalleDao mahalleDao=new mahalleDao();
	private ArrayList<mahalleEntity> mahalleList;
        public mahalleEntity mahalle2;
     
     	public String create() throws SQLException {
		mahalleDao.ekle(mahalle);
		return "/mahalle/listele?faces-redirect=true";
	}   
        public ArrayList<mahalleEntity> listele() throws SQLException {
		this.mahalleList = new ArrayList();
		this.mahalleList =  mahalleDao.getlistele();
		return mahalleList;
	}
        
        public ArrayList<ilceEntity>getIlceListele() throws SQLException{
            ilceDao ilcem=new ilceDao(); 
            return ilcem.getlistele();
        }
        public String sil(mahalleEntity mahalle) throws SQLException {
		mahalleDao.sil(mahalle);
		return "/mahalle/listele?faces-redirect=true";
	}
       public String guncelle(mahalleEntity mahalle){
         
           this.mahalle2=mahalle;
           return "/mahalle/listele?faces-redirect=true";

       } 
          public String guncelleKaydet() throws SQLException{
           mahalleDao.guncelle(mahalle2);
           mahalle2=null;
           return "/mahalle/listele?faces-redirect=true";
       }
        public String detay(mahalleEntity mahalle){
             this.mahalle2=mahalle;
            return "/mahalle/detay?faces-redirect=true";
        } 

    public mahalleEntity getMahalle() {
        return mahalle;
    }

    public void setMahalle(mahalleEntity mahalle) {
        this.mahalle = mahalle;
    }

    public mahalleDao getMahalleDao() {
        return mahalleDao;
    }

    public void setMahalleDao(mahalleDao mahalleDao) {
        this.mahalleDao = mahalleDao;
    }

    public ArrayList<mahalleEntity> getMahalleList() {
        return mahalleList;
    }

    public void setMahalleList(ArrayList<mahalleEntity> mahalleList) {
        this.mahalleList = mahalleList;
    }

    public mahalleEntity getMahalle2() {
        return mahalle2;
    }

    public void setMahalle2(mahalleEntity mahalle2) {
        this.mahalle2 = mahalle2;
    }
        
        
        
}
