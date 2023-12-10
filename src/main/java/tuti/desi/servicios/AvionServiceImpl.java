package tuti.desi.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.IAvionRepo;
import tuti.desi.entidades.Avion;

@Service
public class AvionServiceImpl implements AvionService {
	
	@Autowired
	IAvionRepo avionRepo;

    public List<Avion> obtenerTodosLosAviones() {
        return avionRepo.findAll();
    }

}
