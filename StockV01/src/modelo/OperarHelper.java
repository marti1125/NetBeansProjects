/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import productos.Producto;
import java.util.List;
import java.util.Vector;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import servicios.HibernateUtil;

/**
 *
 * @author familia
 */
public class OperarHelper {

    Session ayudar;
    Transaction operacion = null;
    Query consulta;
    List lista;

    public OperarHelper() {
        ayudar = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    //tabla producto insertar
    boolean agregarProducto(Producto p) {
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            ayudar.save(p);
            operacion.commit();
        } catch (Exception e) {
            operacion.rollback();
            System.out.println(e);
        }
        return hecho;
    }

    //tabla producto verdatos
    public Producto verDatosProductos(String codigo) {
        Producto xcod = null;
        String sentencia = "from Producto where codigo='" + codigo + "'";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            xcod = (Producto) consulta.uniqueResult();
        } catch (Exception e) {
            System.out.println(e);
        }
        return xcod;
    }

    //tabla producto actualizar
    public boolean actualizarProducto(Producto p){
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            Producto xp = (Producto) ayudar.load(Producto.class, p.getCodigo());
            xp.setDescripcion(p.getDescripcion());
            xp.setCategoria(p.getCategoria());
            xp.setCantidad(p.getCantidad());
            xp.setCosto(p.getCosto());
            xp.setPrecio(p.getPrecio());
            xp.setFecing(p.getFecing());
            xp.setEstado(p.getEstado());
            ayudar.update(xp);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            System.out.println(e);
        }
        return hecho;
    }

    //tabla producto lista de productos
    public List listaProducto() {
        List productos = null;
        String sentencia = "from Producto";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            productos = consulta.list();

        } catch (Exception e) {
            System.out.println(e);
        }

        return productos;
    }

}
