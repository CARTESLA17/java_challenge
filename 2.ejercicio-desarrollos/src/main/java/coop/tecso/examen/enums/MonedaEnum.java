package coop.tecso.examen.enums;

public enum MonedaEnum {
	
	PESOS  (1), 
    DOLARES(2),  
    EUROS  (3);   

    private int id;

    private MonedaEnum(int id) {
        this.id = id;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
}
