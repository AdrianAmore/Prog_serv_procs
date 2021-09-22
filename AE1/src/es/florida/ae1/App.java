package es.florida.ae1;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {

	}

	// Actividad 1
	public static void sayHello() {
		System.out.println("Hola Mundo");
	}

	// Actividad 2
	public static void muestraCompas() {
		// 2-a
		String[] compasArray = { "Jose", "Ruben", "Adrian", "Fran", "Enrique", "Alejandro" };
		System.out.println("----Parte 1----");
		for (int i = 0; i < compasArray.length; i++) {
			System.out.println(compasArray[i]);
		}

		// 2-b
		List<String> compasLista = new ArrayList<String>();
		compasLista.add("Jose");
		compasLista.add("Ruben");
		compasLista.add("Adrian");
		compasLista.add("Fran");
		compasLista.add("Enrique");
		compasLista.add("Alejandro");
		System.out.println("----Parte 2----");
		for (int i = 0; i < compasLista.size(); i++) {
			System.out.println(compasLista.get(i));
		}
	}

	// Actividad 3
	public static void sumaPares(int limite) {
		int suma = 0;
		for (int i = 1; i <= limite; i++) {
			if (i % 2 == 0) {
				suma += i;
			}
		}
		System.out.println("El resultado es: " + suma);
	}

}
