package tuti.desi.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;

import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
public class Vuelo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "El número de vuelo es requerido")
    
    private String numeroVuelo;
	
	@ManyToOne
    @JoinColumn(name = "ciudad_origen_id")
	@NotNull(message = "El origen es requerido")
    private Ciudad origen;
    
    @ManyToOne
    @JoinColumn(name = "ciudad_destino_id")
    @NotNull(message = "El destino es requerido")
    private Ciudad destino;
	
    @Enumerated(EnumType.STRING)
    @NotNull(message = "El tipo de vuelo es requerido")
    private TipoVuelo tipoVuelo;
	
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
	private BigDecimal precio;
	
    @Future(message = "La fecha de partida debe ser futura")
    @NotNull(message = "La fecha de partida es requerida")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaPartida;
    
    
    
    @NotNull(message = "La hora de partida es requerida")
    
	private LocalTime horaPartida;
	
	@ManyToOne
    @JoinColumn(name = "avion_id")
    private Avion avion;
	
	@NotNull
	private String estado ;


	@ElementCollection
	@CollectionTable(name="asientos_vuelos")
	@Column(name="nro_asiento")
	private List<Integer> asientosDisponibles = new ArrayList<Integer>();
	

	public Vuelo() {
		super();
	}

	public Vuelo(Long id, @NotBlank(message = "El número de vuelo es requerido") String numeroVuelo,
			@NotNull(message = "El origen es requerido") Ciudad origen,
			@NotNull(message = "El destino es requerido") Ciudad destino,
			@NotNull(message = "El tipo de vuelo es requerido") TipoVuelo tipoVuelo,
			@DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0") BigDecimal precio,
			@Future(message = "La fecha de partida debe ser futura") @NotNull(message = "La fecha de partida es requerida") LocalDate fechaPartida,
			@NotNull(message = "La hora de partida es requerida") LocalTime horaPartida,
			@NotNull() Avion avion, String estado, List<Integer> asientosDisponibles) {

		super();
		this.id = id;
		this.numeroVuelo = numeroVuelo;
		this.origen = origen;
		this.destino = destino;
		this.tipoVuelo = tipoVuelo;
		this.precio = precio;
		this.fechaPartida = fechaPartida;
		this.horaPartida = horaPartida;
		this.avion = avion;
		this.estado = estado;
		this.asientosDisponibles = asientosDisponibles;
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


	public List<Integer> getAsientosDisponibles() {
		return asientosDisponibles;
	}

	public void setAsientosDisponibles(List<Integer> asientosDisponibles) {

		this.asientosDisponibles = asientosDisponibles;
	}
	
}
