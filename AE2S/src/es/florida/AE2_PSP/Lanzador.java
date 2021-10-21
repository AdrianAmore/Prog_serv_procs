package es.florida.AE2_PSP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lanzador {
	//Metodo que recibe el valor y las posiciones a redondear y devuelve el numero redondeado
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	static int cores = Runtime.getRuntime().availableProcessors(); //Cores actuales del equipo.
	static File p = new File(System.getProperty("user.dir")); // Obtenemos el directorio actual.

	// Recibe un file con la ruta donde se va a crear la carpeta y la crea.
	// Aun que no era necesario he decidido agrupar los archivos de texto dentro de
	// una carpeta para mayor organización.
	public static void creaCarpeta(File f) {

		String dir = f + File.separator + "Probabilitats_NEOs"; // Y le asigna el nombre para crearla.
		File f1 = new File(dir);
		f1.mkdirs();
	}

	public void lanzar(String nombreNEO, double posicionNEO, double velocidadNEO) {
		String clase = "es.florida.AE2_PSP.App";
		try {

			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			String className = clase;

			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(nombreNEO);
			command.add(Double.toString(posicionNEO));
			command.add(Double.toString(velocidadNEO));

// System.out.println("Comando que se pasa a ProcessBuilder: " + command);
// System.out.println("Comando a ejecutar en cmd.exe: " + command.toString().replace(",",""));

			ProcessBuilder builder = new ProcessBuilder(command);
			Process process = builder.inheritIO().start();
// Process process = builder.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		Lanzador l = new Lanzador();
		
		Scanner sc;
		creaCarpeta(p);
		File myObj = new File("NEOs.txt");
		sc = new Scanner(myObj);
		int i = 0;
		long startTime = System.nanoTime();
		while (sc.hasNextLine() && cores > i) {
			String linea = sc.nextLine();
			List<String> lista = Arrays.asList(linea.split(",")); // Array que obtiene los valores separados por una
																	// coma.
			String nombre = lista.get(0);
			double pos = Double.parseDouble(lista.get(1));
			double vel = Double.parseDouble(lista.get(2));
			l.lanzar(nombre, pos, vel);
			i++;
		}
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		double seconds = (double) duration / 1_000_000_0.0;
		seconds = round(seconds,2);
		Thread.sleep(5000);
		System.out.println("-------------------------------------------");
		System.out.println("		DURACIÓN			");
		System.out.println("-------------------------------------------");
		System.out.println("Duración total: " + seconds + " segundos");
		System.out.println("Duración media: " + seconds / cores + " segundos");
		sc.close();
	} 

}
