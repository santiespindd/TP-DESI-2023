package tuti.desi.servicios;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.Valid;
import tuti.desi.accesoDatos.IVueloRepo;
import tuti.desi.entidades.Vuelo;
import tuti.desi.presentacion.VueloForm;

public interface VueloService {
	
	boolean existeVueloParaMismoDia(LocalDateTime fechaHoraPartida, Long avionId);
	
	void programarVuelo(Vuelo vuelo);
}
