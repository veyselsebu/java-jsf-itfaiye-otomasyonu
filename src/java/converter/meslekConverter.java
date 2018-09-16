/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.meslekDao;
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
@FacesConverter(value="meslekConverter")
public class meslekConverter implements Converter {
    meslekDao meslek;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String value) {
        try {
            return this.getMeslek().bul(Integer.valueOf(value));
        } catch (SQLException ex) {
            Logger.getLogger(meslekConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
    return meslek;
                 }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object o) {
         meslekEntity i=(meslekEntity)o;
      return ""+i.getMeslekId();
    }

    public meslekDao getMeslek() {
        if(meslek==null)
            meslek=new meslekDao();
        return meslek;
    }

    public void setMeslek(meslekDao meslek) {
        this.meslek = meslek;
    }
    
}
