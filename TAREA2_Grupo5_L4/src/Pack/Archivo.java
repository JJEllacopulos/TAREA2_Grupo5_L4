package Pack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;



public class Archivo {
	
	private String ruta;
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public boolean existe(){
		
		File archivo = new File(ruta); 
		if(archivo.exists())
		      return true;
		return false;
		
	}
	
	public boolean creararchivonuevo(){
		
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
				try {
				personita.validarDNI(Integer.parseInt(listaPersona[2]));
					
				personita.setNombre(listaPersona[0]);
				personita.setApellido(listaPersona[1]);
				personita.setDni(Integer.parseInt(listaPersona[2]));
				lista.add(personita);
				}
				catch(ExcepcionDNI e){
					e.getMessage();
				}
			}
			
			buffer.close();
			entrada.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		listaTreeSet.addAll(lista);
		return listaTreeSet;
	}
	
}
