package es.florida.ae1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Introduce una opción (1-8): ");
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
		case 7:
			salarioDesarrollador();
			break;
		case 8:
			intervalos();
			break;
		default:
			System.out.println("Opción no válida.");
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
			System.out.print("Introduce un numero: ");
			nums[i] = scan.nextInt();
		}
		int suma = 0;
		System.out.print("Numeros en orden inverso: ");
		for (int j = (nums.length - 1); j >= 0; j--) {
			System.out.print(nums[j] + " ");
			suma += nums[j];
		}
		System.out.println("");
		System.out.println("La suma de todos los valores es: " + suma);
	}

	// Actividad 7
	public static void salarioDesarrollador() {
		System.out.print("Introduce tu nombre: ");
		String nombre = scan.next();
		System.out.print("Introduce cuantos años llevas trabajando: ");
		int anyos = scan.nextInt();
		if (anyos < 1) {
			System.out.println("Desarrollador Junior L1 – 15000-18000");
		} else if (anyos < 3 && anyos > 0) {
			System.out.println("Desarrollador Junior L2 – 18000-22000");
		} else if (anyos <= 5 && anyos > 2) {
			System.out.println("Desarrollador Senior L1 – 22000-28000");
		} else if (anyos <= 8 && anyos > 4) {
			System.out.println("Desarrollador Senior L2 – 28000-36000");
		} else {
			System.out.println("Analista / Arquitecto. Salario a convenir en base a rol");
		}

	}

	// Actividad 8
	public static void intervalos() {
		System.out.print("Introduce el primer extremo: ");
		int n1 = scan.nextInt();
		System.out.print("Introduce el segundo extremo: ");
		int n2 = scan.nextInt();
		long inicio = System.currentTimeMillis();
		for (int i = n1; i <= n2; i++) {
			if (esPrimo(i)) {
				System.out.println(i + " Es primo");
			} else {
				System.out.println(i + " NO es primo");
			}

		}
		long fin = System.currentTimeMillis();

		System.out.println("Ha tardado " + (fin - inicio) + " milisegundos");
	}

	// Funcion que comprueba primos
	static boolean esPrimo(int n) {
		// revisa si n es multiplo de 2
		if (n % 2 == 0)
			return false;
		// si no, solo revisa los impares
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
