package com.paquete.Videojuego;

public class Rezo extends Arma{
	private String sonido = "WIIIIIIIISSSSSS";

	public Rezo(int danoEspecifico, String tipo) {
		super(danoEspecifico, tipo);
	}

	public void usar() {
		System.out.println(sonido);
		System.out.println("Ha quitado " + getDanoEspecifico() + " puntos de vida con la espada " + getTipo());
	}

}