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
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d "),
    @NamedQuery(name = "Departamento.findByIdDepartamento", query = "SELECT d FROM Departamento d WHERE d.idDepartamento = :idDepartamento"),
    @NamedQuery(name = "Departamento.findByDepaNombre", query = "SELECT d FROM Departamento d WHERE d.depaNombre = :depaNombre"),
    @NamedQuery(name = "Departamento.findByDepaJefe", query = "SELECT d FROM Departamento d WHERE d.depaJefe = :depaJefe"),
    @NamedQuery(name = "Departamento.findByDepaEstado", query = "SELECT d FROM Departamento d WHERE d.depaEstado = :depaEstado")})
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DEPARTAMENTO")
    private Integer idDepartamento;
    @Size(max = 128)
    @Column(name = "DEPA_NOMBRE")
    private String depaNombre;
    @Size(max = 64)
    @Column(name = "DEPA_JEFE")
    private String depaJefe;
    @Size(max = 32)
    @Column(name = "DEPA_ESTADO")
    private String depaEstado;
    @OneToMany(mappedBy = "idDepartamento")
    private Collection<Seccion> seccionCollection;

    public Departamento() {
    }

    public Departamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getDepaNombre() {
        return depaNombre;
    }

    public void setDepaNombre(String depaNombre) {
        this.depaNombre = depaNombre;
    }

    public String getDepaJefe() {
        return depaJefe;
    }

    public void setDepaJefe(String depaJefe) {
        this.depaJefe = depaJefe;
    }

    public String getDepaEstado() {
        return depaEstado;
    }

    public void setDepaEstado(String depaEstado) {
        this.depaEstado = depaEstado;
    }

    @XmlTransient
    public Collection<Seccion> getSeccionCollection() {
        return seccionCollection;
    }

    public void setSeccionCollection(Collection<Seccion> seccionCollection) {
        this.seccionCollection = seccionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepartamento != null ? idDepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.idDepartamento == null && other.idDepartamento != null) || (this.idDepartamento != null && !this.idDepartamento.equals(other.idDepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Departamento[ idDepartamento=" + idDepartamento + " ]";
    }
    
}
