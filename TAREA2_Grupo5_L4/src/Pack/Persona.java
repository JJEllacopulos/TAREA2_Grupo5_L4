package Pack;
import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;
public class Persona implements Comparable<Persona>{
	
	int dni;
	String nombre;
	String apellido;
	String ruta;
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

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String toString() {
		
		return "DNI: " + dni + "/n Nombre: " + nombre + "/n Apellido: " + apellido;
		
	}
public static boolean validarDNI (int dni) throws ExcepcionDNI
	
	{
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
	
	public boolean existe()
	{
		File archivo = new File(ruta); 
		if(archivo.exists())
		      return true;
		return false;
	}
	public boolean creararchivonuevo()
	{
		FileWriter escribir;
		try {
			escribir = new FileWriter(ruta, true);
			escribir.write("");
			escribir.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
			
	}

	public boolean Escribir(String linea) {
	FileWriter escritura;
	try {
	escritura= new FileWriter(ruta,true);
	BufferedWriter bufferW= new BufferedWriter(escritura);
	bufferW.write(linea);
	bufferW.close();
	escritura.close();
	return true;
	}
	catch(IOException e) {
	e.printStackTrace();
	}
	return false;
	}
	
	public TreeSet<Persona> Leer() {
		FileReader entrada;
		TreeSet<Persona>listaTreeSet= new TreeSet<Persona>();
		String [] listaPersona;
		ArrayList<Persona> lista = new ArrayList<Persona>();
		try {
		entrada= new FileReader(ruta);
		BufferedReader buffer= new BufferedReader(entrada);
		String linea= null;
		while((linea = buffer.readLine())!= null)
		{
		Persona personita= new Persona();
		listaPersona= linea.split("-");
		personita.setNombre(listaPersona[0]);
		personita.setApellido(listaPersona[1]);
		personita.setDni(Integer.parseInt(listaPersona[2]));
		lista.add(personita);
		}
		buffer.close();
		entrada.close();
		}
		catch(IOException e)
		{
		e.printStackTrace();
		}
		listaTreeSet.addAll(lista);
		return listaTreeSet;
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
