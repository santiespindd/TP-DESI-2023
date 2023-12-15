package tuti.desi.accesoDatos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Cliente;

@Repository
public interface IClienteRepo extends JpaRepository <Cliente, Long> {

}
