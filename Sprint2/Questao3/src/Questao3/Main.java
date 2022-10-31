package Questao3;

import java.util.Scanner;
public class Main {

	private static final Scanner SCANNER = new Scanner(System.in);
	private static Scanner scan;

	public static void main(String[] args) {
		scan = SCANNER;
		String frase = "";
		String humor = "";
		String contador = "";
		String Divertido = "";
		String Chateado = "";
		boolean loop = true;

		while (loop) {

			contador = "";
			Divertido = "";
			Chateado = "";
			frase = "";

			while (frase == "") {
				System.out.println("Digite sua frase");
				frase = scan.nextLine();
			}			

			for (int i = 0; i < frase.length(); i++) {

				if (frase.charAt(i) == ':' && frase.charAt(i + 1) == '-' && frase.charAt(i + 2) == ')') {
					contador += "a";
				}

				if (frase.charAt(i) == ':' && frase.charAt(i + 1) == '-' && frase.charAt(i + 2) == '(') {
					contador += "b";
				}

			}
			
			for (int c = 0; c < contador.length(); c++) {
				Divertido += "a";
				Chateado += "b";
			}
			
			if (Divertido.equals("")) {
				Divertido = "default";
			}
			if (Chateado.equals("")) {
				Chateado = "default";
			}
			if (contador.equals(Divertido)) {
				humor = "divertido";
			} else if (contador.equals(Chateado)) {
				humor = "chateado";
			} else {
				humor = "neutro";
			}
			
			System.out.println(humor + " \n");
			System.out.println("Verificar Novamente?");
			System.out.println("1 - Finalizar");
			System.out.println("2 - Rodar Novamente");
			int resp = SCANNER.nextInt();
			if (resp == 1) {
				loop = false;
			}
		}
	}
}