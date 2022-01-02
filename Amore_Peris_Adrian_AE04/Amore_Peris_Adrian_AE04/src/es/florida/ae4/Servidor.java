package es.florida.ae4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		System.err.println("SERVIDOR -> Inicia el servidor, esperando petición...");
		ServerSocket listeningSocket = null;
		try {
			listeningSocket = new ServerSocket(1234);
		} catch (IOException e) {
			System.err.println("SERVIDOR -> Error");
			e.printStackTrace();
		}

		while (true) {
			Socket connection = listeningSocket.accept();
			System.err.println("SERVIDOR -> Conexión recibida");
			Peticion p = new Peticion(connection);
			Thread t = new Thread(p);
			t.start();
		}
	}

}
