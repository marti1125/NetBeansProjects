/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.beans.*;
import java.io.Serializable;
import javax.servlet.http.HttpSession;

/**
 *
 * @author UNI
 */
public class Perfil implements Serializable {
    HttpSession permisos=null;
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";

    private String sampleProperty;

    private PropertyChangeSupport propertySupport;

    public Perfil() {
        propertySupport = new PropertyChangeSupport(this);
    }

    public String getSampleProperty() {
        return sampleProperty;
    }

    public void setSampleProperty(String value) {
        String oldValue = sampleProperty;
        sampleProperty = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    }


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    public void guardar_perfil(HttpSession xperfil){
        this.permisos=xperfil;
    }
    public void guardar_nombre(String nombre){
        this.permisos.setAttribute("nombre", nombre);
    }
    public HttpSession ver_perfil(){
        return permisos;
    }
    public void cerrar_sesion(){
        permisos.invalidate();
        
    }
}
