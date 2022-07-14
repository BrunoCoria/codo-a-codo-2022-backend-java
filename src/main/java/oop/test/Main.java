package oop.test;

import oop.Estereo;
import oop.Auto;
import oop.Motor;

public class Main {

	public static void main(String[] args) {
		
		// Composici�n
		Motor motorDesdeAfuera = new Motor("MCLAREN", 150F);
		// Ahora Auto tiene un constructor publico
		Auto auto = new Auto(220f, "FIAT", motorDesdeAfuera);
		
		// Asosiaci�n
		Estereo e = new Estereo();
		auto.setEstereo(e);
		
		// Quiero definir la marca de mi auto
		// auto.setMarca("FIAT");
	}

}
