package tuti.desi.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Avion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    
    private int capacidadFilas;
    
    private int asientosPorFila;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidadFilas() {
		return capacidadFilas;
	}

	public void setCapacidadFilas(int capacidadFilas) {
		this.capacidadFilas = capacidadFilas;
	}

	public int getAsientosPorFila() {
		return asientosPorFila;
	}

	public void setAsientosPorFila(int asientosPorFila) {
		this.asientosPorFila = asientosPorFila;
	}

	@Override
	public String toString() {
		return "Avion [id=" + id + ", nombre=" + nombre + ", capacidadFilas=" + capacidadFilas + ", asientosPorFila="
				+ asientosPorFila + "]";
	}
    
}
