/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import prueba.Usuarios;
import servicio.HibernateUtil;

/**
 *
 * @author familia
 */
public class OperarHelper {

    Session ayudar;
    Transaction operacion = null;
    Query consulta;
    List lista;

    public OperarHelper() {
        ayudar = HibernateUtil.getSessionFactory().getCurrentSession();
    }


    public String verificarUsuario(String cUsuario, String cPassword){
        String xcodigo = "";
        Usuarios xusu = null;
        String _sentencia = "from Usuarios where Usuarios='" + cUsuario + "' and Password='" + cPassword + "'";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(_sentencia);
            xusu = (Usuarios)consulta.uniqueResult();
            if (xusu != null) {
                xcodigo = xusu.getUsuario();
            } else {
                xcodigo = "x";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xcodigo;
    }  
    
}
