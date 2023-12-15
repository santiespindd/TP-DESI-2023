package tuti.desi.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.IClienteRepo;
import tuti.desi.entidades.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	IClienteRepo repo;

	@Override
	public Cliente buscarPorDNI(Long dni) {
		return repo.findById(dni).get();
		
	}
	
	

}
