package coop.tecso.examen.dto;

import java.io.Serializable;

public class TipoPersonaDto implements Serializable{
	
	private static final long serialVersionUID = -2886534682100457633L;
	
	private Long id;	
	private String descripcion;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
