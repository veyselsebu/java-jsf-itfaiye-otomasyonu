package controller;

import dao.adresDao;
import dao.olayTipiDao;
import dao.olayTipiDao;
import entity.adresEntity;
import entity.olaytipiEntity;
import entity.olaytipiEntity;
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
@ManagedBean(name="olayTipi")
@SessionScoped
public class olayTipiController implements Serializable{
        private olaytipiEntity olayTipi=new olaytipiEntity();;
	private olayTipiDao olayTipiDao=new olayTipiDao();
	private ArrayList<olaytipiEntity> olayTipiList;
        public olaytipiEntity olayTipi2;
     
   
     	public String create() throws SQLException {
		olayTipiDao.ekle(olayTipi);
		return "/olayTipi/listele?faces-redirect=true";
	}   
        public ArrayList<olaytipiEntity> listele() throws SQLException {
		olayTipi2=null;
                this.olayTipiList = new ArrayList();
		this.olayTipiList =  olayTipiDao.getlistele();
		return olayTipiList;
	}
        
        
        public void sil(olaytipiEntity olayTipi) throws SQLException {
		olayTipiDao.sil(olayTipi);
		//return "/olayTipi/listele?faces-redirect=true";
	}
       public void guncelle(olaytipiEntity olayTipi){
         
           this.olayTipi2=olayTipi;
           //return "/olayTipi/listele?faces-redirect=true";

       } 
          public String guncelleKaydet() throws SQLException{
           olayTipiDao.guncelle(olayTipi2);
           olayTipi2=null;
           return "/olayTipi/listele?faces-redirect=true";
       }
        public String detay(olaytipiEntity olayTipi){
             this.olayTipi2=olayTipi;
            return "/olayTipi/detay?faces-redirect=true";
        } 
        

        

    public olaytipiEntity getOlayTipi() {
        return olayTipi;
    }

    public void setOlayTipi(olaytipiEntity olayTipi) {
        this.olayTipi = olayTipi;
    }

    public olayTipiDao getOlayTipiDao() {
        return olayTipiDao;
    }

    public void setOlayTipiDao(olayTipiDao olayTipiDao) {
        this.olayTipiDao = olayTipiDao;
    }

    public ArrayList<olaytipiEntity> getOlayTipiList() {
        return olayTipiList;
    }

    public void setOlayTipiList(ArrayList<olaytipiEntity> olayTipiList) {
        this.olayTipiList = olayTipiList;
    }

    public olaytipiEntity getOlayTipi2() {
        return olayTipi2;
    }

    public void setOlayTipi2(olaytipiEntity olayTipi2) {
        this.olayTipi2 = olayTipi2;
    }
    
}
