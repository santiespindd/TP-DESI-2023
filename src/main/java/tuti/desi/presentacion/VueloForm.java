package tuti.desi.presentacion;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.TipoVuelo;
import tuti.desi.entidades.Vuelo;

public class VueloForm {
    private Long id;
	
    
    @Column(unique = true)
    @NotBlank(message = "El número de vuelo es requerido")
    private String numeroVuelo;
	
    @NotNull(message = "El origen es requerido")
	private Ciudad origen;
    @NotNull(message = "El destino es requerido")
	private Ciudad destino;
	
    
    @NotNull(message = "El tipo de vuelo es requerido")
    private TipoVuelo tipoVuelo;
	
    
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
	private BigDecimal precio;
	
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")	
    @Future(message = "La fecha de partida debe ser futura")
    @NotNull(message = "La fecha de partida es requerida")
	private LocalDate fechaPartida;
	
    @NotNull(message = "La hora de partida es requerida")
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
