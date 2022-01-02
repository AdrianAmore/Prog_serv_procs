package es.florida.ae4;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

@SuppressWarnings("serial")
public class Contrasena implements Serializable {
	// ATRIBUTOS
	private String plainTextPassword;
	private String encryptedPassword;
	private boolean encryptionType;

	// CONSTRUCTORES
	public Contrasena(String plainTextPassword, String encryptedPassword) {
		this.plainTextPassword = plainTextPassword;
		this.encryptedPassword = encryptedPassword;
	}

	// GETTERS Y SETTERS
	public String getplainTextPassword() {
		return plainTextPassword;
	}

	public String getencryptedPassword() {
		return encryptedPassword;
	}

	public boolean getencryptionType() {
		return encryptionType;
	}

	public void setplainTextPassword(String plainTextPassword) {
		this.plainTextPassword = plainTextPassword;
	}

	public void setencryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public void setencryptionType(boolean encryptionType) {
		this.encryptionType = encryptionType;
	}

	// MÉTODOS

	public void askPlainTextPassword(Scanner sc) {
		System.out.print("\n\tIntroduzca una contraseña: ");
		plainTextPassword = sc.next();
	}

	public void askEncryptionType(Scanner sc) {
		System.out.print("\t¿Desea aplicar el algoritmo MD5?(Y/N): ");
		String tipo = sc.next();

		switch (tipo.toUpperCase()) {
		case "Y":
			encryptionType = true;
			break;
		case "N":
			encryptionType = false;
			break;
		default:
			System.out.println("\tNo se reconoce ese valor, NO se aplicará el MD5.");
			encryptionType = false;
			break;
		}
		System.out.println("");
	}

	public void encrypt() {
		if (encryptionType == true) {
			md5Encryption();
		} else {
			defaultEncryption();
		}
	}

	private void defaultEncryption() {
		String[] newPass = new String[plainTextPassword.length()];
		for (int i = 0; i < plainTextPassword.length(); i++) {
			char c = plainTextPassword.charAt(i);
			int aVal = c;
			int nAV = aVal + 1;
			if (nAV < 33 || nAV > 126) {
				nAV = 42;
			}
			char nuevoc = (char) nAV;
			newPass[i] = String.valueOf(nuevoc);
		}
		encryptedPassword = String.join("", newPass);
	}

	private void md5Encryption() {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(plainTextPassword.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			encryptedPassword = hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public String isMD5() {
		if (encryptionType == true) {
			return "MD5";
		} else {
			return "Por defecto";
		}
	}
}
