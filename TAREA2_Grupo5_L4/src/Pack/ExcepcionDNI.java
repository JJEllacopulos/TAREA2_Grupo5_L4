package Pack;

public class ExcepcionDNI extends RuntimeException  {

	@Override
	public String getMessage() {
		
		return " EL DNI DEBE TENER 8 DIGITOS ";
		
	}

	
	
}
