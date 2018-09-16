/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.ekipDao;
import entity.ekipEntity;
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
 @FacesConverter(value="ekipConverter")
public class ekipConverter implements Converter{
    ekipDao ekip;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String value) {
        try {
            return this.getEkip().bul(Integer.valueOf(value));
        } catch (SQLException ex) {
            Logger.getLogger(ekipConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
    return ekip;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object o) {
 ekipEntity i=(ekipEntity)o;
      return ""+i.getEkipId();
    }

    public ekipDao getEkip() {
        if(ekip==null)
            ekip=new ekipDao();
        return ekip;
    }

    public void setEkip(ekipDao ekip) {
        this.ekip = ekip;
    }
  
    
}
