/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mypackage;

import javax.ejb.Stateless;

/**
 *
 * @author willy
 */
@Stateless
public class MySession implements MySessionRemote, MySessionLocal {

    public String sayHello(String name) {
        return "Hello " + name + "!";
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
