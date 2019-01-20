package coop.tecso.examen.utils;

public class Utils {
	
	public static boolean validarLongitudDeDato(String dato, int longitud) {
    	return dato.trim().length()>0 && dato.trim().length()<=longitud;
    }    
	
}
