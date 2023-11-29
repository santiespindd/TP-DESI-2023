package tuti.desi.accesoDatos;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import tuti.desi.entidades.Tasas;

public interface ITasasRepo extends JpaRepository<Tasas, Long> {
	boolean existsByIvaAndTasaAeroportuariaNacionalAndTasaAeroportuariaInternacionalAndCotizacionDolar(
            BigDecimal iva, BigDecimal tasaAeroportuariaNacional,
            BigDecimal tasaAeroportuariaInternacional, BigDecimal cotizacionDolar
    );
}
