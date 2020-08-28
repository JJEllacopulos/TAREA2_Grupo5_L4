package Pack;

public class Persona {
	
	int dni;
	String nombre;
	String apellido;
	
	public Persona() {
		
		dni = 11111111;
		nombre = "Sin nombre";
		apellido = "Sin apellido";
		
	}
	
	public Persona(int dni, String nombre, String apellido) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		
	}
	
	public String toString() {
		
		return "DNI: " + dni + "/n Nombre: " + nombre + "/n Apellido: " + apellido;
		
	}
	
}
