package com.paquete.Videojuego;

public class Curandero extends Personaje {
	private String grito = "SQUIIIIISSSSSSHHH";
	private int danoRealizado;
	private int num, numAleatorio;

	public Curandero(Arma arma, String nombre, int puntosDeVida, int atributoEspecifico) {
		super(arma, nombre, puntosDeVida, atributoEspecifico);
	}

	public int atacar() {
		System.out.println(grito);
		getArma().usar();
		num = (int) Math.floor(Math.random() * 9 + 1);
		numAleatorio = (int) Math.floor(Math.random() * 9 + 1);
		if (num == numAleatorio) {
			System.out.println("GOLPE CRITICO");
			danoRealizado = 2000;
			System.out.println("Daño Realizado: " + danoRealizado);
		} else {
			if (getArma().getClass() == Rezo.class) {
				danoRealizado = getArma().getDanoEspecifico() + getAtributoEspecifico();
				System.out.println(getNombre() + " ha utilizado un arma de su atributo especial SABIDURIA");
				System.out.println("Daño Realizado: " + danoRealizado);
			} else {
				danoRealizado = getArma().getDanoEspecifico();
				System.out.println(getNombre() + " ha atacado a su rival.");
				System.out.println("Daño Realizado: " + danoRealizado);
			}
		}
		return danoRealizado;
	}

}