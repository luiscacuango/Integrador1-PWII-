/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luigi
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seccion.findAll", query = "SELECT s FROM Seccion s"),
    @NamedQuery(name = "Seccion.findByIdSeccion", query = "SELECT s FROM Seccion s WHERE s.idSeccion = :idSeccion"),
    @NamedQuery(name = "Seccion.findBySeccNombre", query = "SELECT s FROM Seccion s WHERE s.seccNombre = :seccNombre"),
    @NamedQuery(name = "Seccion.findBySeccJefe", query = "SELECT s FROM Seccion s WHERE s.seccJefe = :seccJefe"),
    @NamedQuery(name = "Seccion.findBySeccEstado", query = "SELECT s FROM Seccion s WHERE s.seccEstado = :seccEstado")})
public class Seccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SECCION")
    private Integer idSeccion;
    @Size(max = 128)
    @Column(name = "SECC_NOMBRE")
    private String seccNombre;
    @Size(max = 64)
    @Column(name = "SECC_JEFE")
    private String seccJefe;
    @Size(max = 32)
    @Column(name = "SECC_ESTADO")
    private String seccEstado;
    @JoinColumn(name = "ID_DEPARTAMENTO", referencedColumnName = "ID_DEPARTAMENTO")
    @ManyToOne
    private Departamento idDepartamento;
    @OneToMany(mappedBy = "idSeccion")
    private Collection<Funcion> funcionCollection;

    public Seccion() {
    }

    public Seccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Integer getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getSeccNombre() {
        return seccNombre;
    }

    public void setSeccNombre(String seccNombre) {
        this.seccNombre = seccNombre;
    }

    public String getSeccJefe() {
        return seccJefe;
    }

    public void setSeccJefe(String seccJefe) {
        this.seccJefe = seccJefe;
    }

    public String getSeccEstado() {
        return seccEstado;
    }

    public void setSeccEstado(String seccEstado) {
        this.seccEstado = seccEstado;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @XmlTransient
    public Collection<Funcion> getFuncionCollection() {
        return funcionCollection;
    }

    public void setFuncionCollection(Collection<Funcion> funcionCollection) {
        this.funcionCollection = funcionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeccion != null ? idSeccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seccion)) {
            return false;
        }
        Seccion other = (Seccion) object;
        if ((this.idSeccion == null && other.idSeccion != null) || (this.idSeccion != null && !this.idSeccion.equals(other.idSeccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Seccion[ idSeccion=" + idSeccion + " ]";
    }
    
}
