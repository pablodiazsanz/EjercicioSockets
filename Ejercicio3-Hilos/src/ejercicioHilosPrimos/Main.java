package ejercicioHilosPrimos;

public class Main {
	
	public static void main(String[] args) {
		
		HiloThread htd = new HiloThread(62);
		htd.setName("HiloThread");
		
		HiloRunnable hr = new HiloRunnable(87);
		Thread thr = new Thread(hr);
		thr.setName("HiloRunnable");
		
		new HiloThis(33,"HiloThis");
		
		htd.start();
		thr.start();
	}
	
}
