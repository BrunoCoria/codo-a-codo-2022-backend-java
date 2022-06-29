package oop;

public class Motor {

	private String nombre;
	private Float hp;
	
	// Constructor
	public Motor(String nombre, Float hp) {
		this.setNombre(nombre);
		this.setHp(hp);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getHp() {
		return hp;
	}

	public void setHp(Float hp) {
		this.hp = hp;
	}
	
	
}
