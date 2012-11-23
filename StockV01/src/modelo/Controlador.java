/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import productos.Producto;
import java.beans.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author familia
 */
public class Controlador implements Serializable {

    OperarHelper operar;
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    private String sampleProperty;
    private PropertyChangeSupport propertySupport;

    public Controlador() {
        propertySupport = new PropertyChangeSupport(this);
        operar = new OperarHelper();
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

    //tabla producto
    public boolean insertarProducto(Producto p){
        return operar.agregarProducto(p);
    }

    public Producto datosProducto(String codigo){
        return operar.verDatosProductos(codigo);
    }

    public boolean modificarProducto(Producto p){
        return operar.actualizarProducto(p);
    }
    
    public List traerProductos(){
        return operar.listaProducto();
    }
}
