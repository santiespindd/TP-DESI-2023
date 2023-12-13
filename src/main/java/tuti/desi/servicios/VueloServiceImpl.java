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
		// TODO Auto-generated method stub
		return repo.findByFechaPartida(fecha);
	}

	

  
   
    
   
}

