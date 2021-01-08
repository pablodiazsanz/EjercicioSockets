
public class Habitacion {
	
	private int metrosCuadrados;
	private String tipoHabitacion;
	private int numeroHabitacion;
	
	
	public Habitacion(int metrosCuadrados, String tipoHabitacion, int numeroHabitacion) {
		this.metrosCuadrados = metrosCuadrados;
		this.tipoHabitacion = tipoHabitacion;
		this.numeroHabitacion = numeroHabitacion;
	}


	@Override
	public String toString() {
		return "Habitacion [metrosCuadrados=" + metrosCuadrados + ", tipoHabitacion=" + tipoHabitacion
				+ ", numeroHabitacion=" + numeroHabitacion + "]";
	}


	public double getMetrosCuadrados() {
		return metrosCuadrados;
	}


	public String getTipoHabitacion() {
		return tipoHabitacion;
	}


	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}
	
	
}
