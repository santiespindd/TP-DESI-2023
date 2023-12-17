package tuti.desi.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.IPasajeRepo;
import tuti.desi.entidades.Pasaje;

@Service
public class PasajeServiceImpl implements PasajeService {

	@Autowired
	IPasajeRepo repo;
	
	@Override
	public void registrarPasaje (Pasaje pasaje) {
		
		repo.save(pasaje);
	}

}
