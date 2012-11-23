/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author UNI
 */
public class Cursoprog implements Serializable {
    private String semestre;
    private String codcurso;
    private String codprof;
    private String codaula;
    private String horario;
    private int grupo;
    private int vacantes;
    private String nomcurso;
    private String nomprof;
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";

    private String sampleProperty;

    private PropertyChangeSupport propertySupport;

    public Cursoprog() {
        propertySupport = new PropertyChangeSupport(this);
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

    /**
     * @return the semestre
     */
    public String getSemestre() {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    /**
     * @return the codcurso
     */
    public String getCodcurso() {
        return codcurso;
    }

    /**
     * @param codcurso the codcurso to set
     */
    public void setCodcurso(String codcurso) {
        this.codcurso = codcurso;
    }

    /**
     * @return the codprof
     */
    public String getCodprof() {
        return codprof;
    }

    /**
     * @param codprof the codprof to set
     */
    public void setCodprof(String codprof) {
        this.codprof = codprof;
    }

    /**
     * @return the codaula
     */
    public String getCodaula() {
        return codaula;
    }

    /**
     * @param codaula the codaula to set
     */
    public void setCodaula(String codaula) {
        this.codaula = codaula;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the grupo
     */
    public int getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    /**
     * @return the vacantes
     */
    public int getVacantes() {
        return vacantes;
    }

    /**
     * @param vacantes the vacantes to set
     */
    public void setVacantes(int vacantes) {
        this.vacantes = vacantes;
    }

    /**
     * @return the nomcurso
     */
    public String getNomcurso() {
        return nomcurso;
    }

    /**
     * @param nomcurso the nomcurso to set
     */
    public void setNomcurso(String nomcurso) {
        this.nomcurso = nomcurso;
    }

    /**
     * @return the nomprof
     */
    public String getNomprof() {
        return nomprof;
    }

    /**
     * @param nomprof the nomprof to set
     */
    public void setNomprof(String nomprof) {
        this.nomprof = nomprof;
    }
    public void completar(){
        OperarHelper trabajo= new OperarHelper();
        this.setNomcurso(trabajo.nombre_curso(this.codcurso));
        this.setNomprof(trabajo.nombre_docente(this.codprof));
    }


}
