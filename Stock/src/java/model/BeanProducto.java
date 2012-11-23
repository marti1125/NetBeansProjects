package model;

/**
 *
 * @author willy
 */
public class BeanProducto {

    private String codigo;
    private String descripcion;
    private String cantidad;
    private String costo;
    private String precio;
    private String fecing;

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecing() {
        return fecing;
    }

    public void setFecing(String fecing) {
        this.fecing = fecing;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    } 
}
