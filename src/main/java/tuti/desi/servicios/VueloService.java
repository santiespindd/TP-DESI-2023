package tuti.desi.servicios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.Valid;
import tuti.desi.accesoDatos.IVueloRepo;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.TipoVuelo;
import tuti.desi.entidades.Vuelo;
import tuti.desi.presentacion.VueloForm;
import tuti.desi.presentacion.VuelosBuscarForm;

public interface VueloService {
	
	boolean existeVueloParaMismoDia(LocalDate fechaPartida, Long avionId);
	
	void programarVuelo(Vuelo vuelo);
	
	List<Vuelo>  findByFechaPartida(LocalDate fecha);
    
	public List<Vuelo> consultarVuelos(LocalDate fecha, Long origenId, Long destinoId, Enum tipoVuelo);

	public boolean existsByNumeroVuelo(String numeroVuelo);
	 
	public List<Vuelo> listarTodos();




}
