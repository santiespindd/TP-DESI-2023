package tuti.desi.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tuti.desi.accesoDatos.IAvionRepo;
import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Ciudad;

public interface AvionService {

	List<Avion> obtenerTodosLosAviones();
	
}
