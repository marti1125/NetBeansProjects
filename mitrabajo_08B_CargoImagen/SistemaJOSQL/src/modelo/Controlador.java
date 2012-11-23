/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.beans.*;
import java.io.Serializable;
import java.util.List;
import joyeria.DetalleIngreso;
import joyeria.Familia;
import joyeria.Ingreso;
import joyeria.Producto;
import joyeria.Proveedor;
import joyeria.TipoDocumentos;
import joyeria.Vendedor;

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

    //la tabla Familia
    public boolean actualizar_familia(Familia familia) {
        return operar.modif_familia(familia);
    }

    public boolean eliminar_familia(int codigo) {
        return operar.borrar_familia(codigo);
    }

    public List relacion_familia() {
        return operar.lista_familia();
    }

    public Familia datos_familia(String cfamilia) {
        return operar.ver_datos_familia(cfamilia);
    }

    public boolean insertar_familia(Familia xfamilia) {
        return operar.agregar_familia(xfamilia);

    }

    //tabla TipoDocumento
    public boolean actualizar_tipdoc(TipoDocumentos tipdoc) {
        return operar.modif_tipdoc(tipdoc);
    }

    public boolean eliminar_tipdoc(int codigod) {
        return operar.borrar_tipodoc(codigod);
    }

    public List relacion_tipdoc() {
        return operar.lista_tipdoc();
    }

    public TipoDocumentos datos_tipdoc(String ctipdoc) {
        return operar.ver_datos_tipdoc(ctipdoc);
    }

    public boolean insertar_tipdoc(TipoDocumentos xtipdoc) {
        return operar.agregar_TipDoc(xtipdoc);

    }

    //tabla Proveedor
    public boolean actualizar_proveedor(Proveedor proveedor) {
        return operar.modif_proveedor(proveedor);
    }

    public boolean eliminar_proveedor(String codigop) {
        return operar.borrar_proveedor(codigop);
    }

    public List relacion_proveedor() {
        return operar.lista_Proveedor();
    }

    public Proveedor datos_proveedor(String cproveedor) {
        return operar.ver_datos_proveedor(cproveedor);
    }

    public boolean insertar_proveedor(Proveedor xprove) {
        return operar.agregar_proveedor(xprove);

    }

    //tabla Producto
    public boolean actualizar_producto(Producto producto) {
        return operar.modif_producto(producto);
    }

    public boolean eliminar_producto(int codigopr) {
        return operar.borrar_producto(codigopr);
    }

    public List relacion_producto() {
        return operar.lista_producto();
    }

    public Producto datos_producto(String cproducto) {
        return operar.ver_datos_producto(cproducto);
    }

    public boolean insertar_producto(Producto xproduc) {
        return operar.agregar_producto(xproduc);

    }

    //tabla Vendedor
    public boolean actualizar_vendedor(Vendedor vendedor) {
        return operar.modif_vendedor(vendedor);
    }

    public boolean eliminar_vendedor(int codigov) {
        return operar.borrar_vendedor(codigov);
    }

    public List relacion_vendedor() {
        return operar.lista_vendedor();
    }

    public Vendedor datos_vendedor(String cvendedor) {
        return operar.ver_datos_vendedor(cvendedor);
    }

    public boolean insertar_vendedor(Vendedor xvend) {
        return operar.agregar_vendedor(xvend);

    }

    //Tabla Ingreso y Ingreso.Detalle
    public boolean insertar_delingreso(DetalleIngreso xdel) {
        return operar.agregar_delingreso(xdel);

    }

    public boolean insertar_ingreso(Ingreso xing) {
        return operar.agregar_Ingreso(xing);

    }
}
