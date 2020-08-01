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
@Table(name = "forma_de_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormaDePago.findAll", query = "SELECT f FROM FormaDePago f")
    , @NamedQuery(name = "FormaDePago.findByIdFormapago", query = "SELECT f FROM FormaDePago f WHERE f.idFormapago = :idFormapago")
    , @NamedQuery(name = "FormaDePago.findByDescripcionformapago", query = "SELECT f FROM FormaDePago f WHERE f.descripcionformapago = :descripcionformapago")})
public class FormaDePago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_formapago")
    private Integer idFormapago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Descripcion_formapago")
    private String descripcionformapago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFormapago")
    private Collection<Factura> facturaCollection;

    public FormaDePago() {
    }

    public FormaDePago(Integer idFormapago) {
        this.idFormapago = idFormapago;
    }

    public FormaDePago(Integer idFormapago, String descripcionformapago) {
        this.idFormapago = idFormapago;
        this.descripcionformapago = descripcionformapago;
    }

    public Integer getIdFormapago() {
        return idFormapago;
    }

    public void setIdFormapago(Integer idFormapago) {
        this.idFormapago = idFormapago;
    }

    public String getDescripcionformapago() {
        return descripcionformapago;
    }

    public void setDescripcionformapago(String descripcionformapago) {
        this.descripcionformapago = descripcionformapago;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormapago != null ? idFormapago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaDePago)) {
            return false;
        }
        FormaDePago other = (FormaDePago) object;
        if ((this.idFormapago == null && other.idFormapago != null) || (this.idFormapago != null && !this.idFormapago.equals(other.idFormapago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.FormaDePago[ idFormapago=" + idFormapago + " ]";
    }
    
}
