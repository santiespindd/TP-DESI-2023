package tuti.desi.servicios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.ICiudadRepo;
import tuti.desi.accesoDatos.IVueloRepo;
import tuti.desi.entidades.Vuelo;
import tuti.desi.presentacion.VuelosBuscarForm;

@Service
public class VueloServiceImpl implements VueloService{
	
	@Autowired
	IVueloRepo repo;

    public void programarVuelo(Vuelo vuelo) {
    	repo.save(vuelo);
    }

    public boolean existeVueloParaMismoDia(LocalDate fechaPartida, Long avionId) {
        return repo.existsByFechaPartidaAndAvionId(fechaPartida, avionId);
    }

	@Override
	public List<Vuelo> findByFechaPartida(LocalDate fecha) {
		return repo.findByFechaPartida(fecha);
	}

	 @Override
	 public List<Vuelo> consultarVuelos(LocalDate fecha, Long origenId, Long destinoId, Enum tipoVuelo) {
	        return repo.consultarVuelos(fecha, origenId, destinoId, tipoVuelo);
	    }
	 
	 @Override
    public boolean existsByNumeroVuelo(String numeroVuelo) {
		 return repo.existsByNumeroVuelo(numeroVuelo);

	 };

	

	@Override
	public List<Vuelo> listarTodos() {
		
		return repo.findAll();
	}

	@Override
	public void reservarAsiento(Vuelo vuelo, Integer asiento) {
		
		vuelo.getAsientosDisponibles().remove(asiento);
		repo.save(vuelo);
		
	};

   
    
   
}

