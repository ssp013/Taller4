package Logica;

import java.util.ArrayList;
import java.util.List;

import Dominio.*;
public class SistemaHoteleroImpl implements SistemaHotelero {
	private ListaPersonas listapersonas;
	private List<Habitacion> habitacion;

	public SistemaHoteleroImpl() {
		this.habitacion = new ArrayList<Habitacion>();
		
		
	}
	@Override
	public boolean CrearReserbvacion(String codReserva, String codCliente, int fechaInicio, int fechaTermino) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ExisteReserva(String codReserva) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean crearCliente(String CodCliente, String nombre, String apellido, String telefono) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean crearRecepcionista(String CodRecepcionista, String nombre, String apellido, String telefono,
			String correo, int sueldo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean crearGerente(String CodGerente, String nombre, String apellido, String telefono, String correo,
			int sueldo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existePersona(String Codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String DesplegarListaConHabitacionesDisponibles(String fechaInicio, String fechaTermino) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean SeleccionarHabitacion(String NumHabitacion, int valorXdia, String tipo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean informacionReservacionCliente(String codCliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String DesplegarRemuneraciones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean crearotroTrabajador(String codTrabajador, String nombre, String apellido, String telefono) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void salirDelSistema() {
		// TODO Auto-generated method stub
		
	}
	

}
