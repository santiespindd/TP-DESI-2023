package tuti.desi.servicios;

import java.util.List;

import jakarta.validation.Valid;
import tuti.desi.entidades.Tasas;
import tuti.desi.excepciones.Excepcion;



public interface TasasService {

	/**
	 * Obtiene la lista completa de tasas e impuestos
	 * @return Todas las tasas e impuestos 
	 */
	List<Tasas> getAll();
	
	/**
	 * Obtiene una tasa e impuestos determinada
	 * @param id Identificador de la tasa e impuesto determinado
	 * @return TasaImpuestos encontrada
	 */
	Tasas getById(Long idTasasImpuestos) ;
	
	public void saveOrUpdate(@Valid Tasas tasas);
	

}
