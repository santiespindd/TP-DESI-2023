package tuti.desi.servicios;

import tuti.desi.entidades.Cliente;

public interface ClienteService {
	
	Cliente buscarPorDNI(Long dni);
}
