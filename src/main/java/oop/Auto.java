package oop;

// Nombre de clase
public class Auto {
	
	// Atributos de la clase
	//TIPO NOMBRE;
	private String color;
	private int anio;
	private long serie;
	private String marca;
	private String modelo;
	private float velocidad;
	private float velocidadMaxima;
	private boolean encendido;
	
	private Motor motor;
	private Estereo estereo;
	
	// Los atributos deben ser privados, no pueden ser vistos por todos
	// Pära obtener los atributos por fuera del package se utilizan getters
	
	// Cuando ance el objeto: constructor / Define valores por defecto
	// Todos los metodos pueden ver los atributos del objeto
	// Con "public" el constructor puede usarse fuera del package
	public Auto(float velocidadMaxima, String marca, Motor motor) {
		this.setVelocidadMaxima(velocidadMaxima);
		this.setMarca(marca);
		this.setVelocidad(0);
		this.setAnio(2022);
		this.setEncendido(false);
		this.setMotor(motor);
	}
	
	public void setMotor(Motor motor) {
		if(motor == null) {
			Motor motorInterno = new Motor("Default", 100f);
			this.motor = motorInterno;
		} else {
			this.motor = motor;
		}
	}
	public Motor getMotor() {
		return this.motor;
	}
	
	public void setEstereo(Estereo nuevoEstereo) {
		if(nuevoEstereo != null)
			this.estereo = nuevoEstereo;
	}
	
	// Metodos 
	public void encender() {
		if(!this.isEncendido()) {
			this.setEncendido(true);
			System.out.println("Se ha encendido el auto");
		} else {
			System.out.println("No se puede encender dos veces");
		}
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAnio() {
		return anio;
	}

	private void setAnio(int anio) {
		this.anio = anio;
	}

	private long getSerie() {
		return serie;
	}

	public void setSerie(long serie) {
		this.serie = serie;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getVelocidad() {
		return velocidad;
	}

	private void setVelocidad(float velocidad) {
		if(velocidad <0) {
			this.velocidad = 0;
		} else {
			this.velocidad = velocidad;
		}
	}

	public float getVelocidadMaxima() {
		return velocidadMaxima;
	}

	private void setVelocidadMaxima(float velocidadMaxima) {
		if(velocidadMaxima < 0 || velocidadMaxima > 220) {
			if(velocidadMaxima < 0)
				this.velocidadMaxima = 0;
			if(velocidadMaxima > 220)
				this.velocidadMaxima = 220;
		} else {
			this.velocidadMaxima = velocidadMaxima;
		}
	}

	public boolean isEncendido() {
		return encendido;
	}

	private void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}
	

	public void apagar() { // boolean isAlgo() Boolean getAlgo()
		if(this.isEncendido()) {
			// Un metodo puede llamar a otro metodo
			while(this.getVelocidad() > 0) {
				frenar();
			}
			this.setEncendido(false);;
			System.out.println("Se ha apagado el auto");
		} else {
			System.out.println("No se puede apagar dos veces");
		}
	} // Si adentro de un metodo no hay logica, el metodo no tiene implementacion. No hay codigo que resuelva, esta vacio.
	
	
	public void acelerar() {
		if(this.isEncendido()) {
			if(this.getVelocidad() < this.getVelocidadMaxima()) {
				this.setVelocidad(this.getVelocidad() + 1 );;	
			} else {
				System.out.println("Error: no puede superar la velocidad maxima");
			}
		} else {
			System.out.println("Error: debe encender el auto");
		}
	}
	
	public void frenar() {
		if(this.isEncendido()) {
			if(this.getVelocidad() > 0) {
				this.setVelocidad(this.getVelocidad() -1 );
			}
		} else {
			System.out.println("Error: auto pagado");
		}
	}
	
	public void verVelocidad() {
		System.out.println(velocidad);
	}
	
	public String getMarca() {
		return marca == null ? "" : marca; 
	}
	
	public void setMarca(String Marca) {
		if(marca != null)
			this.marca = marca;
		else {
			this.marca = "";
		}
	}
	
}
