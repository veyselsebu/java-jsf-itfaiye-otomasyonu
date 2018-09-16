/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.caddeDao;
import entity.caddeEntity;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean
@RequestScoped
@FacesConverter(value="caddeConverter")
public class caddeConverter implements Converter {
  caddeDao cadde;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String value) {
      try {
          return this.getCadde().bul(Integer.valueOf(value));
      } catch (SQLException ex) {
          Logger.getLogger(caddeConverter.class.getName()).log(Level.SEVERE, null, ex);
      }
      return cadde;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object o) {
        caddeEntity i=(caddeEntity)o;
      return ""+i.getCaddeId();
    }

    public caddeDao getCadde() {
        if(cadde==null)
            cadde=new caddeDao();
        return cadde;
    }

    public void setCadde(caddeDao cadde) {
        this.cadde = cadde;
    }

}
