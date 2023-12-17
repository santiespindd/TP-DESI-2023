package tuti.desi.accesoDatos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Pasaje;

@Repository
public interface IPasajeRepo extends JpaRepository <Pasaje, Long> {

}