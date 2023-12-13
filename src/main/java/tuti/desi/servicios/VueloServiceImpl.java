package tuti.desi.servicios;

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

    public boolean existeVueloParaMismoDia(Date fechaPartida, Long avionId) {
        return repo.existsByFechaPartidaAndAvionId(fechaPartida, avionId);
    }

  
   public List<Vuelo> consultarVuelos(Date fecha, Long origenId, Long destinoId, String tipoVuelo) {
    	
    	System.out.println("Consultando vuelos desde el servicio con fecha " + fecha + ", origen " + origenId + ", destino " + destinoId + ", tipo " + tipoVuelo);

        return repo.consultarVuelos(fecha, origenId, destinoId, tipoVuelo);
    }
    
   
}

