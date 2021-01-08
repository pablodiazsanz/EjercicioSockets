package com.paquete.Videojuego;

import java.util.Scanner;

public class EntradaSalida {
	
	public int[] mostrarInicio() {
		int arma, personaje;
		Scanner sc = new Scanner(System.in);
		System.out.println("GUERRA DE TITANES. LA MALDICION DEL DRAGÓN");
		elegirArma();
		arma = sc.nextInt();
		elegirPersonaje();
		personaje = sc.nextInt();
		int[] datos = {arma, personaje};
		return datos;
	}

	private void elegirPersonaje() {
		System.out.println("¿Qué personaje desea utilizar para el combate?");
		System.out.println(CentroDeControl.GUERRERO + ". GUERRERO");
		System.out.println(CentroDeControl.MAGO + ". MAGO");
		System.out.println(CentroDeControl.CURANDERO + ". CURANDERO");
	}

	private void elegirArma() {
		System.out.println("¿Qué arma desea utilizar para el combate?");
		System.out.println(CentroDeControl.ARCO + ". ARCO");
		System.out.println(CentroDeControl.ESPADA + ". ESPADA");
		System.out.println(CentroDeControl.HECHIZO + ". HECHIZO");
		System.out.println(CentroDeControl.REZO + ". REZO");
	}
	
	public void comenzarCombate(Personaje personaje1, Arma arma1, Personaje personaje2, Arma arma2) {
		System.out.println("Ha escogido al: " + personaje1.getNombre() + " con " + arma1.getTipo() + ".\nSu contrincante "
				+ "sera: " + personaje2.getNombre() + " con " + arma2.getTipo() + ".\n");
		
	}
	
	public int eleccionContinuar() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Que desea hacer");
		System.out.println(CentroDeControl.LUCHAR + ". ¡LUCHAR!");
		System.out.println(CentroDeControl.RENDIRSE + ". Rendirse :(");
		return sc.nextInt();
	}
	
}
