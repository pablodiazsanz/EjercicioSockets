package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketC {

	public static final int PUERTO = 2021;
	public static final String IP_SERVER = "localhost";
	public static final int SUMAR = 1;
	public static final int RESTAR = 2;
	public static final int MULTIPLICAR = 3;
	public static final int DIVIDIR = 4;
	static Scanner sc;

	public static void main(String[] args) {
		System.out.println("        APLICACIÓN CLIENTE");
		System.out.println("-----------------------------------");

		Socket socketCliente = null;
		InputStreamReader entrada = null;
		PrintStream salida = null;

		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);

		sc = new Scanner(System.in);

		try {

			boolean continuar = true;
			do {
				socketCliente = new Socket();
				socketCliente.connect(direccionServidor);
				System.out.println("Conexion establecida... a " + IP_SERVER + " por el puerto " + PUERTO);

				entrada = new InputStreamReader(socketCliente.getInputStream());
				salida = new PrintStream(socketCliente.getOutputStream());

				System.out.println("CLIENTE: Introduzca un numero:");
				String numero1 = sc.nextLine();
				System.out.println("CLIENTE: Introduzca otro numero:");
				String numero2 = sc.nextLine();
				System.out.println("CLIENTE: ¿Que desea hacer?");
				String numero3 = operaciones();
				String operandos = numero1 + "-" + numero2 + "-" + numero3;
				salida.println(operandos);

				BufferedReader bf = new BufferedReader(entrada);
				String resultado = bf.readLine();

				switch (Integer.parseInt(numero3)) {
				case SUMAR:
					System.out.println("CLIENTE: El resultado de la suma entre el numero " + numero1 + " y el numero "
							+ numero2 + " es: " + resultado);
					break;
				case RESTAR:
					System.out.println("CLIENTE: El resultado de la resta entre el numero " + numero1 + " y el numero "
							+ numero2 + " es: " + resultado);
					break;
				case MULTIPLICAR:
					System.out.println("CLIENTE: El resultado de la multiplicacion entre el numero " + numero1
							+ " y el numero " + numero2 + " es: " + resultado);
					break;
				case DIVIDIR:
					System.out.println("CLIENTE: El resultado de la division entre el numero " + numero1
							+ " y el numero " + numero2 + " es: " + resultado);
					break;
				}

				System.out.println("CLIENTE: ¿Desea realizar otra operacion? S/N");
				String sContinuar = sc.nextLine();

				while (!sContinuar.equalsIgnoreCase("n") && !sContinuar.equalsIgnoreCase("s")) {
					System.out.println("Por favor, escriba 'S' si desea continuar o 'N' si desea salir");
					sContinuar = sc.nextLine();
				}

				if (sContinuar.equalsIgnoreCase("n")) {
					continuar = false;
				}

			} while (continuar);
		} catch (Exception e) {
			System.err.println("Error: " + e);
			e.printStackTrace();

		} finally {
			try {
				if (salida != null) {
					salida.close();
				}
				if (entrada != null) {
					entrada.close();
				}
				if (socketCliente != null) {
					socketCliente.close();
				}
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String operaciones() {
		System.out.println(SUMAR + ".- Sumar");
		System.out.println(RESTAR + ".- Restar");
		System.out.println(MULTIPLICAR + ".- Multiplicar");
		System.out.println(DIVIDIR + ".- Dividir");
		String numero3 = sc.nextLine();
		return numero3;
	}

}