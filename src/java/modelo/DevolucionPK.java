/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author USUARIO
 */
@Embeddable
public class DevolucionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cod_detallefactura")
    private String codDetallefactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_detallearticulo")
    private int codDetallearticulo;

    public DevolucionPK() {
    }

    public DevolucionPK(String codDetallefactura, int codDetallearticulo) {
        this.codDetallefactura = codDetallefactura;
        this.codDetallearticulo = codDetallearticulo;
    }

    public String getCodDetallefactura() {
        return codDetallefactura;
    }

    public void setCodDetallefactura(String codDetallefactura) {
        this.codDetallefactura = codDetallefactura;
    }

    public int getCodDetallearticulo() {
        return codDetallearticulo;
    }

    public void setCodDetallearticulo(int codDetallearticulo) {
        this.codDetallearticulo = codDetallearticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDetallefactura != null ? codDetallefactura.hashCode() : 0);
        hash += (int) codDetallearticulo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DevolucionPK)) {
            return false;
        }
        DevolucionPK other = (DevolucionPK) object;
        if ((this.codDetallefactura == null && other.codDetallefactura != null) || (this.codDetallefactura != null && !this.codDetallefactura.equals(other.codDetallefactura))) {
            return false;
        }
        if (this.codDetallearticulo != other.codDetallearticulo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.DevolucionPK[ codDetallefactura=" + codDetallefactura + ", codDetallearticulo=" + codDetallearticulo + " ]";
    }
    
}
