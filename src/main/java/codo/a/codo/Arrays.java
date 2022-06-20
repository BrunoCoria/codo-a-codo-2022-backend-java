package codo.a.codo;

public class Arrays {

	public static void main(String[] args) {
		//const array = [];
		int[] array = new int [4];
		
		//
		String[] nombres = new String[] {"nombre1", "nombre2"};
		
		array[0] = 10;
		array[1] = 11;
		array[2] = 12;
		array[3] = 13;
		
		System.out.println("Fin");
		
		//Recorrer el array de enteros
		for(int i=0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		//Recorrer el array usando foreach
		for(int aux : array) {
			System.out.println(aux);
		}
		
		//Mostrar valor indice 3
		System.out.println("Mostrar indice 3 de array = " + array[3]);
	}

}
