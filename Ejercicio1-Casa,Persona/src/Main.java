import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Direccion direccionPropietario = new Direccion("Calle", "Estudiante", 23456, 5);
		Direccion direccionInquilino = new Direccion("Calle", "Trabajador", 29876, 7);
		
		ArrayList<Persona> inquilinos = new ArrayList<Persona>();
		
		Persona propietario = new Persona("Alfredo", "12345678A", 611222333, direccionPropietario);
		Persona inquilino = new Persona("Ismael", "98765432Z", 699888777, direccionInquilino);
		
		inquilinos.add(inquilino);
		
		Habitacion salon = new Habitacion(32, "Salon", 1);
		Habitacion cocina = new Habitacion(18, "Cocina", 2);
		Habitacion baño = new Habitacion(8, "Baño", 3);
		Habitacion despacho = new Habitacion(15, "Despacho", 4);
		Habitacion dormitorio = new Habitacion(14, "Dormitorio", 5);
		
		ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
		habitaciones.add(salon);
		habitaciones.add(cocina);
		habitaciones.add(baño);
		habitaciones.add(despacho);
		habitaciones.add(dormitorio);
		
		Casa casaAlquilada = new Casa(direccionInquilino, habitaciones, propietario, inquilinos, 650);
		int m2casaAlquilada = casaAlquilada.getMetrosCuadrados(habitaciones);
		System.out.println(casaAlquilada);
		System.out.println("La casa alquilada tiene " + m2casaAlquilada + " metros cuadrados");
		
	}

}
