package tuti.desi.presentacion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.validation.constraints.NotNull;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.TipoVuelo;
import tuti.desi.servicios.CiudadService;
import tuti.desi.servicios.VueloService;

public class VuelosBuscarForm {
	
	    @NotNull(message = "Debe ingresar fecha")	
	    @DateTimeFormat(pattern = "yyyy-MM-dd")	
	    private LocalDate fecha;
	    private Long origenId;
	    private Long destinoId;
	    private TipoVuelo tipoVuelo;

	    private List<Ciudad> ciudades;
	    private List<TipoVuelo> tiposVuelo;
		public LocalDate getFecha() {
			return fecha;
		}
		public void setFecha(LocalDate fecha) {
			this.fecha = fecha;
		}
		public Long getOrigenId() {
			return origenId;
		}
		public void setOrigenId(Long origenId) {
			this.origenId = origenId;
		}
		public Long getDestinoId() {
			return destinoId;
		}
		public void setDestinoId(Long destinoId) {
			this.destinoId = destinoId;
		}
		public TipoVuelo getTipoVuelo() {
			return tipoVuelo;
		}
		public void setTipoVuelo(TipoVuelo tipoVuelo) {
			this.tipoVuelo = tipoVuelo;
		}
		public List<Ciudad> getCiudades() {
			return ciudades;
		}
		public void setCiudades(List<Ciudad> ciudades) {
			this.ciudades = ciudades;
		}
		public List<TipoVuelo> getTiposVuelo() {
			return tiposVuelo;
		}
		public void setTiposVuelo(List<TipoVuelo> tiposVuelo) {
			this.tiposVuelo = tiposVuelo;
		}
	    
	    

	
	
	

}
