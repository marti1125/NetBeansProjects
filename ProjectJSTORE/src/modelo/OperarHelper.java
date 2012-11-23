/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import jstore.Producto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import servicios.HibernateUtil;
import jstore.Usuario;

/**
 *
 * @author Willy Aguirre
 */
public class OperarHelper {

    Session ayudar;
    Transaction operacion = null;
    Query consulta;
    List lista;

    public OperarHelper() {
        ayudar = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    //validar usuario
    public boolean validarUsuario(String usuario, String clave) {
        boolean hecho = false;
        Usuario user = null;
        String sentencia = "from Usuario where usuario='" + usuario
                + "' and clave='" + clave + "'";
        try {

            operacion = ayudar.beginTransaction();
            List<Usuario> listaUsuarios = (List<Usuario>) ayudar.createQuery(sentencia).list();
            if (!listaUsuarios.isEmpty()) {
                user = listaUsuarios.get(0);
                hecho = true;
            } else {
                System.out.println("fracaso");
            }

        } catch (Exception e) {
            System.out.println("error");
        }
        return hecho;
    }

    //lista de usuarios
    public List ListaUsuarios(){
        List usuarios = null;
        String sentencia = "from Usuario";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            usuarios = consulta.list();
        } catch (Exception e) {
            System.out.println(e);
        }
        return usuarios;
    }

    //agregar usuario
    boolean agregarUsuario(Usuario u) {
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            ayudar.save(u);
            operacion.commit();
        } catch (Exception e) {
            operacion.rollback();
            System.out.println(e);
        }
        return hecho;
    }

    //traer Usuario por codigo
    public Usuario TraerUsuario(String codigoUsuario) {
        Usuario xcod = null;
        String sentencia = "from Usuario where codigoUsuario='" + codigoUsuario + "'";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            xcod = (Usuario) consulta.uniqueResult();
        } catch (Exception e) {
            System.out.println(e);
        }
        return xcod;
    }

    //actualizar Usuario
    public boolean actualizarUsuario(Usuario u){
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            Usuario xp = (Usuario) ayudar.load(Usuario.class, u.getCodigoUsuario());
            xp.setClave(u.getClave());
            xp.setNombre(u.getNombre());
            xp.setApellido(u.getApellido());
            xp.setEmail(u.getEmail());
            ayudar.update(xp);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            System.out.println(e);
        }
        return hecho;
    }

    //tabla producto
    //agregar Producto
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

    //lista de productos
    public List ListaProductos(){
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

    //traer Producto por codigo
    public Producto TraerProducto(String codigoProducto) {
        Producto xcod = null;
        String sentencia = "from Producto where codigoProducto='" + codigoProducto + "'";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            xcod = (Producto) consulta.uniqueResult();
        } catch (Exception e) {
            System.out.println(e);
        }
        return xcod;
    }

    //actualizar Producto
    public boolean actualizarProducto(Producto u){
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            Producto xp = (Producto) ayudar.load(Producto.class, u.getCodigoProducto());
            xp.setCodigoProducto(u.getCodigoProducto());
            xp.setPresentacion(u.getPresentacion());
            ayudar.update(xp);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            System.out.println(e);
        }
        return hecho;
    }
}
