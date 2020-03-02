package Dominio;

public class Persona {
	private String Codigo;
	private String nombre;
	private String apellido;
	private String telefono;
	public Persona(String Codigo, String nombre, String apellido, String telefono) {
		// TODO Auto-generated constructor stub
		this.Codigo = Codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return Codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
