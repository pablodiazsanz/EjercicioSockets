package com.p.concesionario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.p.concesionario.modelo.entidad.Coche;
import com.p.concesionario.modelo.persistencia.DaoCoche;

@SpringBootApplication
public class Ejercicio5ConcesionarioRestApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Ejercicio5ConcesionarioRestApplication.class, args);
		

		DaoCoche daoCoche = context.getBean("daoCoche", DaoCoche.class);
		
		Coche c = new Coche();
		c.setMarca("Porsche");
		c.setModelo("718 Cayman T");
		c.setMatricula("2876LSB");
		c.setPotencia(300);
		
		daoCoche.save(c);
	}
	
}
