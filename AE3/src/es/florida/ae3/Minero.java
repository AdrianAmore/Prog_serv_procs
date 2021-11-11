package es.florida.ae3;

public class Minero implements Runnable {

	int bolsa; //Acumulador del oro extraido
	int tiempoExtraccion = 1000; //Tiempo en milisegundos para cada turno
	Mina mina; //La mina sobre la que van a trabajar los mineros

	public Minero(Mina m) {
		this.bolsa = 0;
		this.mina = m;
	}

	/*
	 * extraerRecurso()
	 * Recibe: 
	 * -String(Nombre): el nombre del hilo (minero) que extrae el oro
	 * -int(oro): la cantidad que se va a extraer por ejecución
	 * Devuelve: void
	 */
	
	public void extraerRecurso(String nombre, int oro) throws InterruptedException {
		synchronized (mina) {
			while (mina.stock > 0) {
				Thread.sleep(tiempoExtraccion); //Tiempo entre turnos
				if (oro <= mina.stock) {
					mina.stock = (mina.stock - oro); //Actualizamos el oro restante en la mina
					this.bolsa = this.bolsa + oro; //Actualizamos el oro que ha sido extraido
					System.out.println(nombre + " extrae " + oro + " de oro | " + "Queda: " + mina.stock);
				}
			}
			System.out.println("No queda oro en la mina");

		}
	}

	public void run() {
		String nombre = Thread.currentThread().getName();
		// int oro = (int) (Math.random() * 1000 + 1);
		try {
			extraerRecurso(nombre, 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public int getBolsa() {
		return this.bolsa;
	}
}
