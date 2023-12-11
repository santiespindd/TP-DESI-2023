package tuti.desi.accesoDatos;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Provincia;
import tuti.desi.entidades.Vuelo;

	@Repository
	public interface IVueloRepo extends JpaRepository<Vuelo, Long> {
		 boolean existsByFechaHoraPartidaAndAvionId(LocalDateTime fechaHoraPartida, Long avionId);
		 
	}
