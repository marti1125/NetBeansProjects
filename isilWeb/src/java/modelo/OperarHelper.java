/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistencia.Aula;
import persistencia.Curso;
import persistencia.Parametro;
import persistencia.Profesor;
import persistencia.Usuario;
import servicios.HibernateUtil;

/**
 *
 * @author Alumno
 */
public class OperarHelper {

    Session ayudar;
    Transaction operacion = null;
    Query consulta;
    List lista;

    public OperarHelper() {
        ayudar = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public String validar_usuario(String xusuario, String xclave) {
        String xnombre = "";
        Usuario persona = null;
        String sentencia = "from Usuario where alias='" + xusuario
                + "' and clave='" + xclave + "'";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            persona = (Usuario) consulta.uniqueResult();
            if (persona != null) {
                xnombre = persona.getNombre();
            } else {
                xnombre = "x";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return xnombre;
    }

    public List lista_docentes() {
        String xnombre = "";
        List personas = null;
        String sentencia = "from Profesor";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            personas = consulta.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return personas;
    }

    public Profesor ver_datos_docente(String cdocente) {        
        Profesor xdoc = null;
        String sentencia = "from Profesor where codProf='" + cdocente + "'";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            xdoc = (Profesor) consulta.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return xdoc;
    }

    public boolean borrar_docente(String codigo) {
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            Profesor xprof = (Profesor) ayudar.load(Profesor.class, codigo);
            ayudar.delete(xprof);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            e.printStackTrace();
        }

        return hecho;
    }

    public boolean modif_docente(Profesor docente) {
        boolean hecho = false;
        try {
            operacion = ayudar.beginTransaction();
            Profesor xprof = (Profesor) ayudar.load(Profesor.class, docente.getCodProf());
            xprof.setAnuIngr(docente.getAnuIngr());
            xprof.setDniProf(docente.getDniProf());
            xprof.setEspecialidad(docente.getEspecialidad());
            xprof.setFnacProf(docente.getFnacProf());
            xprof.setMatProf(docente.getMatProf());
            xprof.setNomProf(docente.getNomProf());
            xprof.setPatProf(docente.getPatProf());
            ayudar.update(xprof);
            operacion.commit();
            hecho = true;
        } catch (Exception e) {
            operacion.rollback();
            e.printStackTrace();
        }

        return hecho;
    }

    public String ver_sem_actual() {
        String xsem = "";
        Parametro valor = null;
        String sentencia = "from Parametro where id.parTabla=1 and id.parCod='1'";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            valor = (Parametro) consulta.uniqueResult();
            xsem = valor.getParDsc();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return xsem;
    }

    public Vector<Curso> lista_cursos() {
        Vector<Curso> tcursos = new Vector<Curso>();
        List personas = null;
        String sentencia = "from Curso";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            personas = consulta.list();
            Iterator bucle = personas.iterator();
            while (bucle.hasNext()) {
                Curso cursito = (Curso) bucle.next();
                tcursos.add(cursito);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tcursos;
    }

    public ArrayList lista_aulas() {
        ArrayList taulas = new ArrayList();
        List personas = null;
        String sentencia = "from Aula";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            personas = consulta.list();
            Iterator bucle = personas.iterator();
            while (bucle.hasNext()) {
                Aula aulita = (Aula) bucle.next();
                taulas.add(aulita);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taulas;
    }
    public String nombre_curso(String codcurso){
        Curso scurso= null;
        String sentencia = "from Curso where codCurso='"+codcurso+"'";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            scurso = (Curso) consulta.uniqueResult();
           
        } catch (Exception e) {
            e.printStackTrace();
        }

        return scurso.getNomCurso();

    }
        public String nombre_docente(String cdocente){
        Profesor sprof= null;
        String sentencia = "from Profesor where codProf='"+cdocente+"'";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            sprof = (Profesor) consulta.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sprof.nombre_completo();

    }

    public boolean agregar_curso(Curso xcurso) {
        boolean hecho= false;
        try{
            operacion= ayudar.beginTransaction();
            ayudar.save(xcurso);
            operacion.commit();
            hecho=true;
        }catch(Exception e ){
            operacion.rollback();
            e.printStackTrace();
        }

        return hecho;
    }

    public Curso buscar_curso(String codigo) {
        Curso xdoc = null;
        String sentencia = "from Curso where codCurso='"+codigo+"'";
        try {
            operacion = ayudar.beginTransaction();
            consulta = ayudar.createQuery(sentencia);
            xdoc = (Curso) consulta.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return xdoc;
    }
}
