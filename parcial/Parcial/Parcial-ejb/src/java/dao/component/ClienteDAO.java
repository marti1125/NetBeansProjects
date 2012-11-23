package dao.component;

import dao.database.AccesoDB;
import dao.interfaz.IClienteDAO;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class ClienteDAO implements IClienteDAO {

    public AccesoDB accesoDB = null;

    public void setAccesoDB(AccesoDB accesoDB) {
        this.accesoDB = accesoDB;
    }

    public List consultarClienteApellido(String apellido) throws Exception {
        String query = "select cu.chr_cuencodigo as cuenta,"
                + "cu.chr_sucucodigo as sucursal,"
                + "cu.chr_monecodigo as moneda,"
                + "mo.chr_tipocodigo as tipomov,"
                + "mo.dec_moviimporte as importe "
                + "from cuenta cu inner join movimiento mo"
                + " on cu.chr_cuencodigo = mo.chr_cuencodigo"
                + " where mo.dtt_movifecha =?";
        JdbcTemplate jdbct = this.accesoDB.getJdbcTemplate();

        List consultar = (List) jdbct.queryForList(query, new Object[]{apellido});
        return consultar;
    }

    public List registrarCliente(String cliente) throws Exception {
        
              
        String query ="insert into cliente (DIS_ID,CLI_NOMBRE,CLI_APELLIDO,CLI_INGRESOS,CLI_EDAD,CLI_SEXO)"
                + " values (?,?,?,?,?,?)";   
        
        
        JdbcTemplate jdbct = this.accesoDB.getJdbcTemplate();

       List registrar = (List) jdbct.queryForList(query, new Object[]{cliente, cliente, cliente,cliente, cliente, cliente});
       System.out.println(registrar.size());

       return registrar;

        
    }

    
}











       /*
        *
        * "insert into cliente(tipo, cliente, servicio, fecha, "
                + "costo, horas, importe) values(?, ?, ?, sysdate(), ?, ?, ?)";
        *
        *
String query = "select ti.vch_tipoaccion as categoria,"
+ "sum(cu.dec_moviimporte) as importe "
+ "from movimiento cu inner join tipomovimiento ti "
+ "on cu.chr_tipocodigo = ti.chr_tipocodigo where cu.chr_cuencodigo = ? "
+ "group by categoria UNION SELECT 'TOTAL' AS categoria,(select sum(cu.dec_moviimporte) as importe "
+ "from movimiento cu inner join tipomovimiento ti "
+ "on cu.chr_tipocodigo = ti.chr_tipocodigo where cu.chr_cuencodigo = ?"
+ "and ti.vch_tipoaccion = 'INGRESO')-(select  "
+ "sum(cu.dec_moviimporte) as importe "
+ "from movimiento cu "
+ "inner join tipomovimiento ti "
+ "on cu.chr_tipocodigo = ti.chr_tipocodigo where cu.chr_cuencodigo = ?"
+ "and ti.vch_tipoaccion = 'SALIDA') AS importe;";

JdbcTemplate jdbct = this.accesoDB.getJdbcTemplate();

List reporte = (List) jdbct.queryForList(query, new Object[]{cliente, cliente, cliente});
System.out.println(reporte.size());

return reporte;

 */

