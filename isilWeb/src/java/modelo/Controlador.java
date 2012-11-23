/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import persistencia.Curso;
import persistencia.Profesor;

/**
 *
 * @author Alumno
 */
public class Controlador implements Serializable {

    OperarHelper operar;
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    private String sampleProperty;
    private PropertyChangeSupport propertySupport;

    public Controlador() {
        propertySupport = new PropertyChangeSupport(this);
        operar = new OperarHelper();
    }

    public String getSampleProperty() {
        return sampleProperty;
    }

    public void setSampleProperty(String value) {
        String oldValue = sampleProperty;
        sampleProperty = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

    public String recoger_nombre(String xusuario, String xclave) {
        return operar.validar_usuario(xusuario, xclave);
    }

    public List relacion_profes() {
        return operar.lista_docentes();
    }

    public Profesor datos_profesor(String cdocente) {
        return operar.ver_datos_docente(cdocente);
    }

    public boolean eliminar_docente(String codigo) {
        return operar.borrar_docente(codigo);
    }

    public boolean actualizar_docente(Profesor docente) {
        return operar.modif_docente(docente);
    }
    public String ver_semestre_actual(){
        return operar.ver_sem_actual();
    }
    public Vector<Curso> relacion_cursos(){
      return operar.lista_cursos();
    }
    public List relacion_docentes(){
        return operar.lista_docentes();
    }
    public ArrayList relacion_aulas(){
        return operar.lista_aulas();
    }
    public Vector<String[]> lista_ciclos(){
        String[] nciclo={"","Primer","Segundo","Tercer","Cuarto","Quinto","Sexto",
        "Setimo","Octavo","Noveno","Decimo"};
        Vector<String[]> listado= new Vector<String[]>();
        for(int j=1;j<=10;j++){
           String[] xciclo= new String[2];
           xciclo[0]=""+j;
           xciclo[1]=nciclo[j]+" Ciclo";
           listado.add(xciclo);
        }

        return listado;
    }
    public boolean insertar_curso(Curso xcurso){
        return operar.agregar_curso(xcurso);
    }
}
