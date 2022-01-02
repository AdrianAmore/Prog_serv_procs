package es.florida.ae4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String host = "localhost";
		int port = 1234;
		System.out.println("CLIENTE -> Inicia cliente");
		Socket socketCliente = new Socket(host, port);
		ObjectInputStream inPass = new ObjectInputStream(socketCliente.getInputStream());
		Contrasena pass = (Contrasena) inPass.readObject();
		Scanner sc = new Scanner(System.in);
		pass.askPlainTextPassword(sc);
		pass.askEncryptionType(sc);
		sc.close();
		ObjectOutputStream outPass = new ObjectOutputStream(socketCliente.getOutputStream());
		outPass.writeObject(pass);
		pass = (Contrasena) inPass.readObject();
		System.err.println("SERVIDOR -> Contraseña plana: " + pass.getplainTextPassword() + " - Contraseña encriptada: "
				+ pass.getencryptedPassword() + " - Tipo de encriptación: " + pass.isMD5());
		inPass.close();
		outPass.close();
		socketCliente.close();
	}

}
