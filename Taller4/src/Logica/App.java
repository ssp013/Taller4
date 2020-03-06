package Logica;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import Dominio.*;
import ucn.*;
public class App {
	static Scanner sc = new Scanner(System.in);
	public static boolean isValid(String dateStr) {
		try {//"dd/MM/yyyy")
			String[] partes = dateStr.split("/");
			int year = Integer.parseInt(partes[2]);                
			int month =Integer.parseInt(partes[1]);                      
			int dayOfMonth = Integer.parseInt(partes[0]);       
			
			
			if (year < 1900) {
				return false;//año invalido.
			}
			else {
				LocalDate today = LocalDate.of(year, month, dayOfMonth);//tira un false..
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					return true;
				
			}
		}
		catch(java.time.DateTimeException e) {
			return false;
		}
		
	}
	public static boolean validateDate(String dateStr) {
		boolean result = isValid(dateStr);
		if(result) {
			return true;
		}else {
			return false;
		}
	}
	public static int validarInt(){
		while (true){
			try{
			    return sc.nextInt();
			   }
			catch (InputMismatchException e)
			   {
			    sc.next();
			    System.out.print("Error!");
			   }
		}
	}
	public static int opcion1(SistemaHotelero sistema, int cont) throws ParseException{
		StdOut.println("Ingrese Nombre: ");
		String nom = StdIn.readString();
		StdOut.println("Ingrese Apellido: ");
		String ap = StdIn.readString();
		StdOut.println("Ingrese telefono: ");
		String tel = StdIn.readString();
		
		String cod = sistema.existePersona(nom, ap, tel);
		if(cod != null) {			
			StdOut.println("Cliente ya existe en su base de datos!");
			StdOut.println("Ingrese fecha inicio: ");
			String fechaInicio = StdIn.readString();
			boolean result = validateDate(fechaInicio);
			while(!result) {
				StdOut.println("Error! Ingrese fecha inicio (dd/MM/yyyy) :");
				fechaInicio = StdIn.readString();
				result = validateDate(fechaInicio);
			}
			
			StdOut.println("Ingrese fecha de salida: ");
			String fechaTermino = StdIn.readString();
			boolean result2 = validateDate(fechaTermino);
			while(!result2) {
				StdOut.println("Error! Ingrese fecha de salida (dd/MM/yyyy) :");
				fechaTermino = StdIn.readString();
				result2 = validateDate(fechaTermino);
			}
			
			int[] listaDisponible = sistema.HabitacionesDisponibles(fechaInicio, fechaTermino);
			String resp = sistema.detallesHabitaciones(listaDisponible);
			if(resp.equals("")) {
				StdOut.println("No hay habitaciones para esa fecha");
			}else {
				StdOut.println("Seleccione una de estas habitaciones: ");
				StdOut.println(resp);
				int numero = validarInt();
				boolean op=false;
				while(op==false) {
					for(int i=0;i<listaDisponible.length;i++) {
						if(numero == listaDisponible[i]) {
							op=true;
							break;
						}
					}
					if(op==false) {
						StdOut.println("Ingrese de nuevo la habitación!!!");
						numero = validarInt();
					}else{
						StdOut.println("Habitación número: "+numero+" seleccionada!");
					}
		
				}
				if(sistema.crearReserva(cod, numero, fechaInicio, fechaTermino)) {
					StdOut.println("Habitación reservada!");
				}else {
					StdOut.println("Problemas con su reserva!");
				}	
			}
		}
		else {
			cont++;//8
			cod ="C"+cont;
			if(sistema.crearCliente(cod, nom, ap, tel)) {
				StdOut.println("Cliente nuevo, creado!");
				//Preguntarmos fechas:
				StdOut.println("Ingrese fecha inicio: ");
				String fechaInicio = StdIn.readString();
				boolean result = validateDate(fechaInicio);
				while(!result) {
					StdOut.println("Error! Ingrese fecha inicio (dd/MM/yyyy) :");
					fechaInicio = StdIn.readString();
					result = validateDate(fechaInicio);
				}
				
				StdOut.println("Ingrese fecha de salida: ");
				String fechaTermino = StdIn.readString();
				boolean result2 = validateDate(fechaTermino);
				while(!result2) {
					StdOut.println("Error! Ingrese fecha de salida (dd/MM/yyyy) :");
					fechaTermino = StdIn.readString();
					result2 = validateDate(fechaTermino);
				}
				
				int[] listaDisponible = sistema.HabitacionesDisponibles(fechaInicio, fechaTermino);
				String resp = sistema.detallesHabitaciones(listaDisponible);
				if(resp.equals("")) {
					StdOut.println("No hay habitaciones para esa fecha");
				}else {
					StdOut.println("Seleccione una de estas habitaciones: ");
					StdOut.println(resp);
					int numero = validarInt();
					boolean op=false;
					while(op==false) {
						for(int i=0;i<listaDisponible.length;i++) {
							if(numero == listaDisponible[i]) {
								op=true;
								break;
							}
						}
						if(op==false) {
							StdOut.println("Ingrese de nuevo la habitación!!!");
							numero = validarInt();
						}else{
							StdOut.println("Habitación número: "+numero+" seleccionada!");
						}
			
					}
					if(sistema.crearReserva(cod, numero, fechaInicio, fechaTermino)) {
						StdOut.println("Habitación reservada!");
					}else {
						StdOut.println("Problemas con su reserva!");
					}	
				}
			}
		}
		return cont;
	}
	public static void opcion2(SistemaHotelero sistema) {
		
		StdOut.println("Ingrese el código del cliente a revisar:");
		String codCliente = StdIn.readString();
		StdOut.println(sistema.informacionReservacionCliente(codCliente));
	}
	public static void opcion3(SistemaHotelero sistema) {
		StdOut.println("************* Detalle de los trabajadores ****************");
		StdOut.println(sistema.DesplegarRemuneraciones());
		StdOut.println(sistema.DesplegarClientes());
	}
	public static void menu(SistemaHotelero sistema) throws IOException, ParseException {
		StdOut.println("Bienvenidos al sistema hotelero");
		StdOut.println("******** Menú *****************\n 1. Reservar habitación\n 2.Opción Reservaciones\n 3.Revisar sueldos\n 4. Salir");
		int cliente = 7;
        StdOut.println("Ingrese una opción: ");
        String op = StdIn.readString();
    
        while(!op.equals("4")) {
        	if(op.equals("1")){
        		cliente = opcion1(sistema, cliente);
        	}else if(op.equals("2")) {
        		opcion2(sistema);
        	}else if(op.equals("3")) {
        		opcion3(sistema);
        	}
            StdOut.println("Ingrese una opción: ");
            op = StdIn.readString();
       }
        StdOut.println("Gracias por ocupar el sistema hotelero!!\n Adiós!");
	}
    public static void cargarTxtReservaciones(SistemaHotelero sistema) throws IOException{
        ArchivoEntrada txtReservas = new ArchivoEntrada("Reservaciones.txt");
        while(!txtReservas.isEndFile()){
            Registro reg = txtReservas.getRegistro();
            String CodReserva = reg.getString();
            String CodCliente = reg.getString();
            int NumHab = reg.getInt();
            int diaI = reg.getInt();
            int mesI=reg.getInt();
            int anoI= reg.getInt();
            int diaF = reg.getInt();
            int mesF=reg.getInt();
            int anoF= reg.getInt();
      
            String FechaI = diaI+"/"+mesI+"/"+anoI;
            String FechaS = diaF+"/"+mesF+"/"+anoF;
            sistema.cargarDatosReservaciones(CodReserva, CodCliente, NumHab, FechaI, FechaS);
           
        }
        txtReservas.close();
      
    }
    public static void CargarTxtHabitaciones(SistemaHotelero sistema) throws IOException{
       
        ArchivoEntrada txtHabitaciones = new ArchivoEntrada("habitaciones.txt");
        while(!txtHabitaciones.isEndFile()){
            Registro reg = txtHabitaciones.getRegistro();
            int numHab = reg.getInt();
            int valDia = reg.getInt();
            String tipo = reg.getString();
            sistema.cargarDatosHabitaciones(numHab, valDia,tipo);
        }
        txtHabitaciones.close();
       
    }
    public static void CargarTxtPersonas(SistemaHotelero sistema )throws IOException{
    	ArchivoEntrada txtpersonas = new ArchivoEntrada("personas.txt");
    	while(!txtpersonas.isEndFile()) {
    		Registro reg = txtpersonas.getRegistro();
    		String codigo = reg.getString();
    		char [] identificacion = codigo.toCharArray();
    		if(identificacion[0]=='C') {//es un cliente
    			String nombre = reg.getString();
    			String apellido = reg.getString();
    			String telefono = reg.getString();
    			sistema.crearCliente(codigo, nombre, apellido, telefono);
    		}else if(identificacion[0]=='R') {//Es un recepcionistas
    			String nombre = reg.getString();
    			String apellido = reg.getString();
    			String telefono = reg.getString();
    			String correo = reg.getString();
    			int sueldo = reg.getInt();
    			sistema.crearRecepcionista(codigo, nombre, apellido, telefono, correo, sueldo);
    			
    		}else if(identificacion[0]=='G') {//Es un gerente
    			String nombre = reg.getString();
    			String apellido = reg.getString();
    			String telefono = reg.getString();
    			String correo = reg.getString();
    			int sueldo = reg.getInt();
    			sistema.crearGerente(codigo, nombre, apellido, telefono, correo, sueldo);
    		}else if(identificacion[0]=='O'){//Es otro trabajador
    			String nombre = reg.getString();
    			String apellido = reg.getString();
    			String telefono = reg.getString();
    			String correo = reg.getString();
    			int sueldo = reg.getInt();
    			sistema.crearOtroTrabajador(codigo, nombre, apellido, telefono, correo, sueldo);
    		}
    		
    	}
    }
	public static void cargarArchivosTXT(SistemaHotelero sistema)throws IOException {
		CargarTxtHabitaciones(sistema);
		CargarTxtPersonas(sistema);
		cargarTxtReservaciones(sistema);
		
	}
	public static void main(String[]args) throws IOException, ParseException {
		SistemaHotelero sistema = new SistemaHoteleroImpl();
		cargarArchivosTXT(sistema);
		menu(sistema);
	}
}
