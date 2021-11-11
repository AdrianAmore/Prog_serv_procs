package es.florida.ae3;

import java.util.ArrayList;

public class App {
//Aunque la app cuenta con la clase ventilador no he hecho la ampliación
	public static void main(String[] args) {
		Ventilador vent = new Ventilador();
		Mina mine = new Mina(1000);
		ArrayList<Minero> miners = new ArrayList<Minero>(); //Array de mineros donde se almacenan todos los mineros que van a trabajar en la mina
		Thread t;
		for (int i = 0; i < 10; i++) {
			Minero miner = new Minero(mine);
			miners.add(miner);
			t = new Thread(miner);
			t.setName("Minero " + (i + 1));
			t.start();
		}
		try {
			Thread.sleep(12000); //Tiempo de espera para que no saque el mensaje final antes que los mensajes de extracción
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int contador = 0;
		for (Minero p : miners) { //Recorremos la array de mineros sumando todo el oro de sus bolsas para ver cuanto oro se ha extraido
			contador += p.getBolsa();
		}
		System.err.println("Total de oro extraido: " + contador);

	}

}
