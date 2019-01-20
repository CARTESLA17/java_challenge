package coop.tecso.examen.dto;

import java.io.Serializable;

public class CuentaDto implements Serializable {	
	
	private static final long serialVersionUID = -4199857509508794913L;
	
	private Long id;

	private int moneda;
	
	private Float saldo;
	
	private int titular;
	
	private Long version;

	public int getMoneda() {
		return moneda;
	}

	public void setMoneda(int moneda) {
		this.moneda = moneda;
	}

	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	public int getTitular() {
		return titular;
	}

	public void setTitular(int titular) {
		this.titular = titular;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
}
