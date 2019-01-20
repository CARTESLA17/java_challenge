package coop.tecso.examen.model;

import javax.persistence.Entity;

@Entity
public class Cuenta extends AbstractPersistentObject{

	private static final long serialVersionUID = -3700589847170931441L;
	
	private int moneda;
	
	private Float saldo;
	
	private int titular;

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

}
