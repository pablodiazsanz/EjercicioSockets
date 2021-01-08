package com.paquete.Videojuego;

public abstract class Personaje {
	private Arma arma;
	private String nombre;
	private int puntosDeVida;
	private int atributoEspecifico;
	
	public Personaje(Arma arma, String nombre, int puntosDeVida, int atributoEspecifico) {
		this.arma = arma;
		this.nombre = nombre;
		this.puntosDeVida = puntosDeVida;
		this.atributoEspecifico = atributoEspecifico;
	}

	public Arma getArma() {
		return arma;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPuntosDeVida() {
		return puntosDeVida;
	}

	public void setPuntosDeVida(int puntosDeVida) {
		this.puntosDeVida = puntosDeVida;
	}

	public int getAtributoEspecifico() {
		return atributoEspecifico;
	}

	public abstract int atacar();
	
}
