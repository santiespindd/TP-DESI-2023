package tuti.desi.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import tuti.desi.accesoDatos.ITasasRepo;
import tuti.desi.entidades.Tasas;

@Service
public class TasasServiceImpl implements TasasService {

	 @Autowired
	    private  ITasasRepo tasasRepository;

	@Override
	public List<Tasas> getAll() {
		// TODO Auto-generated method stub
		return tasasRepository.findAll();
	}

	@Override
	public Tasas getById(Long idTasasImpuestos) {
		// TODO Auto-generated method stub
		return tasasRepository.findById(idTasasImpuestos).get();
	}
	 
	 @Override
	 public void saveOrUpdate(@Valid Tasas tasas) {
	        tasasRepository.save(tasas);
	    }
	
	 public boolean existeTasasConEstosDatos(Tasas tasas) {
	       
	        return tasasRepository.existsByIvaAndTasaAeroportuariaNacionalAndTasaAeroportuariaInternacionalAndCotizacionDolar(
	                tasas.getIva(), tasas.getTasaAeroportuariaNacional(), tasas.getTasaAeroportuariaInternacional(), tasas.getCotizacionDolar()
	        );
	    }
	 
}
