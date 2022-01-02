package es.florida.ae4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Peticion implements Runnable {
	Socket clientSocket;

	public Peticion(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {
		try {
			ObjectOutputStream outPass = new ObjectOutputStream(clientSocket.getOutputStream());
			Contrasena pass = new Contrasena(null, null);

			outPass.writeObject(pass);
			System.err.println("SERVIDOR -> Contraseña plana: " + pass.getplainTextPassword() + " - Contraseña encriptada: "
					+ pass.getencryptedPassword() + " - Tipo de encriptación: " + pass.isMD5());

			ObjectInputStream inPass = new ObjectInputStream(clientSocket.getInputStream());
			pass = (Contrasena) inPass.readObject();
			System.err.println("SERVIDOR -> Contraseña plana: " + pass.getplainTextPassword() + " - Contraseña encriptada: "
					+ pass.getencryptedPassword() + " - Tipo de encriptación: " + pass.isMD5());

			pass.encrypt();
			outPass.writeObject(pass);
			System.err.println("SERVIDOR -> Contraseña plana: " + pass.getplainTextPassword() + " - Contraseña encriptada: "
					+ pass.getencryptedPassword() + " - Tipo de encriptación: " + pass.isMD5());

			// Cerramos todo
			outPass.close();
			inPass.close();
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
