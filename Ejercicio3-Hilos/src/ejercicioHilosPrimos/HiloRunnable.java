package ejercicioHilosPrimos;

import java.util.Date;

public class HiloRunnable implements Runnable{

	private int primo;

	public HiloRunnable(int primo) {
		this.primo = primo;
	}
	
	@Override
	public void run() {

		int contador = 2;
		boolean numPrimo = true;
		Date tiempo = new Date();
		long tiempoActual = tiempo.getTime();

		Date date = new Date();

		System.out.println("Arrancando hilo: " + Thread.currentThread().getName());

		while ((numPrimo) && (contador != primo)) {
			if (primo % contador == 0)
				System.out.println("El numero " + primo + " no es un Numero Primo");
			numPrimo = false;
			contador++;
		}

		if (numPrimo) {
			System.out.println("El numero " + primo + " es un Numero Primo");
		}

		System.out.println("Hilo: " + Thread.currentThread().getName() + " acabado en "
				+ (date.getTime() - tiempoActual) + " milisegundos.");

	}
}
