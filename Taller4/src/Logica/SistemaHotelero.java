package Logica;

public interface SistemaHotelero {
	public boolean CrearReserbvacion(String codReserva, String codCliente, int fechaInicio, int fechaTermino);
	public boolean ExisteReserva(String codReserva);
	public boolean crearCliente(String CodCliente, String nombre, String apellido, String telefono);
	public boolean crearRecepcionista()
	
}
