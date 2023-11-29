package tuti.desi.presentacion;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import tuti.desi.entidades.Tasas;

import java.math.BigDecimal;

public class TasasForm {

    private Long id;

    @DecimalMin(value = "0.00", inclusive = false, message = "El IVA debe ser mayor que 0")
    @DecimalMax(value = "100.00", message = "El IVA debe ser menor o igual a 100")
    
    private BigDecimal iva;

    @DecimalMin(value = "0.00", message = "La tasa aeroportuaria nacional debe ser igual o mayor a 0")

    private BigDecimal tasaAeroportuariaNacional;

    @DecimalMin(value = "0.00", message = "La tasa aeroportuaria internacional debe ser igual o mayor a 0")
   
    private BigDecimal tasaAeroportuariaInternacional;

    @DecimalMin(value = "0.00", message = "La cotización del dólar debe ser igual o mayor a 0")
   
    private BigDecimal cotizacionDolar;

    public TasasForm() {
    }

    public TasasForm(Tasas tasas) {
        this.id = tasas.getId();
        this.iva = tasas.getIva();
        this.tasaAeroportuariaNacional = tasas.getTasaAeroportuariaNacional();
        this.tasaAeroportuariaInternacional = tasas.getTasaAeroportuariaInternacional();
        this.cotizacionDolar = tasas.getCotizacionDolar();
    }



    public Tasas toPojo() {
        Tasas tasas = new Tasas();
        tasas.setId(this.id);
        tasas.setIva(this.iva);
        tasas.setTasaAeroportuariaNacional(this.tasaAeroportuariaNacional);
        tasas.setTasaAeroportuariaInternacional(this.tasaAeroportuariaInternacional);
        tasas.setCotizacionDolar(this.cotizacionDolar);
        return tasas;
    }

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

    
    
    
}
