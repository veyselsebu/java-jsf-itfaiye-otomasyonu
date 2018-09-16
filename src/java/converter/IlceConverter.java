/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;


import dao.ilceDao;
import entity.ilceEntity;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="ilceConverter")
public class IlceConverter implements Converter {
private ilceDao ilce;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String value) {

    try {
        return this.getIlce().bul(Integer.valueOf(value));
    } catch (SQLException ex) {
        Logger.getLogger(IlceConverter.class.getName()).log(Level.SEVERE, null, ex);
    }
     return this.getIlce();
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object o) {
      ilceEntity i=(ilceEntity)o;
      return ""+i.getIlceId();
    }

    public ilceDao getIlce() {
        if(ilce==null)
            ilce=new ilceDao();
        
        return ilce;
    }

    public void setIlce(ilceDao ilce) {
        this.ilce = ilce;
    }

    
}
