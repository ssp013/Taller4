package Logica;

import java.text.ParseException;

public interface SistemaHotelero {

	public boolean cargarDatosReservaciones(String codReserva, String codCliente,int numeroHabitacion, String fechaInicio, String fechaTermino);
        //Descripcion: Carga las reservaciones actuales del sistema.
        //PreCondicion:
        //PostCondicion: Datos cargados
	public boolean cargarDatosHabitaciones(int numeroHabitacion, int valorDia, String tipo);
        //Descripcion: Carga los datos de todas las habitaciones en el hotel.
        //PreCondicion:
        //PostCondicion: Datos cargados
	public boolean crearCliente(String CodCliente, String nombre, String apellido, String telefono);
        //Descripcion: Crea un nuevo cliente.
        //PreCondicion:
        //PostCondicion: Cliente creado.
	public boolean crearRecepcionista(String CodRecepcionista, String nombre, String apellido,String telefono, String correo, int sueldo);
        //Descripcion: Crea un nuevo recepcionista.
        //PreCondicion:
        //PostCondicion: Recepcionista creado.
	public boolean crearGerente(String CodGerente, String nombre, String apellido,String telefono, String correo, int sueldo);
        //Descripcion: Crea un nuevo gerente.
        //PreCondicion:
        //PostCondicion: Gerente creado.
	public boolean crearOtroTrabajador(String CodGerente, String nombre, String apellido,String telefono, String correo, int sueldo);
        //Descripcion: Crea Otro trabajador.
        //PreCondicion:
        //PostCondicion: Trabajador creado.
	public int[] HabitacionesDisponibles( String fechaInicio, String fechaTermino) throws ParseException;
        //Descripcion: Entrga el numero de las habitaciones disponibles en las fechas indicadas.
        //PreCondicion: fechas indicadas no choquen con reservas ya realizadas
        //PostCondicion:
	public String detallesHabitaciones(int[]lista);
        //Descripcion: Entrega la informacion (numero, valor por dia y tipo) de las habitaciones disponibles obtenidas en "HabitacionesDisponibles"
        //PreCondicion:
        //PostCondicion:
	public boolean crearReserva(String codigoReservaUltimo,String codCliente,int numeroHabitacion, String fechaInicio, String fechaTermino);
        //Descripcion: Crea una nueva reserva y genera un codigo de reserva.
        //PreCondicion:
        //PostCondicion: Reserva creada.	
	public String informacionReservacionCliente(String codCliente);
        //Descripcion: Entrega los datos de las reservaciones de los clientes.
        //PreCondicion:
        //PostCondicion:
	public String DesplegarRemuneraciones();
        //Descripcion: Entrega las remuneraciones de cada trabajador del hotel.
        //PreCondicion:
        //PostCondicion:
	public String existePersona(String nombre, String apellido, String telefono);
        //Descripcion: Verifica si la persona existe o no.
        //PreCondicion:
        //PostCondicion:
        public int dameElCodigo();
        //Descripcion: Entrega el codigo de la ultima resevacion realizada.
        //PreCondicion:
        //PostCondicion:
}