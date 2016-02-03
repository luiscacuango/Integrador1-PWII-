/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luigi
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcion.findAll", query = "SELECT f FROM Funcion f"),
    @NamedQuery(name = "Funcion.findByIdFuncion", query = "SELECT f FROM Funcion f WHERE f.idFuncion = :idFuncion"),
    @NamedQuery(name = "Funcion.findByFuncNombre", query = "SELECT f FROM Funcion f WHERE f.funcNombre = :funcNombre"),
    @NamedQuery(name = "Funcion.findByFunEstado", query = "SELECT f FROM Funcion f WHERE f.funEstado = :funEstado")})
public class Funcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FUNCION")
    private Integer idFuncion;
    @Size(max = 128)
    @Column(name = "FUNC_NOMBRE")
    private String funcNombre;
    @Size(max = 32)
    @Column(name = "FUN_ESTADO")
    private String funEstado;
    @JoinColumn(name = "ID_SECCION", referencedColumnName = "ID_SECCION")
    @ManyToOne
    private Seccion idSeccion;

    public Funcion() {
    }

    public Funcion(Integer idFuncion) {
        this.idFuncion = idFuncion;
    }

    public Integer getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(Integer idFuncion) {
        this.idFuncion = idFuncion;
    }

    public String getFuncNombre() {
        return funcNombre;
    }

    public void setFuncNombre(String funcNombre) {
        this.funcNombre = funcNombre;
    }

    public String getFunEstado() {
        return funEstado;
    }

    public void setFunEstado(String funEstado) {
        this.funEstado = funEstado;
    }

    public Seccion getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Seccion idSeccion) {
        this.idSeccion = idSeccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncion != null ? idFuncion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcion)) {
            return false;
        }
        Funcion other = (Funcion) object;
        if ((this.idFuncion == null && other.idFuncion != null) || (this.idFuncion != null && !this.idFuncion.equals(other.idFuncion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Funcion[ idFuncion=" + idFuncion + " ]";
    }
    
}
