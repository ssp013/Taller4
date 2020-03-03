package Dominio;

public class Recepcionista extends Persona {
	private String correo;
	private int sueldo;
	
	public Recepcionista(String Codigo, String nombre, String apellido, String telefono,String correo,int sueldo) {
		// TODO Auto-generated constructor stub
		super(Codigo, nombre,apellido, telefono);
		this.correo = correo;
		this.sueldo = sueldo;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the sueldo
	 */
	public int getSueldo() {
		return sueldo;
	}

	/**
	 * @param sueldo the sueldo to set
	 */
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	
}
