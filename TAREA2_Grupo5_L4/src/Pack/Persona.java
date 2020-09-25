package Pack;
import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;
public class Persona implements Comparable<Persona>{
	
	//Atributos:
	private int dni;
	private String nombre;
	private String apellido;
	
	
	//Constructores:
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
	
	//Gets y sets:
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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

	
	
	//Metodos:
	
	//ToString:
	public String toString() {
		
		return "DNI: " + dni + "/n Nombre: " + nombre + "/n Apellido: " + apellido;
		
	}
	
	
	public static boolean validarDNI (int dni) throws ExcepcionDNI {
	
		Boolean auxdni=false;
		String x= Integer.toString(dni);
		
		if(x.length()==8) {
			auxdni=true;
	    }
		if(auxdni==false) {
			ExcepcionDNI exc1  = new ExcepcionDNI();
		    throw exc1;
		}
		if(auxdni==true) {
			return true;
		}
		
		return false;
		
	}
	
	

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + dni;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
		
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Persona other = (Persona) obj;
		
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (dni != other.dni)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		
		return true;
		
	}

	@Override
	public int compareTo(Persona o) {
		
		if(o.dni==this.dni)
			return 0;
			if(o.dni < this.dni)
				return 1;
		return -1;
			
	}
	
	
	
}
