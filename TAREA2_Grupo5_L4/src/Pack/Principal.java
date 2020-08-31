package Pack;

import java.util.HashSet;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		Persona archivo= new Persona();
		archivo.setRuta("PersonasEmpresa.txt");
		
		System.out.println(" ARCHIVO PERSONASEMPRESA : ");
		archivo.leerarchivo();		
		
		Persona archivo2= new Persona();
		archivo2.setRuta("Resultado.txt");
		
		if(!archivo2.existe())
		{
			archivo2.creararchivonuevo();
		}
		
		//comprobar que funcione el Validador de dni
		
		Persona a1= new Persona();
		a1.setDni(12345678);
		try
		{
	    Persona.validarDNI(a1.getDni());
	    
		}
		catch(ExcepcionDNI e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	
	
}
