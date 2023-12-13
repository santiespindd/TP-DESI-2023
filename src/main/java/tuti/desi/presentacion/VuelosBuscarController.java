package tuti.desi.presentacion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import tuti.desi.servicios.CiudadService;
import tuti.desi.servicios.VueloService;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.TipoVuelo;
import tuti.desi.entidades.Vuelo;
import tuti.desi.presentacion.VuelosBuscarForm;

@Controller
@RequestMapping("/vuelosBuscar")
public class VuelosBuscarController {

	@Autowired
	private CiudadService ciudadService;

	@Autowired
	private VueloService vueloService;

	@GetMapping
	public String prepararForm(Model model) {
		VuelosBuscarForm form = new VuelosBuscarForm();
		model.addAttribute("formBean", form);  
        model.addAttribute("ciudades", ciudadService.getAll());	
		model.addAttribute("tiposVuelo", TipoVuelo.obtenerTodosLosTipos());
		
		
		return "vuelosBuscar";
	}

	@PostMapping
	public String submit(@ModelAttribute("formBean") @Valid VuelosBuscarForm formBean, BindingResult result,
			Model model, @RequestParam String action) {
		
		
        
       System.out.println(formBean.getFecha());
        
		if (action.equals("Buscar")) {
			
	        
			try {
				

				List<Vuelo> vuelos = vueloService.findByFechaPartida(formBean.getFecha());
				System.out.println("Número de vuelos encontrados: " + vuelos.size());
                
				
				//vuelos.sort(Comparator.comparing(Vuelo::getFechaHoraPartida));
				model.addAttribute("resultados", vuelos);
			} catch (Exception e) {
				result.reject("globalError", e.getMessage());
			}

			model.addAttribute("formBean", formBean);
			return "vuelosBuscar";
		}

		return "vuelosBuscar";

	}

}
