package coop.tecso.examen.model;

import javax.persistence.Entity;

@Entity
public class Titular extends AbstractPersistentObject{
	
	private static final long serialVersionUID = -5047854030858866813L;

	private Long tipoPersona;
	
	private String nombre;
	
	private String apellido;
	
	private Long DNI;
	
	private String razonSocial;
	
	private Long year;
	
	private Long cuit;	

	public Long getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(Long tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Long getDNI() {
		return DNI;
	}

	public void setDNI(Long DNI) {
		this.DNI = DNI;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public Long getCuit() {
		return cuit;
	}

	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}	

}
