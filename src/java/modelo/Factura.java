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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByNnmfactura", query = "SELECT f FROM Factura f WHERE f.nnmfactura = :nnmfactura")
    , @NamedQuery(name = "Factura.findByNombreempleado", query = "SELECT f FROM Factura f WHERE f.nombreempleado = :nombreempleado")
    , @NamedQuery(name = "Factura.findByFechafacturacion", query = "SELECT f FROM Factura f WHERE f.fechafacturacion = :fechafacturacion")
    , @NamedQuery(name = "Factura.findByTotalFactura", query = "SELECT f FROM Factura f WHERE f.totalFactura = :totalFactura")
    , @NamedQuery(name = "Factura.findByIva", query = "SELECT f FROM Factura f WHERE f.iva = :iva")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Nnm_factura")
    private String nnmfactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nombre_empleado")
    private String nombreempleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Fecha_facturacion")
    private String fechafacturacion;
    @Column(name = "total_factura")
    private Long totalFactura;
    @Column(name = "IVA")
    private Long iva;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "Documento")
    @ManyToOne(optional = false)
    private Cliente codCliente;
    @JoinColumn(name = "cod_formapago", referencedColumnName = "id_formapago")
    @ManyToOne(optional = false)
    private FormaDePago codFormapago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private Collection<DetalleFactura> detalleFacturaCollection;

    public Factura() {
    }

    public Factura(String nnmfactura) {
        this.nnmfactura = nnmfactura;
    }

    public Factura(String nnmfactura, String nombreempleado, String fechafacturacion) {
        this.nnmfactura = nnmfactura;
        this.nombreempleado = nombreempleado;
        this.fechafacturacion = fechafacturacion;
    }

    public String getNnmfactura() {
        return nnmfactura;
    }

    public void setNnmfactura(String nnmfactura) {
        this.nnmfactura = nnmfactura;
    }

    public String getNombreempleado() {
        return nombreempleado;
    }

    public void setNombreempleado(String nombreempleado) {
        this.nombreempleado = nombreempleado;
    }

    public String getFechafacturacion() {
        return fechafacturacion;
    }

    public void setFechafacturacion(String fechafacturacion) {
        this.fechafacturacion = fechafacturacion;
    }

    public Long getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(Long totalFactura) {
        this.totalFactura = totalFactura;
    }

    public Long getIva() {
        return iva;
    }

    public void setIva(Long iva) {
        this.iva = iva;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    public FormaDePago getCodFormapago() {
        return codFormapago;
    }

    public void setCodFormapago(FormaDePago codFormapago) {
        this.codFormapago = codFormapago;
    }

    @XmlTransient
    public Collection<DetalleFactura> getDetalleFacturaCollection() {
        return detalleFacturaCollection;
    }

    public void setDetalleFacturaCollection(Collection<DetalleFactura> detalleFacturaCollection) {
        this.detalleFacturaCollection = detalleFacturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nnmfactura != null ? nnmfactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.nnmfactura == null && other.nnmfactura != null) || (this.nnmfactura != null && !this.nnmfactura.equals(other.nnmfactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Factura[ nnmfactura=" + nnmfactura + " ]";
    }
    
}
