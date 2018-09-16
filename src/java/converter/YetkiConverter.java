/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.yetkiDao;
import entity.yetkiEntity;
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

   @FacesConverter(value="yetkiConverter")
public class YetkiConverter implements Converter {

    /**
     * Creates a new instance of YetkiConverter
     */
  yetkiDao yetki;

  
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String value) {
      try {
          return this.getYetki().bul(Integer.valueOf(value));
      } catch (SQLException ex) {
          Logger.getLogger(YetkiConverter.class.getName()).log(Level.SEVERE, null, ex);
      }
       return this.getYetki();
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object o) {
      yetkiEntity i=(yetkiEntity)o;
      return ""+i.getYetkiId();
    }
      public yetkiDao getYetki() {
     if(yetki==null)
          yetki=new yetkiDao();
     return yetki;
    }

    public void setYetki(yetkiDao yetki) {
        this.yetki = yetki;
    }
    
}
