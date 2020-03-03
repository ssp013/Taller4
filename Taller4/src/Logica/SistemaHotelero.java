package Logica;

public interface SistemaHotelero {
	//Cargar TXT:
	public boolean cargarDatosReservaciones(String codReserva, String codCliente,String numeroHabitacion, int fechaInicio, int fechaTermino);
	public boolean cargarDatosHabitaciones(int numeroHabitacion, int valorDia, String tipo);
	public boolean crearCliente(String CodCliente, String nombre, String apellido, String telefono);
	public boolean crearRecepcionista(String CodRecepcionista, String nombre, String apellido,String telefono, String correo, int sueldo);
	public boolean crearGerente(String CodGerente, String nombre, String apellido,String telefono, String correo, int sueldo);
	public boolean crearOtroTrabajador(String CodGerente, String nombre, String apellido,String telefono, String correo, int sueldo);
	//RFS1
	public boolean ExisteReserva(String codReserva);
	public boolean existePersona(String nombre, String apellido);	
	public int[] HabitacionesDisponibles( String fechaInicio, String fechaTermino);
	public String detallesHabitaciones(int[]lista);
	public boolean crearReserva(String codCliente,int numeroHabitacion, int fechaInicio, int fechaTermino);
	
	
	
	
	public String DesplegarListaConHabitacionesDisponibles(String fechaInicio, String fechaTermino);
	public boolean SeleccionarHabitacion(String NumHabitacion, int valorXdia, String tipo);
	public boolean informacionReservacionCliente(String codCliente);
	public String DesplegarRemuneraciones();
	public boolean crearotroTrabajador(String codTrabajador, String nombre, String apellido, String telefono);
	public void salirDelSistema();
}
