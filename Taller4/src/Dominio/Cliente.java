package Dominio;

import java.util.LinkedList;

public class Cliente extends Persona{
	private LinkedList <Reserva> listaReserva ; 
	public Cliente(String Codigo, String nombre, String apellido, String telefono) {
		// TODO Auto-generated constructor stub
		super(Codigo, nombre,apellido, telefono);
		listaReserva = new LinkedList<Reserva>();
	}
	/**
	 * @return the listaReserva
	 */
	public LinkedList<Reserva> getListaReserva() {
		return listaReserva;
	}
	/**
	 * @param listaReserva the listaReserva to set
	 */
	public void setListaReserva(LinkedList<Reserva> listaReserva) {
		this.listaReserva = listaReserva;
	}
	

}
