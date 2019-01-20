package coop.tecso.examen.model;

import javax.persistence.Entity;

@Entity
public class TipoPersona extends AbstractPersistentObject{

	private static final long serialVersionUID = -1450045229146621869L;
	
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	

}
