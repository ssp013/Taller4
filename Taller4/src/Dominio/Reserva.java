/**
 * 
 */
package Dominio;

/**
 * @author sebastiansanchez
 *
 */
public class Reserva {

	/**
	 * 
	 */
	private String codReserva;
	private String fechaInicio;
	private String fechaTermino;
	
	public Reserva(String codReserva,String fechaInicio,String fechaTermino) {
		// TODO Auto-generated constructor stub
		this.codReserva = codReserva;
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
	}

	/**
	 * @return the codReserva
	 */
	public String getCodReserva() {
		return codReserva;
	}

	/**
	 * @param codReserva the codReserva to set
	 */
	public void setCodReserva(String codReserva) {
		this.codReserva = codReserva;
	}

	/**
	 * @return the fechaInicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaTermino
	 */
	public String getFechaTermino() {
		return fechaTermino;
	}

	/**
	 * @param fechaTermino the fechaTermino to set
	 */
	public void setFechaTermino(String fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	

}
