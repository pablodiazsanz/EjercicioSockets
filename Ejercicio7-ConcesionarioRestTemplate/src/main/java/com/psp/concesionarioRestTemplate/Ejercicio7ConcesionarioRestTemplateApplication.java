package com.psp.concesionarioRestTemplate;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.psp.concesionarioRestTemplate.modelo.entidad.Coche;
import com.psp.concesionarioRestTemplate.modelo.proxy.CocheProxy;

@SpringBootApplication
public class Ejercicio7ConcesionarioRestTemplateApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Ejercicio7ConcesionarioRestTemplateApplication.class, args);
		
		CocheProxy cProxy = 
				context.getBean("cocheProxy",CocheProxy.class);
		
		System.out.println("LISTAR");
		List<Coche> listaCoches = cProxy.listar();
		System.out.println(listaCoches);
		
		System.out.println("OBTENER");
		Coche c1 = cProxy.obtener(1);
		System.out.println(c1);
		
		Coche c2 = new Coche();
		c2.setMarca("Ferrari");
		c2.setModelo("Roma");
		c2.setMatricula("5415LTG");
		c2.setPotencia(600);
		
		System.out.println("ALTA");
		c2 = cProxy.alta(c2);
		System.out.println(c2);
		
		System.out.println("MODIFICAR");
		Coche c3 = cProxy.modificar(c2);
		System.out.println(c3);
		
		System.out.println("BORRAR");
		cProxy.borrar(1);
		System.out.println("Coche borrado");
	}

}
