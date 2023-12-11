package tuti.desi.presentacion;

import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Ciudad;

public class AvionForm {
	private Long id;
    
    private String nombre;
    
    private int capacidadFilas;
    
    private int asientosPorFila;
    
    public AvionForm() {
		super();
		
    }
    
	public AvionForm(Long id, String nombre, int capacidadFilas, int asientosPorFila) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.capacidadFilas = capacidadFilas;
		this.asientosPorFila = asientosPorFila;
	}

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
	
	public Avion toPojo()
	{
		Avion a = new Avion();
		a.setId(this.id);
		a.setNombre(this.getNombre());
		a.setCapacidadFilas(this.getCapacidadFilas());
		a.setAsientosPorFila(this.getAsientosPorFila());
		return a;
	}

}
