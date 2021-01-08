package com.paquete.Videojuego;

public class ClasePrincipal {
	public static void main(String[] args) {
		CentroDeControl cc = new CentroDeControl();
		EntradaSalida es = new EntradaSalida();
		
		int[] datos = es.mostrarInicio();
		Arma arma1 = cc.crearArma(datos[0]);
		Personaje personaje1 = cc.crearPersonaje(datos);
		Personaje personaje2 = cc.crearPersonajeAleatorio();
		Arma arma2 = personaje2.getArma();
		cc.crearCombate(personaje1, arma1, personaje2, arma2);
		
	}
}
