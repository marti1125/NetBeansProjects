/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mypackage;

import javax.ejb.Local;

/**
 *
 * @author willy
 */
@Local
public interface MySessionLocal {

    String sayHello(String name);
    
}
