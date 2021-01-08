package com.paquete.Videojuego;

import java.util.HashMap;

public class CentroDeControl {

	public static final int ARCO = 1;
	public static final int ESPADA = 2;
	public static final int HECHIZO = 3;
	public static final int REZO = 4;

	public static final int GUERRERO = 1;
	public static final int MAGO = 2;
	public static final int CURANDERO = 3;
	
	public static final int LUCHAR = 1;
	public static final int RENDIRSE = 2;

	/**
	 * private static String obtenerNombreArma(int[] datos) { HashMap<Integer,
	 * String> arma = new HashMap<Integer, String>(); arma.put(1, "ARCO");
	 * arma.put(2, "ESPADA"); arma.put(3, "HECHIZO"); arma.put(4, "REZO"); String
	 * armaSeleccionada = arma.get(datos[0]); return armaSeleccionada; }
	 */

	public String obtenerNombrePersonaje(int[] datos) {
		HashMap<Integer, String> personaje = new HashMap<Integer, String>();
		personaje.put(1, "GUERRERO");
		personaje.put(2, "MAGO");
		personaje.put(3, "CURANDERO");
		String personajeSeleccionado = personaje.get(datos[1]);
		return personajeSeleccionado;
	}

	public Arma crearArma(int datos) {
		Arma miArma = null;

		switch (datos) {
		case ARCO:
			miArma = new Arco(483, "Arco de Oro");
			break;

		case ESPADA:
			miArma = new Espada(512, "Espada de Diamante");
			break;

		case HECHIZO:
			miArma = new Hechizo(469, "Hechizo Radioactivo");
			break;

		case REZO:
			miArma = new Rezo(460, "Rezo Curativo");
			break;
		}

		return miArma;
	}
	
	public Arma crearArmaAleatorio() {
		int numAleatorio = (int) Math.floor(Math.random()*2+1);
		Arma arma2 = crearArma(numAleatorio);
		return arma2;
	}
	
	public Personaje crearPersonajeAleatorio() {
		int numAleatorio = (int) Math.floor(Math.random()*2+1);
		int numAleatorioArma = (int) Math.floor(Math.random()*3+1);
		int[]datos = {numAleatorioArma, numAleatorio};
		Personaje personaje2 = crearPersonaje(datos);
		return personaje2;
	}

	public Personaje crearPersonaje(int[] datos) {
		Personaje miPersonaje = null;
		
		switch (datos[1]) {
		case GUERRERO:
			miPersonaje = new Guerrero(crearArma(datos[0]), "Guerrero Thor", 1765, 83); 
			break;

		case MAGO:
			miPersonaje = new Mago(crearArma(datos[0]), "Mago Iron Man", 1765, 83); 
			break;
				
		case CURANDERO:
			miPersonaje = new Curandero(crearArma(datos[0]), "Curandero Capitan America", 1765, 83); 
			break;
		}
	
		return miPersonaje;
	}
	
	private int combatir(Personaje personaje1, Arma arma1, Personaje personaje2, Arma arma2) {
		personaje2.setPuntosDeVida(personaje2.getPuntosDeVida() - personaje1.atacar());
		personaje1.setPuntosDeVida(personaje1.getPuntosDeVida() - personaje2.atacar());
		if (personaje1.getPuntosDeVida() <= 0 | personaje2.getPuntosDeVida() <= 0) {
			System.out.println("EL COMBATE HA FINALIZADO");
			if (personaje1.getPuntosDeVida() < personaje2.getPuntosDeVida()) {
				System.out.println("HA GANADO " + personaje2.getNombre());
			} else {
				System.out.println("HA GANADO " + personaje1.getNombre());
			}
			System.out.println(resultado(personaje1, personaje2));
			return 2;
		} else{
			System.out.println(resultado(personaje1, personaje2));
		}
		return 1;
	}
	
	public void crearCombate(Personaje personaje1, Arma arma1, Personaje personaje2, Arma arma2) {
		EntradaSalida es = new EntradaSalida();
		es.comenzarCombate(personaje1, arma1, personaje2, arma2);
		int fin = 1, eleccion = 1;
		while (eleccion == 1 && fin == 1) {
			eleccion = es.eleccionContinuar();
			if (eleccion == 1) {
				fin = combatir(personaje1, arma1, personaje2, arma2);
			}
		}
		System.out.println("¡HASTA LA PROXIMA!");
	}
	
	private String resultado(Personaje personaje1, Personaje personaje2) {
		return personaje1.getNombre() + " = " + 
				personaje1.getPuntosDeVida() + " || " + personaje2.getNombre() + " = " + personaje2.getPuntosDeVida();
	}
}
