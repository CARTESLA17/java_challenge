package coop.tecso.examen.dto;

import java.io.Serializable;
import java.util.Date;

public class MovimientoDto implements Serializable{	
	
	private static final long serialVersionUID = 7461911617768355436L;

	private Date fecha;
	
	private String descripcion;
	
	private Float importe;
	
	private Long cuenta;
	
	private int  tipoMovimiento;
	
	private Long id;
	
	private Long version;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	

	public int getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(int tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}	
	
}
