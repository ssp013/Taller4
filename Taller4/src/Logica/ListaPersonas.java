package Logica;
import Dominio.*;
public class ListaPersonas {
	private NodoPersona first;
	private NodoPersona last;
	public ListaPersonas() {
		first = null;
		last = null;
	}
	public void insertarPrimer(Persona persona) {
		NodoPersona nuevoNodo = new NodoPersona(persona);
		if(first == null) {
			last = nuevoNodo;
		}else {
			first.setLast(nuevoNodo);
		}
		nuevoNodo.setNext(first);
		first = nuevoNodo;
	}
	public Persona buscarPersona(String nombre,String apellido){
	    if(last!=null){
	        NodoPersona current = last.getNext();
	        while(current!=last){
	            if(nombre.equals(current.getPersona().getNombre())   && apellido.equals(current.getPersona().getApellido())){
	                return current.getPersona();
	            }
	            current = current.getNext();
	        }
	        if(nombre.equals(last.getPersona().getNombre())    && apellido.equals(last.getPersona().getApellido()))  {
	            return current.getPersona();
	        }
	    }
	    return null;
	}
}
