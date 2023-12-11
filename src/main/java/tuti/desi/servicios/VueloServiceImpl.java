package tuti.desi.servicios;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.ICiudadRepo;
import tuti.desi.accesoDatos.IVueloRepo;
import tuti.desi.entidades.Vuelo;

@Service
public class VueloServiceImpl implements VueloService{
	
	@Autowired
	IVueloRepo repo;

    public void programarVuelo(Vuelo vuelo) {
    	repo.save(vuelo);
    }

    public boolean existeVueloParaMismoDia(LocalDateTime fechaHoraPartida, Long avionId) {
        return repo.existsByFechaHoraPartidaAndAvionId(fechaHoraPartida, avionId);
    }
    
}
