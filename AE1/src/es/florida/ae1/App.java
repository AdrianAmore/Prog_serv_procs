package es.florida.ae1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int op = scan.nextInt();
		switch (op) {
		case 1:
			sayHello();
			break;
		case 2:
			muestraCompas();
			break;
		case 3:
			int limite = Integer.parseInt(args[0]);
			sumaPares(limite);
			break;
		case 4:
			factorial();
			break;
		case 5:
			int[] arrayPrueba = { 1, 5, 48, 12, 33, 128, 11, 42 };
			mayorDelArray(arrayPrueba);
			break;
		case 6:
			sumaArray();
			break;

		}

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

	// Actividad 4
	public static void factorial() {
		int fact = 1;
		for (int i = 1; i <= 15; i++) {
			fact *= i;
		}
		System.out.println("El factorial es: " + fact);
	}

	// Actividad 5
	public static void mayorDelArray(int[] lista) {
		int max = Arrays.stream(lista).max().getAsInt();
		System.out.println("El numero mas grande es: " + max);
	}

	// Actividad 6
	public static void sumaArray() {
		int[] nums = new int[5];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = scan.nextInt();
		}
		int suma = 0;
		for (int j = nums.length; j >= 0; j--) {
			System.out.println(nums[j]);
			suma += nums[j];
		}
		System.out.println("La suma de todos los valores es: " + suma);
	}

}
