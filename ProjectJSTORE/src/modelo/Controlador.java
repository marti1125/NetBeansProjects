/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.beans.*;
import java.io.Serializable;
import java.util.List;
import jstore.Producto;
import jstore.Usuario;

/**
 *
 * @author Willy Aguirre
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

    //Tabla Usuario
    //Validad Usuario
    public boolean verificarUsusario(String usuario, String clave) {
        return operar.validarUsuario(usuario, clave);
    }

    //traer datos de usuario
    public List mostrarUsusarios(){
        return operar.ListaUsuarios();
    }

    //añadir usuario
    public boolean insertarUsuario(Usuario u){
        return operar.agregarUsuario(u);
    }

    //traer datos de usuario por codigo
    public Usuario datosUsuario(String codigoUsuario){
        return operar.TraerUsuario(codigoUsuario);
    }

    //actualizar usuario
    public boolean modificarUsuario(Usuario u){
        return operar.actualizarUsuario(u);
    }

    //Tabla Producto
    //añadir producto
    public boolean insertarProducto(Producto p){
        return operar.agregarProducto(p);
    }

    //traer datos de producto
    public List mostrarProductos(){
        return operar.ListaProductos();
    }
}
