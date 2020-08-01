/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "devolucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Devolucion.findAll", query = "SELECT d FROM Devolucion d")
    , @NamedQuery(name = "Devolucion.findByCodDetallefactura", query = "SELECT d FROM Devolucion d WHERE d.devolucionPK.codDetallefactura = :codDetallefactura")
    , @NamedQuery(name = "Devolucion.findByCodDetallearticulo", query = "SELECT d FROM Devolucion d WHERE d.devolucionPK.codDetallearticulo = :codDetallearticulo")
    , @NamedQuery(name = "Devolucion.findByMotivo", query = "SELECT d FROM Devolucion d WHERE d.motivo = :motivo")
    , @NamedQuery(name = "Devolucion.findByFechadevolucion", query = "SELECT d FROM Devolucion d WHERE d.fechadevolucion = :fechadevolucion")
    , @NamedQuery(name = "Devolucion.findByCantidad", query = "SELECT d FROM Devolucion d WHERE d.cantidad = :cantidad")})
public class Devolucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DevolucionPK devolucionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Motivo")
    private String motivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Fecha_devolucion")
    private String fechadevolucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "cod_detallearticulo", referencedColumnName = "cod_articulo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DetalleFactura detalleFactura;
    @JoinColumn(name = "cod_detallefactura", referencedColumnName = "cod_factura", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DetalleFactura detalleFactura1;

    public Devolucion() {
    }

    public Devolucion(DevolucionPK devolucionPK) {
        this.devolucionPK = devolucionPK;
    }

    public Devolucion(DevolucionPK devolucionPK, String motivo, String fechadevolucion, int cantidad) {
        this.devolucionPK = devolucionPK;
        this.motivo = motivo;
        this.fechadevolucion = fechadevolucion;
        this.cantidad = cantidad;
    }

    public Devolucion(String codDetallefactura, int codDetallearticulo) {
        this.devolucionPK = new DevolucionPK(codDetallefactura, codDetallearticulo);
    }

    public DevolucionPK getDevolucionPK() {
        return devolucionPK;
    }

    public void setDevolucionPK(DevolucionPK devolucionPK) {
        this.devolucionPK = devolucionPK;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFechadevolucion() {
        return fechadevolucion;
    }

    public void setFechadevolucion(String fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public DetalleFactura getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(DetalleFactura detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    public DetalleFactura getDetalleFactura1() {
        return detalleFactura1;
    }

    public void setDetalleFactura1(DetalleFactura detalleFactura1) {
        this.detalleFactura1 = detalleFactura1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (devolucionPK != null ? devolucionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devolucion)) {
            return false;
        }
        Devolucion other = (Devolucion) object;
        if ((this.devolucionPK == null && other.devolucionPK != null) || (this.devolucionPK != null && !this.devolucionPK.equals(other.devolucionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Devolucion[ devolucionPK=" + devolucionPK + " ]";
    }
    
}
