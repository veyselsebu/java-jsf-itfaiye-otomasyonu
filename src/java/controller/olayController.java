package controller;

import dao.adresDao;
import dao.olayDao;
import dao.olayDao;
import entity.adresEntity;
import entity.calisanEntity;
import entity.olayEntity;
import entity.olayEntity;
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
@ManagedBean(name="olay")
@SessionScoped
public class olayController implements Serializable{
        private olayEntity olay=new olayEntity();;
	private olayDao olayDao=new olayDao();
	private ArrayList<olayEntity> olayList;
        public olayEntity olay2;
     
   
     	public String create() throws SQLException {
		olayDao.ekle(olay);
		return "/olay/listele?faces-redirect=true";
	}   
         public String ekle(calisanEntity c) throws SQLException {
                olay.getIhbar().setCalisan(c);
                 olayDao.create(olay);
		return "/olay/listele?faces-redirect=true";
	}  
        public ArrayList<olayEntity> listele() throws SQLException {
		this.olayList = new ArrayList();
		this.olayList =  olayDao.getlistele();
		return olayList;
	}
        
        
        public void sil(olayEntity olay) throws SQLException {
		olayDao.sil(olay);
		//return "/olay/listele?faces-redirect=true";
	}
       public void guncelle(olayEntity olay){
         
           this.olay2=olay;
           //return "/olay/listele?faces-redirect=true";

       } 
          public String guncelleKaydet() throws SQLException{
           olayDao.guncelle(olay2);
           olay2=null;
           return "/olay/listele?faces-redirect=true";
       }
        public String detay(olayEntity olay){
             this.olay2=olay;
            return "/olay/detay?faces-redirect=true";
        } 

    public olayEntity getOlay() {
        return olay;
    }

    public void setOlay(olayEntity olay) {
        this.olay = olay;
    }

    public olayDao getOlayDao() {
        return olayDao;
    }

    public void setOlayDao(olayDao olayDao) {
        this.olayDao = olayDao;
    }

    public ArrayList<olayEntity> getOlayList() {
        return olayList;
    }

    public void setOlayList(ArrayList<olayEntity> olayList) {
        this.olayList = olayList;
    }

    public olayEntity getOlay2() {
        return olay2;
    }

    public void setOlay2(olayEntity olay2) {
        this.olay2 = olay2;
    }
        
    
}
