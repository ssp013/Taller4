package Logica;
import Dominio.*;
public class ListaPersonas {
	
	NodoPersona last;
	public ListaPersonas() {
		last = null;
	}
	public NodoPersona getLast() {
		return last;
	}
	
	public void ingresar(Persona persona) {
		NodoPersona nuevoNodo = new NodoPersona(persona); 
	        if(last!=null){
	        	nuevoNodo.setNext(last.getNext());
	        	nuevoNodo.setLast(last);
	            last.setNext(nuevoNodo);
	            last = nuevoNodo;
	        }else{
	            last = nuevoNodo;
	            nuevoNodo.setNext(nuevoNodo);
	            nuevoNodo.setLast(nuevoNodo);
	        }
	}
	public Persona buscarPersona(String codigo){
		
		if(last!=null) {
			NodoPersona current = last.getNext();//Primero
			
			while(current!=last) {
				if(current.getPersona().getCodigo().equals(codigo) ){
					return current.getPersona();
				}
				current = current.getNext();		
			}
			if(last.getPersona().getCodigo().equals(codigo) ){
				return current.getPersona();
			}
		}
		return null;
		
	}
	public Persona buscar(String nombre,String apellido){
	    if(last!=null){
	        NodoPersona current = last.getNext();
	        while(current!=last){
	            if(nombre.equals(current.getPersona().getNombre()) 
	            && apellido.equals(current.getPersona().getApellido())
	            		){
	                return current.getPersona();
	            }
	            current = current.getNext();
	        }
            if(nombre.equals(last.getPersona().getNombre()) 
            && apellido.equals(last.getPersona().getApellido())
            		){
                return current.getPersona();
            }
	    }
	    	return null;	    	 
		
	}
}
