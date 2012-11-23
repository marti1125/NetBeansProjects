/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.beans.*;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author UNI
 */
public class Carrito implements Serializable {

    LinkedList<Cursoprog> canasta;
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    private String sampleProperty;
    private PropertyChangeSupport propertySupport;

    public Carrito() {
        propertySupport = new PropertyChangeSupport(this);
        canasta = new LinkedList<Cursoprog>();
    }

    public void agregar(Cursoprog xcurso) {
        canasta.add(xcurso);
    }

    public LinkedList<Cursoprog> descargar() {
        return canasta;
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
}
