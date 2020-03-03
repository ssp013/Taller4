package Logica;
import java.io.IOException;
import java.text.ParseException;

import Dominio.*;

import ucn.*;
public class App {
	public static int opcion1(SistemaHotelero sistema, int cont){
		StdOut.println("Ingrese Nombre: ");
		String nom = StdIn.readString();
		StdOut.println("Ingrese Apellido: ");
		String ap = StdIn.readString();
		StdOut.println("Ingrese telefono: ");
		String tel = StdIn.readString();
		
		String cod = sistema.existePersona(nom, ap, tel);
		if(cod != null) {
			StdOut.println("Ingrese fecha inicio: ");
			String fechaInicio = StdIn.readString();
			StdOut.println("Ingrese fecha de salida: ");
			String fechaTermino = StdIn.readString();
			int[] listaDisponible = sistema.HabitacionesDisponibles(fechaInicio, fechaTermino);
			StdOut.println(sistema.detallesHabitaciones(listaDisponible));
			StdOut.println("Seleccione una de estas habitaciones: ");
			int numero = StdIn.readInt();
			boolean op=false;
		
			while(!op) {
				for(int i=0;i<listaDisponible.length;i++) {
					if(numero==listaDisponible[i]) {
						op=true;
						break;
					}
				}
				if(!op) {
					StdOut.println("Ingrese de nuevo la habitación!!!");
					numero = StdIn.readInt();
				}
			}
		}
		else {
			cont +=1;
			cod ="C"+cont;
			if(sistema.crearCliente(cod, nom, ap, tel)) {
				//Preguntarmos fechas:
				StdOut.println("Ingrese fecha inicio: ");
				String fechaInicio = StdIn.readString();
				StdOut.println("Ingrese fecha de salida: ");
				String fechaTermino = StdIn.readString();
				int[] listaDisponible = sistema.HabitacionesDisponibles(fechaInicio, fechaTermino);
				StdOut.println(sistema.detallesHabitaciones(listaDisponible));
				StdOut.println("Seleccione una de estas habitaciones: ");
			}else {
				StdOut.println("No se pudo crear este cliente!");
			}
			
		}
		return cont;
		
	}

	public static void menu(SistemaHotelero System) throws IOException, ParseException {
		StdOut.println("******** Menú *****************\n 1. Opción reservar habitación\n 2. Opción Reservaciones\n 3. Opción Sueldos\n 4. Salir");
		int cliente = 7;
        StdOut.println("Ingrese una opción: ");
        String op = StdIn.readString();
    
        while(!op.equals("4")) {
        	if(op.equals("1")){
        		cliente = opcion1(System, cliente);
        	}
       }
	}
	public static void main(String[]args) throws IOException, ParseException {
		SistemaHotelero sistema = new SistemaHoteleroImpl();
		menu(sistema);
	}
}
