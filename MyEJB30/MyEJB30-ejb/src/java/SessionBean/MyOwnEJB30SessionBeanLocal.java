/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBean;

import javax.ejb.Local;

/**
 *
 * @author willy
 */
@Local
public interface MyOwnEJB30SessionBeanLocal {

    int addNumber(int x, int y);
    
}
