package com.paquete.Videojuego;

public class Hechizo extends Arma{
	private String sonido = "ZAAASSSSSSSSSS";

	public Hechizo(int danoEspecifico, String tipo) {
		super(danoEspecifico, tipo);
	}

	public void usar() {
		System.out.println(sonido);
		System.out.println("Ha quitado " + getDanoEspecifico() + " puntos de vida con la espada " + getTipo());
	}

}