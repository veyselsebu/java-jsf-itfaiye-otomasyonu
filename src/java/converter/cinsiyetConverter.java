/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.cinsiyetDao;
import entity.cinsiyetEntity;
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
 @FacesConverter(value="cinsiyetConverter")
public class cinsiyetConverter implements Converter  {
  cinsiyetDao cinsiyet;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String value) {
      try {
          return this.getCinsiyet().bul(Integer.valueOf(value));
      } catch (SQLException ex) {
          Logger.getLogger(cinsiyetConverter.class.getName()).log(Level.SEVERE, null, ex);
      }
      return cinsiyet;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object o) {
        cinsiyetEntity i=(cinsiyetEntity)o;
      return ""+i.getCinsiyetId();
    }

    public cinsiyetDao getCinsiyet() {
        if(cinsiyet==null)
            cinsiyet=new cinsiyetDao();
        return cinsiyet;
    }

    public void setCinsiyet(cinsiyetDao cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

   
}
