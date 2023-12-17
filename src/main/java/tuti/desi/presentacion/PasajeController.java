package tuti.desi.presentacion;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import tuti.desi.entidades.Cliente;
import tuti.desi.entidades.Tasas;
import tuti.desi.entidades.TipoVuelo;
import tuti.desi.entidades.Vuelo;
import tuti.desi.servicios.PasajeService;
import tuti.desi.servicios.TasasService;
import tuti.desi.servicios.VueloService;

@Controller
@RequestMapping("/pasajeVender")
public class PasajeController {
	
	@Autowired
	private PasajeService servPasaje;
	
	@Autowired
	private VueloService servVuelo;
	
	@Autowired
	private TasasService servTasas;
	
	@GetMapping
	public String formPasaje (Model modelo, @ModelAttribute Cliente cliente) {
		PasajeForm formVenta = new PasajeForm();
		formVenta.setCliente(cliente);
		modelo.addAttribute("formVenta", formVenta);
		
		return "pasajeVender";
	}
	
	
	@ModelAttribute("vuelos")
	public List <Vuelo> vuelosDisponibles(){
		return servVuelo.listarTodos();
	}
	
	@PostMapping
	public String submit (@ModelAttribute @Valid PasajeForm formVenta, BindingResult result,
	ModelMap modelo, @RequestParam String action) {
		
		if(action.equals("Elegir asiento"))
		{

			formVenta.setPrecio(calcularPrecio(formVenta));
			List <Integer> asientos = formVenta.getVuelo().getAsientosDisponibles();
			modelo.addAttribute("asientos", asientos);

			modelo.addAttribute("formVenta",formVenta);

    	return "pasajeVender";
    	}
    
    	
		else if(action.equals("Emitir ticket"))
		{

			servPasaje.registrarPasaje(formVenta.toPojo());
			servVuelo.reservarAsiento(formVenta.getVuelo(), formVenta.getAsiento());
			return "/ventaExitosa";

		}


    	else return "redirect:/";
	}
    	

	public BigDecimal calcularPrecio(PasajeForm formVenta) {
   		
		List <Tasas> tasasAll = servTasas.getAll();
		Tasas tasas = tasasAll.get(0);
		BigDecimal precioFinal = BigDecimal.ZERO;
		
			if (formVenta.getVuelo().getTipoVuelo()==TipoVuelo.NACIONAL) {
				precioFinal= formVenta.getVuelo().getPrecio();
				precioFinal=precioFinal.add(tasas.getTasaAeroportuariaNacional());
				precioFinal=precioFinal.add((precioFinal.multiply(tasas.getIva())).divide(BigDecimal.valueOf(100)));
			}
			
			else if (formVenta.getVuelo().getTipoVuelo()==TipoVuelo.INTERNACIONAL) {
				precioFinal= formVenta.getVuelo().getPrecio();
				precioFinal=precioFinal.multiply(tasas.getCotizacionDolar());
				precioFinal=precioFinal.add(tasas.getTasaAeroportuariaInternacional());
			}
				
		return precioFinal;
		
	}
	
}
