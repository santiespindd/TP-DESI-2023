package tuti.desi.presentacion;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import tuti.desi.entidades.Cliente;
import tuti.desi.entidades.Pasaje;
import tuti.desi.entidades.Vuelo;

public class PasajeForm {
	@NotNull(message="Debe seleccionar un vuelo")
	private Vuelo vuelo;
	private Cliente cliente;
	@NotNull(message="Debe seleccionar un asiento")
	private Integer asiento;
	private BigDecimal precio;

	public PasajeForm() {

	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getAsiento() {
		return asiento;
	}

	public void setAsiento(Integer asiento) {
		this.asiento = asiento;
	}
	
	public Pasaje toPojo() {
		Pasaje pasaje = new Pasaje();
		pasaje.setCliente(this.cliente);
		pasaje.setVuelo(this.vuelo);
		pasaje.setAsiento(this.asiento);
		pasaje.setCosto(this.precio);
		return pasaje;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
}