/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.olayTipiDao;
import entity.meslekEntity;
import entity.olaytipiEntity;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value="olaytipiConverter")
public class olaytipiConverter implements Converter {
        olayTipiDao olay;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
  try {
            return this.getOlay().bul(Integer.valueOf(string));
        } catch (SQLException ex) {
            Logger.getLogger(meslekConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
    return olay;   
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object o) {

    olaytipiEntity i=(olaytipiEntity)o;
      return ""+i.getOlayTipiId();

    }

    public olayTipiDao getOlay() {
        if(olay==null)
            olay=new olayTipiDao();
        return olay;
    }

    public void setOlay(olayTipiDao olay) {
        this.olay = olay;
    }
    
}
