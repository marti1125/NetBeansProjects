
package dao.interfaz;

import dao.database.AccesoDB;
import java.util.List;

public interface IClienteDAO {

	public void setAccesoDB(AccesoDB accesoDB);
	public List consultarClienteApellido(String apellido) throws Exception;
        public List registrarCliente(String cliente) throws Exception;
 
}
