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
@Table(name = "tipo_articulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoArticulo.findAll", query = "SELECT t FROM TipoArticulo t")
    , @NamedQuery(name = "TipoArticulo.findByIdTipoarticulo", query = "SELECT t FROM TipoArticulo t WHERE t.idTipoarticulo = :idTipoarticulo")
    , @NamedQuery(name = "TipoArticulo.findByDescripcionArticulo", query = "SELECT t FROM TipoArticulo t WHERE t.descripcionArticulo = :descripcionArticulo")})
public class TipoArticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipoarticulo")
    private Integer idTipoarticulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "descripcion_articulo")
    private String descripcionArticulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipoArticulo")
    private Collection<Articulo> articuloCollection;

    public TipoArticulo() {
    }

    public TipoArticulo(Integer idTipoarticulo) {
        this.idTipoarticulo = idTipoarticulo;
    }

    public TipoArticulo(Integer idTipoarticulo, String descripcionArticulo) {
        this.idTipoarticulo = idTipoarticulo;
        this.descripcionArticulo = descripcionArticulo;
    }

    public Integer getIdTipoarticulo() {
        return idTipoarticulo;
    }

    public void setIdTipoarticulo(Integer idTipoarticulo) {
        this.idTipoarticulo = idTipoarticulo;
    }

    public String getDescripcionArticulo() {
        return descripcionArticulo;
    }

    public void setDescripcionArticulo(String descripcionArticulo) {
        this.descripcionArticulo = descripcionArticulo;
    }

    @XmlTransient
    public Collection<Articulo> getArticuloCollection() {
        return articuloCollection;
    }

    public void setArticuloCollection(Collection<Articulo> articuloCollection) {
        this.articuloCollection = articuloCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoarticulo != null ? idTipoarticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoArticulo)) {
            return false;
        }
        TipoArticulo other = (TipoArticulo) object;
        if ((this.idTipoarticulo == null && other.idTipoarticulo != null) || (this.idTipoarticulo != null && !this.idTipoarticulo.equals(other.idTipoarticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TipoArticulo[ idTipoarticulo=" + idTipoarticulo + " ]";
    }
    
}
