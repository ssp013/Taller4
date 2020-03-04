package Logica;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import Dominio.*;
public class SistemaHoteleroImpl implements SistemaHotelero {
	private ListaPersonas listapersonas;
	private ArrayList<Habitacion>listHabitacion;
	
	private  LinkedList <Reserva> listReserva;
	public SistemaHoteleroImpl() {
		this.listHabitacion = new ArrayList<Habitacion>();
		this.listReserva = new LinkedList<Reserva>();
		this.listapersonas = new ListaPersonas();
	}
	
	@Override
	public boolean cargarDatosReservaciones(String codReserva, String codCliente, int numeroHabitacion,
			String fechaInicio, String fechaTermino) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean cargarDatosHabitaciones(int numeroHabitacion, int valorDia, String tipo) {
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
	public boolean crearOtroTrabajador(String CodGerente, String nombre, String apellido, String telefono,
			String correo, int sueldo) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean ExisteReserva(String codReserva) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String existePersona(String nombre, String apellido, String telefono) {
	
		Persona p = listapersonas.buscarPersona(nombre, apellido);
		if(p!=null) {
			return p.getCodigo();
		}else {
			return null;
		}
		
	}
	@Override
	public int[] HabitacionesDisponibles(String fechaInicio, String fechaTermino) {
		// TODO Auto-generated method stub
		int [] listaDisponibles = new int[1000];
		/**String[] partes = fechaInicio.split("/");
		int anoInicio = Integer.parseInt(partes[2]);                
		int mesInicio =Integer.parseInt(partes[1]);                      
		int diaInicio = Integer.parseInt(partes[0]);     
	
		String[] partes1 = fechaInicio.split("/");
		int anoTermino = Integer.parseInt(partes1[2]);                
		int mesTermino =Integer.parseInt(partes1[1]);                      
		int diaTermino = Integer.parseInt(partes1[0]);
		
        boolean presenta = false; 
        
        Iterator<Reserva> it = listReserva.iterator();//Iterador
        while (it.hasNext()) {
            Reserva reserva = (Reserva) it.next();
            String fechaInicioReserva = reserva.getFechaInicio();
            String fechaTerminoReserva = reserva.getFechaTermino();
      
    		String[] partes2 = fechaInicioReserva.split("/");
    		int anoInicioReserva = Integer.parseInt(partes2[2]);                
    		int mesInicioReserva =Integer.parseInt(partes2[1]);                      
    		int diaInicioReserva = Integer.parseInt(partes2[0]);     
    	
    		String[] partes3 = fechaTerminoReserva.split("/");
    		int anoTerminoReserva = Integer.parseInt(partes3[2]);                
    		int mesTerminoReserva =Integer.parseInt(partes3[1]);                      
    		int diaTerminoReserva = Integer.parseInt(partes3[0]);
    		}
    		**/
    		//condicional:
        
		return listaDisponibles;
	}
	@Override
	public String detallesHabitaciones(int[] lista) {
		String r = "";
		for(int i =0;i<lista.length;i++) {
			int numeroHabitacionDisponible = lista[i];
			Iterator<Habitacion> it = listHabitacion.iterator();//Iterator:
			while(it.hasNext()) {
				Habitacion hab = (Habitacion) it.next();
				if(hab!=null) {
					if(hab.getNumHabitacion() == numeroHabitacionDisponible) {
						r=r+"* Numero Habitación:"+hab.getNumHabitacion()+" - Valor por día:"+hab.getValorDia()+" - Tipo: "+hab.getTipo()+"\n";
					}
				}
			}
		}
		return r;
	}
	@Override
	public boolean crearReserva(String codCliente, int numeroHabitacion, String fechaInicio, String fechaTermino) {
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
