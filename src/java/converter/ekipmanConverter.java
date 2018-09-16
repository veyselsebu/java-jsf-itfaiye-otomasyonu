/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.ekipmanDao;
import entity.ekipmanEntity;
import entity.meslekEntity;
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
@FacesConverter(value="ekipmanConverter")
public class ekipmanConverter implements Converter{
    ekipmanDao ekipman;
  
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
       try {
            return this.getEkipman().bul(Integer.valueOf(string));
        } catch (SQLException ex) {
            Logger.getLogger(ekipmanConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
    return ekipman;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object o) {
     ekipmanEntity i=(ekipmanEntity)o;
      return ""+i.getEkimanId();
    }

    public ekipmanDao getEkipman() {
        if(ekipman==null)
            ekipman=new ekipmanDao();
        return ekipman;
    }

    public void setEkipman(ekipmanDao ekipman) {
        this.ekipman = ekipman;
    }
    
}
