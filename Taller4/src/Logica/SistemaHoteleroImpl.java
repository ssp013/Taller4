package Logica;
import ucn.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import Dominio.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
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
		boolean presenta = false;
		Iterator<Reserva>it = listReserva.iterator();
		while(it.hasNext()) {
			Reserva reserva = (Reserva) it.next();
			if(reserva!=null && reserva.getCodReserva().equals(codReserva)) {
				presenta = true;
				break;
			}
		}
		if(presenta==false) {
			Reserva nuevaReserva = new Reserva(codReserva,codCliente,numeroHabitacion,fechaInicio,fechaTermino);
			listReserva.add(nuevaReserva);
			
			Persona p =listapersonas.buscarPersona(codCliente);
			
			if(p!=null) {
				 if(p instanceof Cliente) {
					 Cliente c = (Cliente) p;
            		 LinkedList<Reserva> listaReserva =  c.getListaReserva();
            		 
                     Iterator<Reserva>it2 = listaReserva.iterator();
                     boolean esta = false;
                     
                     while(it2.hasNext()){
                        Reserva r = (Reserva)it2.next();
                        if(r.getCodReserva().equals(codReserva)) {
                        	esta=true;
                        	break;
                        }
                     }
                     if(esta==false) {
                    	 listaReserva.add(nuevaReserva);
                     } 
				 }
			} 			
			return true;
		}else {
			return false;			
		}	
	}
	@Override
	public boolean cargarDatosHabitaciones(int numeroHabitacion, int valorDia, String tipo) {
		boolean presenta = false;
		
		Iterator<Habitacion>it = listHabitacion.iterator();
		while(it.hasNext()) {
			Habitacion hab = (Habitacion) it.next();
			if(hab!=null && hab.getNumHabitacion()==numeroHabitacion) {
				presenta = true;
				break;
			}
		}
		
		if(presenta==false) {
			Habitacion h = new Habitacion(numeroHabitacion,valorDia,tipo);
			listHabitacion.add(h);
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean crearCliente(String CodCliente, String nombre, String apellido, String telefono) {
		Persona p = listapersonas.buscar(nombre, apellido);
		if(p==null) {
			Persona perso = new Cliente(CodCliente,nombre,apellido, telefono);
			listapersonas.ingresar(perso);
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean crearRecepcionista(String CodRecepcionista, String nombre, String apellido, String telefono,
			String correo, int sueldo) {
		Persona p = listapersonas.buscar(nombre, apellido);
		if(p==null) {
			Persona p1 = new Recepcionista(CodRecepcionista,nombre,apellido, telefono,correo,sueldo);
			listapersonas.ingresar(p1);
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean crearGerente(String CodGerente, String nombre, String apellido, String telefono, String correo,
			int sueldo) {
		Persona p = listapersonas.buscar(nombre, apellido);
		if(p==null) {
			Persona p1 = new Gerente(CodGerente,nombre,apellido, telefono,correo,sueldo);
			listapersonas.ingresar(p1);
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean crearOtroTrabajador(String cod, String nombre, String apellido, String telefono,
			String correo, int sueldo) {
		Persona p = listapersonas.buscar(nombre, apellido);
		if(p==null) {
			Persona p1 = new OtroTrabajador(cod,nombre,apellido, telefono,correo,sueldo);
			listapersonas.ingresar(p1);
			return true;
		}else {
			return false;
		}
	}
	@Override
	public String existePersona(String nombre, String apellido, String telefono) {
	
		Persona p = listapersonas.buscar(nombre, apellido);
		if(p!=null) {
			return p.getCodigo();
		}else {
			return null;
		}
		
	}
	@Override
	public int[] HabitacionesDisponibles(String fechaInicio, String fechaTermino) throws ParseException {
		// TODO Auto-generated method stub
		int i=0;
		int [] listaDisponibles = new int[100];
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaNuevaInicio = formato.parse(fechaInicio);
		Date fechaNuevaSalida = formato.parse(fechaTermino);
		
		Iterator<Reserva>it = listReserva.iterator();
		
		while(it.hasNext()) {
			
			Reserva reserva = (Reserva) it.next();
			String fechaIreserva = reserva.getFechaInicio();
			String fechaTreserva = reserva.getFechaTermino();
			
			Date fechaAntiguaInicio = formato.parse(fechaIreserva);
			Date fechaAntiguaTermino = formato.parse(fechaTreserva);
			
			//if(fechaNuevaInicio.before(fechaAntiguaInicio) && fechaNuevaSalida.before(fechaAntiguaInicio) 
			//&& fechaNuevaInicio.after(fechaAntiguaTermino) && fechaNuevaSalida.after(fechaAntiguaTermino) ) {
				
				
				listaDisponibles[i]=reserva.getNumeroHabitacion();
				i++;
			//}
			
		}
		return listaDisponibles;
	}
	@Override
	public String detallesHabitaciones(int[] lista) {
		String r = "";
		for(int i =0;i<lista.length;i++) {
			if(lista[i]!=0) {
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
		}
		return r;
	}
	@Override
	public boolean crearReserva(String codCliente, int numeroHabitacion, String fechaInicio, String fechaTermino) {
		
		
		Reserva t= listReserva.get(listReserva.size()-1);
		String n = t.getCodReserva();
		int result = Integer.valueOf(n);
		result=result+1;
		String codigoReservaUltimo= String.valueOf(result);
		StdOut.println(codigoReservaUltimo);
		Reserva nuevaReserva = new Reserva(codigoReservaUltimo,codCliente,numeroHabitacion,fechaInicio,fechaTermino);
		Persona p = listapersonas.buscarPersona(codCliente);
		 if(p instanceof Cliente) {
			 Cliente c = (Cliente) p;
    		 LinkedList<Reserva> listaReserva =  c.getListaReserva();
            listaReserva.add(nuevaReserva);   
		 }
		return true;
	
	}

	@Override
	public boolean SeleccionarHabitacion(String NumHabitacion, int valorXdia, String tipo) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String informacionReservacionCliente(String Codigo) {
		   String resp = "";
		   NodoPersona current = listapersonas.last.getNext();//Es el first
	             while(current!=listapersonas.last){
		                 if(Codigo.equals(current.getPersona().getCodigo())){	                	 
		                     if(current.getPersona() instanceof Cliente){
		                    	 
		                         resp = resp +"Nombre: "+current.getPersona().getNombre()+" Apellido: "+current.getPersona().getApellido()+" Telefono: "+current.getPersona().getTelefono()+"\n";
		                         if( current.getPersona() instanceof Cliente) {
		                        	 Cliente p = (Cliente) current.getPersona();
			                         LinkedList<Reserva> listaReserva =  ((Cliente) p).getListaReserva();
			                         Iterator<Reserva>it = listaReserva.iterator();
			                         while(it.hasNext()){
			                            Reserva r = (Reserva)it.next();
			                            String CodRes = r.getCodReserva();
			                            int Hab = r.getNumeroHabitacion();
			                            String FechaI = r.getFechaInicio();
			                            String FechaS = r.getFechaTermino();
			                            int valDia = 0;
			                            String tipo = null;
			                            for(int i=0;i<listHabitacion.size();i++){
			                                Habitacion habitacion = listHabitacion.get(i);
			                                if(habitacion.getNumHabitacion()==Hab){
			                                    valDia = habitacion.getValorDia();
			                                    tipo = habitacion.getTipo();
			                                }
			                            }
			                            resp = resp + "Codigo de Reserva: "+CodRes+"\n 		  Habitacion numero: "+Hab+"\n 		  Valor por dia: "+valDia+"\n 		  Habitacion tipo: "+tipo+"\n 		  FechaIngreso: "+FechaI+"\n 		  FechaSalida: "+FechaS+"\n";
			                         }
			                         
			                     }
			                 }
		                     
		             }
		            
	               current = current.getNext();
	               break;
	             }
                 if(Codigo.equals(current.getPersona().getCodigo())){	                	 
                     if(current.getPersona() instanceof Cliente){
                    	 
                         resp = resp +"Nombre: "+current.getPersona().getNombre()+" Apellido: "+current.getPersona().getApellido()+" Telefono: "+current.getPersona().getTelefono()+"\n";
                         if( current.getPersona() instanceof Cliente) {
                        	 Cliente p = (Cliente) current.getPersona();
	                         LinkedList<Reserva> listaReserva =  ((Cliente) p).getListaReserva();
	                         Iterator<Reserva>it = listaReserva.iterator();
	                         while(it.hasNext()){
	                            Reserva r = (Reserva)it.next();
	                            String CodRes = r.getCodReserva();
	                            int Hab = r.getNumeroHabitacion();
	                            String FechaI = r.getFechaInicio();
	                            String FechaS = r.getFechaTermino();
	                            int valDia = 0;
	                            String tipo = null;
	                            for(int i=0;i<listHabitacion.size();i++){
	                                Habitacion habitacion = listHabitacion.get(i);
	                                if(habitacion.getNumHabitacion()==Hab){
	                                    valDia = habitacion.getValorDia();
	                                    tipo = habitacion.getTipo();
	                                }
	                            }
	                            resp = resp + "Codigo de Reserva: "+CodRes+"\n 		  Habitacion numero: "+Hab+"\n 		  Valor por dia: "+valDia+"\n 		  Habitacion tipo: "+tipo+"\n 		  FechaIngreso: "+FechaI+"\n 		  FechaSalida: "+FechaS+"\n";
	                         }
	                         
	                     }
                     }
                 }
	        
	             
	         
	         return resp;
	}
	@Override
	public String DesplegarRemuneraciones() {
        int sumaSueldos = 0;
        String DatosTrabajador = "";
        NodoPersona current = listapersonas.last.getNext();
        while(current!=listapersonas.last) {
        	Persona p = current.getPersona();
        	if(p instanceof Recepcionista) {
        		int sueldo = ((Recepcionista) p).getSueldo();
        		sumaSueldos+=sueldo;
        		DatosTrabajador = DatosTrabajador+"Recepcionista --> Código: "+p.getCodigo()+" Nombre: "+p.getNombre()+" Apellido:"+p.getApellido()+" Sueldo: $"+sueldo+"\n";
        		
        	}else if( p instanceof Gerente) {
        		int sueldo = ((Gerente) p).getSueldo();
        		sumaSueldos+=sueldo;
        		DatosTrabajador = DatosTrabajador+"Gerente --> Código: "+p.getCodigo()+" Nombre: "+p.getNombre()+" Apellido:"+p.getApellido()+" Sueldo: $"+sueldo+"\n";
        				
        	}else if(p instanceof OtroTrabajador) {
        		int sueldo = ((OtroTrabajador) p).getSueldo();
        		sumaSueldos+=sueldo;
        		DatosTrabajador = DatosTrabajador+"Otro trabajador --> Código: "+p.getCodigo()+" Nombre: "+p.getNombre()+" Apellido:"+p.getApellido()+" Sueldo: $"+sueldo+"\n";
        		
        	}
        	
        	current = current.getNext();
        	
        }
        Persona p = current.getPersona();
    	if(p instanceof Recepcionista) {
    		int sueldo = ((Recepcionista) p).getSueldo();
    		sumaSueldos+=sueldo;
    		DatosTrabajador = DatosTrabajador+"Recepcionista --> Código: "+p.getCodigo()+" Nombre: "+p.getNombre()+" Apellido:"+p.getApellido()+" Sueldo: $"+sueldo+"\n";
    		
    	}else if( p instanceof Gerente) {
    		int sueldo = ((Gerente) p).getSueldo();
    		sumaSueldos+=sueldo;
    		DatosTrabajador = DatosTrabajador+"Gerente --> Código: "+p.getCodigo()+" Nombre: "+p.getNombre()+" Apellido:"+p.getApellido()+" Sueldo: $"+sueldo+"\n";
    				
    	}else if(p instanceof OtroTrabajador) {
    		int sueldo = ((OtroTrabajador) p).getSueldo();
    		sumaSueldos+=sueldo;
    		DatosTrabajador = DatosTrabajador+"Otro trabajador --> Código: "+p.getCodigo()+" Nombre: "+p.getNombre()+" Apellido:"+p.getApellido()+" Sueldo: $"+sueldo+"\n";
    		
    	}
        
        
        DatosTrabajador=DatosTrabajador+"Saldo final sueldo: $"+sumaSueldos+"\n";
         return DatosTrabajador;
        
    }
	@Override
	public String DesplegarClientes() {
		String DatosTrabajador ="";
        NodoPersona current = listapersonas.last.getNext();
        while(current!=listapersonas.last) {
           	Persona p = current.getPersona();
	        	if(p instanceof Cliente) {
	        		DatosTrabajador = DatosTrabajador+"Cod"+p.getCodigo()+"\n";	
	        		
	        	}
	        	current = current.getNext();
        	}
        Persona p = current.getPersona();
    	if(p instanceof Cliente) {
    		DatosTrabajador = DatosTrabajador+"Cod"+p.getCodigo()+"\n";		
    	}
		return DatosTrabajador;
		
	}


}
