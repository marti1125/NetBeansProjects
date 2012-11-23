/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBean;

import javax.ejb.Stateless;

/**
 *
 * @author willy
 */
@Stateless
public class MyOwnEJB30SessionBean implements MyOwnEJB30SessionBeanRemote, MyOwnEJB30SessionBeanLocal {

    public int addNumber(int x, int y) {
        return (x+y);
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
