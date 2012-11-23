/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import joyeria.DetalleIngreso;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import joyeria.Familia;
import joyeria.Ingreso;
import joyeria.Producto;
import joyeria.Proveedor;
import joyeria.TipoDocumentos;
import joyeria.Vendedor;
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

    //tabla Familia
    public boolean modif_familia(Familia familia) {
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            Familia xfam = (Familia) ayudar.load(Familia.class, familia.getIdFamilia());
            xfam.setDescripcion(familia.getDescripcion());
            xfam.setEstado(familia.getEstado());
            ayudar.update(xfam);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            e.printStackTrace();
        }

        return hecho;
    }

    public boolean borrar_familia(int codigo) {
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            Familia xfam = (Familia) ayudar.load(Familia.class, codigo);
            ayudar.delete(xfam);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            e.printStackTrace();
        }

        return hecho;
    }

    public List lista_familia() {
        //String xnombre = "";
        List familias = null;
        String sentencia = "from Familia";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            familias = consulta.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return familias;
    }

    public Familia ver_datos_familia(String cfamilia) {
        //String xnombre = "";
        Familia xdoc = null;
        String sentencia = "from Familia where IdFamilia='" + cfamilia + "'";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            xdoc = (Familia) consulta.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return xdoc;
    }

    boolean agregar_familia(Familia xfamilia) {
        boolean hecho = false;

        try {
            operacion = ayudar.beginTransaction();
            ayudar.save(xfamilia);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            e.printStackTrace();
        }

        return hecho;
    }

    //tabla Tipo Documento
    public boolean modif_tipdoc(TipoDocumentos tipdoc) {
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            TipoDocumentos xtipdoc = (TipoDocumentos) ayudar.load(TipoDocumentos.class, tipdoc.getIdTipoDoc());
            xtipdoc.setDescripcion(tipdoc.getDescripcion());
            ayudar.update(xtipdoc);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            e.printStackTrace();
        }

        return hecho;
    }

    public boolean borrar_tipodoc(int codigod) {
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            TipoDocumentos xtipdoc = (TipoDocumentos) ayudar.load(TipoDocumentos.class, codigod);
            ayudar.delete(xtipdoc);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            e.printStackTrace();
        }

        return hecho;
    }

    public TipoDocumentos ver_datos_tipdoc(String ctipdoc) {
        //String xnombre = "";
        TipoDocumentos xtipdoc = null;
        String sentencia = "from TipoDocumentos where IdTipoDoc='" + ctipdoc + "'";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            xtipdoc = (TipoDocumentos) consulta.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return xtipdoc;
    }

    public List lista_tipdoc() {
        //String xnombre = "";
        List tipdoc = null;
        String sentencia = "from TipoDocumentos";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            tipdoc = consulta.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tipdoc;
    }

    boolean agregar_TipDoc(TipoDocumentos xtipdoc) {
        boolean hecho = false;

        try {
            operacion = ayudar.beginTransaction();
            ayudar.save(xtipdoc);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            e.printStackTrace();
        }

        return hecho;
    }

    //Tabla Proveedor
    public boolean modif_proveedor(Proveedor proveedor) {
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            Proveedor xprov = (Proveedor) ayudar.load(Proveedor.class, proveedor.getIdProveedor());
            xprov.setNombre(proveedor.getNombre());
            xprov.setDireccion(proveedor.getDireccion());
            xprov.setCodPostal(proveedor.getCodPostal());
            xprov.setProvincia(proveedor.getProvincia());
            xprov.setDepartamento(proveedor.getDepartamento());
            xprov.setPais(proveedor.getPais());
            xprov.setEmail(proveedor.getEmail());
            ayudar.update(xprov);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            e.printStackTrace();
        }

        return hecho;
    }

    public boolean borrar_proveedor(String codigop) {
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            Proveedor xprov = (Proveedor) ayudar.load(Proveedor.class, codigop);
            ayudar.delete(xprov);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            e.printStackTrace();
        }

        return hecho;
    }

    public List lista_Proveedor() {
        //String xnombre = "";
        List proveedores = null;
        String sentencia = "from Proveedor";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            proveedores = consulta.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return proveedores;
    }

    public Proveedor ver_datos_proveedor(String cproveedor) {
        //String xnombre = "";
        Proveedor xprov = null;
        String sentencia = "from Proveedor where IdProveedor='" + cproveedor + "'";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            xprov = (Proveedor) consulta.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return xprov;
    }

    boolean agregar_proveedor(Proveedor xprove) {
        boolean hecho = false;

        try {
            operacion = ayudar.beginTransaction();
            ayudar.save(xprove);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            e.printStackTrace();
        }

        return hecho;
    }

    //Tabla Producto
    public boolean modif_producto(Producto producto) {
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            Producto xproc = (Producto) ayudar.load(Producto.class, producto.getIdProducto());
            xproc.setDescripcion(producto.getDescripcion());
            xproc.setFamilia(producto.getFamilia());
            xproc.setFechaDeRegistro(producto.getFechaDeRegistro());
            xproc.setFechaDeBaja(producto.getFechaDeBaja());
            xproc.setEstado(producto.getEstado());
            xproc.setFoto(producto.getFoto());
            ayudar.update(xproc);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            e.printStackTrace();
        }

        return hecho;
    }

    public boolean borrar_producto(int codigopr) {
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            Producto xproc = (Producto) ayudar.load(Producto.class, codigopr);
            ayudar.delete(xproc);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            e.printStackTrace();
        }

        return hecho;
    }

    public List lista_producto() {
        //String xnombre = "";
        List productos = null;
        String sentencia = "from Producto";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            productos = consulta.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return productos;
    }

    public Producto ver_datos_producto(String cproducto) {
        //String xnombre = "";
        Producto xproc = null;
        String sentencia = "from Producto where IdProducto='" + cproducto + "'";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            xproc = (Producto) consulta.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return xproc;
    }

    boolean agregar_producto(Producto xproduc) {
        boolean hecho = false;

        try {
            operacion = ayudar.beginTransaction();
            ayudar.save(xproduc);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            e.printStackTrace();
        }

        return hecho;
    }

    //Tabla Vendedor
    public boolean modif_vendedor(Vendedor vendedor) {
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            Vendedor xvend = (Vendedor) ayudar.load(Vendedor.class, vendedor.getIdVendedor());
            xvend.setTipoDocumentos(vendedor.getTipoDocumentos());
            xvend.setNroDocumento(vendedor.getNroDocumento());
            xvend.setNombre(vendedor.getNombre());
            xvend.setTelefono1(vendedor.getTelefono1());
            xvend.setTelefono2(vendedor.getTelefono2());
            xvend.setCodPostal(vendedor.getCodPostal());
            xvend.setDireccion(vendedor.getDireccion());
            xvend.setProvincia(vendedor.getProvincia());
            xvend.setDepartamento(vendedor.getDepartamento());
            xvend.setPais(vendedor.getPais());
            xvend.setFechaIngreso(vendedor.getFechaIngreso());
            xvend.setFechaCese(vendedor.getFechaCese());
            xvend.setEmail(vendedor.getEmail());
            ayudar.update(xvend);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            e.printStackTrace();
        }

        return hecho;
    }

    public boolean borrar_vendedor(int codigov) {
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            Vendedor xvend = (Vendedor) ayudar.load(Vendedor.class, codigov);
            ayudar.delete(xvend);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            e.printStackTrace();
        }

        return hecho;
    }

    public List lista_vendedor() {
        //String xnombre = "";
        List vendedores = null;
        String sentencia = "from Vendedor";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            vendedores = consulta.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendedores;
    }

    public Vendedor ver_datos_vendedor(String cvendedor) {
        //String xnombre = "";
        Vendedor xvend = null;
        String sentencia = "from Vendedor where IdVendedor='" + cvendedor + "'";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            xvend = (Vendedor) consulta.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return xvend;
    }

    boolean agregar_vendedor(Vendedor xvend) {
        boolean hecho = false;

        try {
            operacion = ayudar.beginTransaction();
            ayudar.save(xvend);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            e.printStackTrace();
        }

        return hecho;
    }

    //Tabla Ingreso y Ingreso.Detalle
    boolean agregar_delingreso(DetalleIngreso xdel) {
        boolean hecho = false;

        try {
            operacion = ayudar.beginTransaction();
            ayudar.save(xdel);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            e.printStackTrace();
        }

        return hecho;
    }

    boolean agregar_Ingreso(Ingreso xing) {
        boolean hecho = false;

        try {
            operacion = ayudar.beginTransaction();
            ayudar.save(xing);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            e.printStackTrace();
        }

        return hecho;
    }
}
