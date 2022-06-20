 package codo.a.codo;

public class Operadores {

	public static void main(String[] args) {
		// Operador aritméticos
		// +, -, /, *
		
		// Relacionales
		//<, >, !=, >=, <=
		
		//Lógicos / Necesitan dos valores 
		//AND &&, OR ||, NOT !
		
		String usuario = "root";
		String contrasenia = "root";
		
		/* EN JAVASCRIPT
		if(usuario == "root" && contrasenia == "root") {
			System.out.println("OK");
		} else {
			System.out.println("FAIL");
		} */
		
		// EN JAVA 
		if("root".equals(usuario) && "root".equals(contrasenia)) {
			System.out.println("OK");
		} else {
			System.out.println("FAIL");
		}
	}

}
