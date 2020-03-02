package Logica;

public interface SistemaHotelero {
	public boolean CrearReserbvacion(String codReserva, String codCliente, int fechaInicio, int fechaTermino);
	public boolean ExisteReserva(String codReserva);
	public boolean crearCliente(String CodCliente, String nombre, String apellido, String telefono);
	public boolean crearRecepcionista(String CodRecepcionista, String nombre, String apellido,String telefono, String correo, int sueldo);
	public boolean crearGerente(String CodGerente, String nombre, String apellido,String telefono, String correo, int sueldo);
	public boolean existePersona(String Codigo);
	public String DesplegarListaConHabitacionesDisponibles(String fechaInicio, String fechaTermino);
	public boolean SeleccionarHabitacion(String NumHabitacion, int valorXdia, String tipo);
	public boolean informacionReservacionCliente(String codCliente);
	public String DesplegarRemuneraciones();
	public boolean crearotroTrabajador(String codTrabajador, String nombre, String apellido, String telefono);
	public void salirDelSistema();
}
