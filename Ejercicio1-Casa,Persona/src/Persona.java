
public class Persona {
	
	private String nombre;
	private String dni;
	private int telefono;
	private Direccion direccion;
	
	
	public Persona(String nombre, String dni, int telefono, Direccion direccion) {
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.direccion = direccion;
	}


	public String getNombre() {
		return nombre;
	}


	public String getDni() {
		return dni;
	}


	public int getTelefono() {
		return telefono;
	}


	public Direccion getDireccion() {
		return direccion;
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", dni=" + dni + ", telefono=" + telefono + ", direccion=" + direccion
				+ "]";
	}
	
	
}
