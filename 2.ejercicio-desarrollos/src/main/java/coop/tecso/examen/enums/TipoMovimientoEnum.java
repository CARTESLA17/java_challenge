package coop.tecso.examen.enums;

public enum TipoMovimientoEnum {
	
	DEBITO  (1), 
    CREDITO (2);   

    private final int id;

    private TipoMovimientoEnum(int id) {
        this.id = id;
    }

	public int getId() {
		return id;
	}
    
}
