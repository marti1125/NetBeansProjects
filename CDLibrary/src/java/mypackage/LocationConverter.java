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
public class LocationConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        Integer id = new Integer(string);
        LocationJpaController controller = (LocationJpaController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "locationJpa");
        return controller.findLocation(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Location) {
            Location o = (Location) object;
            return o.getLocationId() == null ? "" : o.getLocationId().toString();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: mypackage.Location");
        }
    }

}
