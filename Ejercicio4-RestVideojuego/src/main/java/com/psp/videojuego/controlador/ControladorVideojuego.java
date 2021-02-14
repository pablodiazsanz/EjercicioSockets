package com.psp.videojuego.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psp.videojuego.modelo.entidad.Videojuego;

@RestController
public class ControladorVideojuego {
	
	private Videojuego sonic;
	
	@GetMapping("videojuego")
	public Videojuego obtenerVideojuegoGet() {
		sonic = new Videojuego(1, "Sonic", "Sega", 30);
		return sonic;
	}
	
	@PutMapping("videojuego")
	public Videojuego obtenerVideojuegoPut() {
		sonic = new Videojuego(1, "Sonic", "Sega", 30);
		sonic.setPrecio(sonic.getPrecio() + 10);
		return sonic;
	}
}
