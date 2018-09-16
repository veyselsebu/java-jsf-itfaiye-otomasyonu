/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.adminYetkiDao;
import entity.adminYetkiEntity;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author veysels
 */
@ManagedBean
@RequestScoped
 @FacesConverter(value="adminyetkiconverter")
public class adminYetkiConverter implements Converter {
    adminYetkiDao ad;
    
    /**
     * Creates a new instance of adminYetkiConverter
     */
    public adminYetkiConverter() {
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
        adminYetkiEntity a =null;
        try {
            a= getAd().find(Integer.valueOf(string));
        } catch (SQLException ex) {
            Logger.getLogger(adminYetkiConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object o) {
        adminYetkiEntity a=(adminYetkiEntity)o;
   
        return a.getAdminYetkiId()+"";
    
    }

    public adminYetkiDao getAd() {
        if(ad==null)
            ad=new adminYetkiDao();
        return ad;
    }

    public void setAd(adminYetkiDao ad) {
        this.ad = ad;
    }
    
    
    
}
