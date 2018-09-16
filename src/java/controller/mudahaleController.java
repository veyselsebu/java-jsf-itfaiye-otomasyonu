package controller;

import dao.adresDao;
import dao.mudahaleDao;
import dao.mudahaleDao;
import entity.adresEntity;
import entity.mudahaleEntity;
import entity.mudahaleEntity;
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
@ManagedBean(name="mudahale")
@SessionScoped
public class mudahaleController implements Serializable{
        private mudahaleEntity mudahale=new mudahaleEntity();;
	private mudahaleDao mudahaleDao=new mudahaleDao();
	private ArrayList<mudahaleEntity> mudahaleList;
        public mudahaleEntity mudahale2;
     
   
     	public String create() throws SQLException {
		mudahaleDao.ekle(mudahale);
		return "/mudahale/listele?faces-redirect=true";
	}   
        public ArrayList<mudahaleEntity> listele() throws SQLException {
		this.mudahaleList = new ArrayList();
		this.mudahaleList =  mudahaleDao.getlistele();
		return mudahaleList;
	}
        
        
        public void sil(mudahaleEntity mudahale) throws SQLException {
		mudahaleDao.sil(mudahale);
		//return "/mudahale/listele?faces-redirect=true";
	}
       public void guncelle(mudahaleEntity mudahale){
         
           this.mudahale2=mudahale;
           //return "/mudahale/listele?faces-redirect=true";

       } 
          public String guncelleKaydet() throws SQLException{
           mudahaleDao.guncelle(mudahale2);
           mudahale2=null;
           return "/mudahale/listele?faces-redirect=true";
       }
        public String detay(mudahaleEntity mudahale){
             this.mudahale2=mudahale;
            return "/mudahale/detay?faces-redirect=true";
        } 

    public mudahaleEntity getMudahale() {
        return mudahale;
    }

    public void setMudahale(mudahaleEntity mudahale) {
        this.mudahale = mudahale;
    }

    public mudahaleDao getMudahaleDao() {
        return mudahaleDao;
    }

    public void setMudahaleDao(mudahaleDao mudahaleDao) {
        this.mudahaleDao = mudahaleDao;
    }

    public ArrayList<mudahaleEntity> getMudahaleList() {
        return mudahaleList;
    }

    public void setMudahaleList(ArrayList<mudahaleEntity> mudahaleList) {
        this.mudahaleList = mudahaleList;
    }

    public mudahaleEntity getMudahale2() {
        return mudahale2;
    }

    public void setMudahale2(mudahaleEntity mudahale2) {
        this.mudahale2 = mudahale2;
    }
        
}
