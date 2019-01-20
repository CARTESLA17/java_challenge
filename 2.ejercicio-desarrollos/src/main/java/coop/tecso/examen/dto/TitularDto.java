package coop.tecso.examen.dto;

import java.io.Serializable;

public class TitularDto implements Serializable{
	
	private static final long serialVersionUID = -2886534682100457633L;
	
	private Long id;
	
	private Long tipoPersona;
	
	private String nombre;
	
	private String apellido;
	
	private Long dni;
	
	private String razonSocial;
	
	private Long year;
	
	private Long cuit;
	
	private Long version;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		return dni;
	}

	public void setDNI(Long dni) {
		this.dni = dni;
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
	
	public Long getCUIT() {
		return cuit;
	}

	public void setCUIT(Long cuit) {
		this.cuit = cuit;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}	

}
