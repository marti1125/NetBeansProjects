package jstore;
// Generated 24/11/2010 08:39:34 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * ContactoEstado generated by hbm2java
 */
public class ContactoEstado  implements java.io.Serializable {


     private Integer codigoContactoEstado;
     private Contacto contacto;
     private Date fecIngreso;
     private Date fecSalida;
     private String estado;

    public ContactoEstado() {
    }

    public ContactoEstado(Contacto contacto, Date fecIngreso, Date fecSalida, String estado) {
       this.contacto = contacto;
       this.fecIngreso = fecIngreso;
       this.fecSalida = fecSalida;
       this.estado = estado;
    }
   
    public Integer getCodigoContactoEstado() {
        return this.codigoContactoEstado;
    }
    
    public void setCodigoContactoEstado(Integer codigoContactoEstado) {
        this.codigoContactoEstado = codigoContactoEstado;
    }
    public Contacto getContacto() {
        return this.contacto;
    }
    
    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }
    public Date getFecIngreso() {
        return this.fecIngreso;
    }
    
    public void setFecIngreso(Date fecIngreso) {
        this.fecIngreso = fecIngreso;
    }
    public Date getFecSalida() {
        return this.fecSalida;
    }
    
    public void setFecSalida(Date fecSalida) {
        this.fecSalida = fecSalida;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


