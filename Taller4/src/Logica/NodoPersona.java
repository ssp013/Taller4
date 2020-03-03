package Logica;
import Dominio.*;
public class NodoPersona {
	
	private  Persona persona;
	private  NodoPersona next;
	private  NodoPersona last;
	
	public NodoPersona(Persona persona) {
		this.persona=persona;
		this.next = null;
		this.last = null;
	}

	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * @return the next
	 */
	public NodoPersona getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(NodoPersona next) {
		this.next = next;
	}

	/**
	 * @return the last
	 */
	public NodoPersona getLast() {
		return last;
	}

	/**
	 * @param last the last to set
	 */
	public void setLast(NodoPersona last) {
		this.last = last;
	}
	
}
