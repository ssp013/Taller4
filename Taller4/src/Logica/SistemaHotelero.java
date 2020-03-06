package Logica;

import java.text.ParseException;

public interface SistemaHotelero {
	//Cargar TXT:
	public boolean cargarDatosReservaciones(String codReserva, String codCliente,int numeroHabitacion, String fechaInicio, String fechaTermino);
	public boolean cargarDatosHabitaciones(int numeroHabitacion, int valorDia, String tipo);
	public boolean crearCliente(String CodCliente, String nombre, String apellido, String telefono);
	public boolean crearRecepcionista(String CodRecepcionista, String nombre, String apellido,String telefono, String correo, int sueldo);
	public boolean crearGerente(String CodGerente, String nombre, String apellido,String telefono, String correo, int sueldo);
	public boolean crearOtroTrabajador(String CodGerente, String nombre, String apellido,String telefono, String correo, int sueldo);
	//RFS1	
	public int[] HabitacionesDisponibles( String fechaInicio, String fechaTermino) throws ParseException;
	public String detallesHabitaciones(int[]lista);
	public boolean crearReserva(String codCliente,int numeroHabitacion, String fechaInicio, String fechaTermino);
	
	public boolean SeleccionarHabitacion(String NumHabitacion, int valorXdia, String tipo);
	public String informacionReservacionCliente(String codCliente);
	public String DesplegarRemuneraciones();
	public String existePersona(String nombre, String apellido, String telefono);
	public String DesplegarClientes();
}
