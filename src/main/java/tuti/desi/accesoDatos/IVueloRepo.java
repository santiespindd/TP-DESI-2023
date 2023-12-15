package tuti.desi.accesoDatos;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tuti.desi.entidades.Vuelo;

@Repository
public interface IVueloRepo extends JpaRepository<Vuelo, Long> {
	boolean existsByFechaPartidaAndAvionId(LocalDate fechaPartida, Long avionId);

	 List<Vuelo> findByFechaPartida(LocalDate fechaPartida);
	 
	 boolean existsByNumeroVuelo(String numeroVuelo);
	 

	 
	 @Query("SELECT v FROM Vuelo v WHERE v.fechaPartida = :fecha " +
	           "AND (:origenId IS NULL OR v.origen.id = :origenId) " +
	           "AND (:destinoId IS NULL OR v.destino.id = :destinoId) " +
	           "AND (:tipoVuelo IS NULL OR v.tipoVuelo = :tipoVuelo) " +
	           "ORDER BY v.fechaPartida ASC")
	    List<Vuelo> consultarVuelos(@Param("fecha") LocalDate fecha,
	                                @Param("origenId") Long origenId,
	                                @Param("destinoId") Long destinoId,
	                                @Param("tipoVuelo") Enum tipoVuelo);
	
}
	 
	 

	 


