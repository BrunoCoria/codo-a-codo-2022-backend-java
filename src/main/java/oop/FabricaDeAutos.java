package oop;

public class FabricaDeAutos {

	public static void main(String[] args) {
		
		// Quiero crear mi primer objeto de la clase Auto
		Auto fiatUno = new Auto(300f, "AUTO", new Motor("motor", 300f)); //Es el constructor
		
		// Quiero ver la velocidad del auto...
		// nombreDelObjeto.atributo;
		// fiatUno.encender(); // F3 ver metodo
		
		fiatUno.encender();
		
		fiatUno.acelerar();
		fiatUno.acelerar();
		
		System.out.println("Frenando");
		fiatUno.frenar();
		fiatUno.verVelocidad();
		
		fiatUno.apagar();
		fiatUno.verVelocidad();
		
		System.out.println("-- Fin --");
	}

}
