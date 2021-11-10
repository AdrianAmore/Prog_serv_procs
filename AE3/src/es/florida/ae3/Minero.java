package es.florida.ae3;

public class Minero implements Runnable {

	int bolsa;
	int tiempoExtraccion = 1000;
	Mina mina;

	public Minero(Mina m) {
		this.bolsa = 0;
		this.mina = m;
	}

	public void extraerRecurso(String nombre, int oro) throws InterruptedException {
		synchronized (mina) {
			while (mina.stock > 0) {
				Thread.sleep(tiempoExtraccion);
				if (oro <= mina.stock) {
					mina.stock = (mina.stock - oro);
					this.bolsa = this.bolsa + oro;
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
