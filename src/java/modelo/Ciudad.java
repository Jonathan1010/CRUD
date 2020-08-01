/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
    , @NamedQuery(name = "Ciudad.findByCodigociudad", query = "SELECT c FROM Ciudad c WHERE c.codigociudad = :codigociudad")
    , @NamedQuery(name = "Ciudad.findByNombreciudad", query = "SELECT c FROM Ciudad c WHERE c.nombreciudad = :nombreciudad")})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Codigo_ciudad")
    private Integer codigociudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nombre_ciudad")
    private String nombreciudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCiudad")
    private Collection<Cliente> clienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCiudad")
    private Collection<Proveedor> proveedorCollection;

    public Ciudad() {
    }

    public Ciudad(Integer codigociudad) {
        this.codigociudad = codigociudad;
    }

    public Ciudad(Integer codigociudad, String nombreciudad) {
        this.codigociudad = codigociudad;
        this.nombreciudad = nombreciudad;
    }

    public Integer getCodigociudad() {
        return codigociudad;
    }

    public void setCodigociudad(Integer codigociudad) {
        this.codigociudad = codigociudad;
    }

    public String getNombreciudad() {
        return nombreciudad;
    }

    public void setNombreciudad(String nombreciudad) {
        this.nombreciudad = nombreciudad;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @XmlTransient
    public Collection<Proveedor> getProveedorCollection() {
        return proveedorCollection;
    }

    public void setProveedorCollection(Collection<Proveedor> proveedorCollection) {
        this.proveedorCollection = proveedorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigociudad != null ? codigociudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.codigociudad == null && other.codigociudad != null) || (this.codigociudad != null && !this.codigociudad.equals(other.codigociudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ciudad[ codigociudad=" + codigociudad + " ]";
    }
    
}
