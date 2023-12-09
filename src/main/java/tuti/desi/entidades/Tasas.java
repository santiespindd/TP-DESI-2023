package tuti.desi.entidades;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Tasas {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	@DecimalMin(value = "0.00", inclusive = false, message = "El IVA debe ser mayor que 0")
    @DecimalMax(value = "100.00", message = "El IVA debe ser menor o igual a 100")
   
    private BigDecimal iva;

    @DecimalMin(value = "0.00", message = "La tasa aeroportuaria nacional debe ser igual o mayor a 0")
    @Digits(integer = 10, fraction = 2, message = "La tasa aeroportuaria nacional debe tener 2 decimales")
    private BigDecimal tasaAeroportuariaNacional;

    @DecimalMin(value = "0.00", message = "La tasa aeroportuaria internacional debe ser igual o mayor a 0")
    @Digits(integer = 10, fraction = 2, message = "La tasa aeroportuaria internacional debe tener 2 decimales")
    private BigDecimal tasaAeroportuariaInternacional;

    @DecimalMin(value = "0.00", message = "La cotización del dólar debe ser igual o mayor a 0")
    @Digits(integer = 10, fraction = 2, message = "La cotización del dólar debe tener 2 decimales")
    private BigDecimal cotizacionDolar;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public BigDecimal getTasaAeroportuariaNacional() {
		return tasaAeroportuariaNacional;
	}

	public void setTasaAeroportuariaNacional(BigDecimal tasaAeroportuariaNacional) {
		this.tasaAeroportuariaNacional = tasaAeroportuariaNacional;
	}

	public BigDecimal getTasaAeroportuariaInternacional() {
		return tasaAeroportuariaInternacional;
	}

	public void setTasaAeroportuariaInternacional(BigDecimal tasaAeroportuariaInternacional) {
		this.tasaAeroportuariaInternacional = tasaAeroportuariaInternacional;
	}

	public BigDecimal getCotizacionDolar() {
		return cotizacionDolar;
	}

	public void setCotizacionDolar(BigDecimal cotizacionDolar) {
		this.cotizacionDolar = cotizacionDolar;
	}

    // Constructor, getters y setters
    
    
}
