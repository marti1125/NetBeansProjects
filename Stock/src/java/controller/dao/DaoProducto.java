package controller.dao;

import com.sql.Sql;
import model.BeanProducto;
/**
 *
 * @author willy
 */
public class DaoProducto {

    public static String insert(BeanProducto producto){
        String sql = "insert into producto(descripcion,cantidad,costo,precio,fecing)"
                + "values('" + producto.getDescripcion() + "', " + producto.getCantidad() + ","
                + " " + producto.getCosto() + "," + producto.getPrecio() + ", '" + producto.getFecing() + "')";
        return Sql.ejecuta(sql);
    }

    public static String delete(BeanProducto producto){
        String sql = "delete from producto where codigo =" + producto.getCodigo();
        return Sql.ejecuta(sql);
    }

    public static String update(BeanProducto producto){
        String sql = "update producto set descripcion='" + producto.getDescripcion() + "', cantidad= " + producto.getCantidad() + ","
                + " costo=" + producto.getCosto() + ", precio=" + producto.getPrecio() + ", fecing='" + producto.getFecing() + "'";
        return Sql.ejecuta(sql);
    }

    public static BeanProducto getCodigo(String codigo){
        BeanProducto producto =  null;
        Object[] fila = Sql.getFila("select * from producto where codigo=" + codigo);
        if(fila != null){
            producto = new BeanProducto();
            producto.setDescripcion(fila[0].toString());
            producto.setCantidad(fila[1].toString());
            producto.setCosto(fila[2].toString());
            producto.setPrecio(fila[3].toString());
            producto.setFecing(fila[4].toString());
        }
        return producto;
    }
}
