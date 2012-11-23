/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente.bean;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nuna
 */
@Local
public interface ClienteBeanLocal {
    List consultarClienteApellido(String apellido) throws Exception;
    List registrarCliente(String cliente) throws Exception;

}
