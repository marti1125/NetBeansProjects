/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package desktopapplication1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author willy
 */
@Entity
@Table(name = "producto", catalog = "empresa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByCodigo", query = "SELECT p FROM Producto p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Producto.findByCantidad", query = "SELECT p FROM Producto p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Producto.findByCosto", query = "SELECT p FROM Producto p WHERE p.costo = :costo"),
    @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio"),
    @NamedQuery(name = "Producto.findByFecing", query = "SELECT p FROM Producto p WHERE p.fecing = :fecing")})
public class Producto implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "costo")
    private Double costo;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "fecing")
    private String fecing;

    public Producto() {
    }

    public Producto(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        Integer oldCodigo = this.codigo;
        this.codigo = codigo;
        changeSupport.firePropertyChange("codigo", oldCodigo, codigo);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        String oldDescripcion = this.descripcion;
        this.descripcion = descripcion;
        changeSupport.firePropertyChange("descripcion", oldDescripcion, descripcion);
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        Integer oldCantidad = this.cantidad;
        this.cantidad = cantidad;
        changeSupport.firePropertyChange("cantidad", oldCantidad, cantidad);
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        Double oldCosto = this.costo;
        this.costo = costo;
        changeSupport.firePropertyChange("costo", oldCosto, costo);
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        Double oldPrecio = this.precio;
        this.precio = precio;
        changeSupport.firePropertyChange("precio", oldPrecio, precio);
    }

    public String getFecing() {
        return fecing;
    }

    public void setFecing(String fecing) {
        String oldFecing = this.fecing;
        this.fecing = fecing;
        changeSupport.firePropertyChange("fecing", oldFecing, fecing);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "desktopapplication1.Producto[codigo=" + codigo + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
