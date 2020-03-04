/**
 * 
 */
package Dominio;

/**
 * @author sebastiansanchez
 *
 */
public class Habitacion {
	private int NumHabitacion;
	private int valorDia;
	private String tipo;
	/**
	 * 
	 */
	public Habitacion(int NumHabitacion,int valorDia,String tipo) {
		// TODO Auto-generated constructor stub
		this.NumHabitacion = NumHabitacion;
		this.valorDia = valorDia;
		this.tipo = tipo;
		
	}
	/**
	 * @return the numHabitacion
	 */
	public int getNumHabitacion() {
		return NumHabitacion;
	}
	/**
	 * @param numHabitacion the numHabitacion to set
	 */
	public void setNumHabitacion(int numHabitacion) {
		NumHabitacion = numHabitacion;
	}
	/**
	 * @return the valorDia
	 */
	public int getValorDia() {
		return valorDia;
	}
	/**
	 * @param valorDia the valorDia to set
	 */
	public void setValorDia(int valorDia) {
		this.valorDia = valorDia;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}
