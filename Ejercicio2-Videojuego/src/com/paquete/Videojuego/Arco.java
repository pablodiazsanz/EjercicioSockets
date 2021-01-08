package com.paquete.Videojuego;

public class Arco extends Arma{
	private String sonido = "SWIIINNNNGGGGG";

	public Arco(int danoEspecifico, String tipo) {
		super(danoEspecifico, tipo);
	}

	public void usar() {
		System.out.println(sonido);
		System.out.println("Ha quitado " + getDanoEspecifico() + " puntos de vida con el arco " + getTipo());
	}

}
