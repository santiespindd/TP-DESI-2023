package tuti.desi.presentacion;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.OneToMany;
import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.TipoVuelo;
import tuti.desi.entidades.Vuelo;

public class VueloForm {
    private Long id;
	
    private String numeroVuelo;
	
	private Ciudad origen;
	
	private Ciudad destino;
	
    private TipoVuelo tipoVuelo;
	
	private BigDecimal precio;
	
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")	
	private LocalDate fechaPartida;
	
	private LocalTime horaPartida;
	
	private Avion avion;
	
	private String estado;

	public VueloForm() {
		super();
	}
	
	public VueloForm(Vuelo v) {
		super();
		this.id = v.getId();
		this.numeroVuelo = v.getNumeroVuelo();
		this.origen = v.getOrigen();
		this.destino = v.getDestino();
		this.tipoVuelo = v.getTipoVuelo();
		this.precio = v.getPrecio();
		this.fechaPartida = v.getFechaPartida();
		this.horaPartida = v.getHoraPartida();
		this.avion = v.getAvion();
		this.estado = v.getEstado();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroVuelo() {
		return numeroVuelo;
	}

	public void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}

	public Ciudad getOrigen() {
		return origen;
	}

	public void setOrigen(Ciudad origen) {
		this.origen = origen;
	}

	public Ciudad getDestino() {
		return destino;
	}

	public void setDestino(Ciudad destino) {
		this.destino = destino;
	}

	public TipoVuelo getTipoVuelo() {
		return tipoVuelo;
	}

	public void setTipoVuelo(TipoVuelo tipoVuelo) {
		this.tipoVuelo = tipoVuelo;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	

	public LocalDate getFechaPartida() {
		return fechaPartida;
	}

	public void setFechaPartida(LocalDate fechaPartida) {
		this.fechaPartida = fechaPartida;
	}

	public LocalTime getHoraPartida() {
		return horaPartida;
	}

	public void setHoraPartida(LocalTime horaPartida) {
		this.horaPartida = horaPartida;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Vuelo toPojo()
	{
		Vuelo v = new Vuelo();
		v.setId(this.getId());		
		v.setNumeroVuelo(this.numeroVuelo);
		v.setOrigen(this.getOrigen());
		v.setDestino(this.getDestino());
		v.setPrecio(this.getPrecio());
		v.setTipoVuelo(this.getTipoVuelo());
		v.setFechaPartida(this.fechaPartida);
		v.setHoraPartida(this.getHoraPartida());
		v.setAvion(this.getAvion());
		v.setEstado(this.getEstado());
		return v;
	}
	
}
