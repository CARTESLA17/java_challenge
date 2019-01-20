package coop.tecso.examen.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Movimiento extends AbstractPersistentObject{
	
	private static final long serialVersionUID = -7383103476452115964L;
	
	private Date fecha;
	
	private String descripcion;
	
	private Float importe;
	
	private Long cuenta;
	
	private int  tipoMovimiento;
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Float getImporte() {
		return importe;
	}
	
	public void setImporte(Float importe) {
		this.importe = importe;
	}
	
	public Long getCuenta() {
		return cuenta;
	}
	
	public void setCuenta(Long cuenta) {
		this.cuenta = cuenta;
	}

	public int getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(int tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	
}
