/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente.bean;


import java.util.List;
import javax.ejb.Stateless;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.ClienteService;


/**
 *
 * @author Nuna
 */
@Stateless
public class ClienteBean implements ClienteBeanLocal {
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public List consultarClienteApellido(String apellido)throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/service/SpringDAO.xml");
		ClienteService service = (ClienteService) ctx.getBean("clienteService");
		return service.consultarClienteApellido(apellido);
	}

       public List registrarCliente(String cliente) throws Exception {
                ApplicationContext ctx = new ClassPathXmlApplicationContext("/service/SpringDAO.xml");
		ClienteService service = (ClienteService) ctx.getBean("clienteService");
		return service.registrarCliente(cliente);
    }
 
}
