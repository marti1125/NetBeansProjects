
package service;

import dao.interfaz.IClienteDAO;
import java.util.List;


public class ClienteService {

	private IClienteDAO clienteDAO = null;

	public void setClienteDAO(IClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public List consultarClienteApellido(String apellido) throws Exception{
		return clienteDAO.consultarClienteApellido(apellido);
	}


	public void setRegistrarDAO(IClienteDAO reporteDAO) {
		this.clienteDAO = reporteDAO;
	}

	public List registrarCliente(String cliente) throws Exception{
		return clienteDAO.registrarCliente(cliente);
	}

}
