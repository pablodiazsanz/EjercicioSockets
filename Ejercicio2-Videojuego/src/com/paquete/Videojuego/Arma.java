package com.paquete.Videojuego;

public abstract class Arma {
	private int danoEspecifico;
	private String tipo;
	
	
	public Arma(int danoEspecifico, String tipo) {
		this.danoEspecifico = danoEspecifico;
		this.tipo = tipo;
	}


	public int getDanoEspecifico() {
		return danoEspecifico;
	}


	public String getTipo() {
		return tipo;
	}
	
	public abstract void usar();
	
}
