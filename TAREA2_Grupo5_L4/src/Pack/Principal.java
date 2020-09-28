package Pack;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class Principal {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		
		Collator comparador = Collator.getInstance();
		comparador.setStrength(Collator.PRIMARY);
		Persona archivo= new Persona();
		Archivo arch = new Archivo();
		TreeSet<Persona>lista=new TreeSet<Persona>();
		arch.setRuta("../PersonasEmpresa.txt");
		System.out.println("Archivo PersonasEmpresas ordenado\n");
		
		ArrayList<Persona> listarray= new ArrayList();
		
		
		//Guardo la lista treeSet sin duplicados 
		lista=arch.Leer();
		
		//Convieto la lista treeset a ArrayList
		for(Persona e:lista)
		{
			listarray.add(e);
	
		}
		//Ordeno alfabeticamente
		Collections.sort(listarray, (x, y) -> comparador.compare(x.getNombre(), y.getNombre()));
		Collections.reverse(listarray);
		

		Persona archivo2= new Persona();
		Archivo arch2 = new Archivo();
		
		arch2.setRuta("Resultado.txt");
		
		if(!arch2.existe())
		{
			arch2.creararchivonuevo();
		}
		
		for(Persona e:listarray)
		{
			arch2.Escribir(e.getNombre()+", "+e.getApellido()+" "+e.getDni()+"\n");
			System.out.println(e.getNombre()+", "+e.getApellido()+" "+e.getDni()+"\n");
		
		}
		//comprobar que funcione el Validador de dni
		
	}
}
