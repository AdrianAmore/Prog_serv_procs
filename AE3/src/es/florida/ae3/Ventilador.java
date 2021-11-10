package es.florida.ae3;

public class Ventilador {

	boolean modo;
	int tiempo = 1000;

	public void encenderVentilador() {
		this.modo = true;
	}

	public void apagarVentilador() {
		this.modo = false;
	}

}
