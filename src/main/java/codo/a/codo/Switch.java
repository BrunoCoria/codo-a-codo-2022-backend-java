package codo.a.codo;

import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		//Leer la nota desde el teclado
		//const variable = prompt('algo')
		Scanner teclado = new Scanner (System.in);
		
		System.out.println("Ingrese nota");
		int nota = teclado.nextInt();
		
		switch (nota) {
		case 7:
			System.out.println("Aprobado");
			break;
		case 10:
			System.out.println("Excelente");
		default:
			System.out.println("No se");
			break;
		}
		//Cierro el teclado
		teclado.close();
	}

}
