/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mypackage;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author willy
 */
public class CdConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        Integer id = new Integer(string);
        CdJpaController controller = (CdJpaController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "cdJpa");
        return controller.findCd(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Cd) {
            Cd o = (Cd) object;
            return o.getCdId() == null ? "" : o.getCdId().toString();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: mypackage.Cd");
        }
    }

}
