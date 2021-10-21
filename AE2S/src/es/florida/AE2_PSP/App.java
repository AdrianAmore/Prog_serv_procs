package es.florida.AE2_PSP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

	static File p = new File(System.getProperty("user.dir"));

	// Obtiene por parametros una ruta y el nombre del archivo a crear y crea el
	// archivo
	public static void creaFitxer(String path, String name) {

		try {
			String dir = path + File.separator + name + ".txt"; // Al nombre le asigna .txt para poder crear el archivo
																// de texto.
			File f1 = new File(dir);
			f1.createNewFile();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Obtiene el nombre del archivo y lo que debe escribir en el y lo escribe
	public static void escribir(String archivo, String escritura) {
		try {
			FileWriter myWriter = new FileWriter(archivo + ".txt");
			myWriter.write(escritura);
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Recibe por parametros el nombre, posicion y velocidad del NEO, calcula la
	// probabilidad de colision del NEO y muestra los correspondientes avisos.
	// Tambi�n crea la carpeta donde se almacenan los txt de los neos y crea los
	// archivos dento
	public static void calcularColision(String nombreNEO, double posicionNEO, double velocidadNEO) {
		double posicionTierra = 1;
		double velocidadTierra = 100;
		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
			posicionNEO = posicionNEO + velocidadNEO * i;
			posicionTierra = posicionTierra + velocidadTierra * i;
		}
		double resultado = 100 * Math.random()
				* Math.pow(((posicionNEO - posicionTierra) / (posicionNEO + posicionTierra)), 2);
		BigDecimal bd = new BigDecimal(resultado);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		if (resultado > 10) {
			System.err.println(nombreNEO + ": " + bd + " ---> AVISO! COLISION INMINENTE!");

		} else {
			System.out.println(nombreNEO + ": " + bd +" ---> Probabilidades de impacto bajas, mantengan la calma");
		}
		creaFitxer(p.toString(), File.separator + "Probabilitats_NEOs" + File.separator + nombreNEO); // Creamos el
																										// fichero
		escribir(p.toString() + File.separator + "Probabilitats_NEOs" + File.separator + nombreNEO,
				bd.toString() + "% de probabilidades de impacto"); // Escribimos el fichero
	}

	public static void main(String[] args) {

		calcularColision(args[0], Double.parseDouble(args[1]), Double.parseDouble(args[2]));

	}

}
