package tuti.desi.presentacion;


import java.time.LocalDate;
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
				

				List<Vuelo> vuelos = vueloService.consultarVuelos(formBean.getFecha(), formBean.getOrigenId(), formBean.getDestinoId(), formBean.getTipoVuelo());
				System.out.println("Número de vuelos encontrados: " + vuelos.size());
				
				
                
				
				vuelos.sort(Comparator.comparing(Vuelo::getFechaPartida));
				
				if(vuelos.size() == 0 ) {
					
					model.addAttribute("error", "No se encontraron resultados");
				}
				
				
				model.addAttribute("resultados", vuelos);
				
			} catch (Exception e) {
				result.reject("globalError", e.getMessage());
				 System.out.println( e.getMessage());
			}

			model.addAttribute("formBean", formBean);
			model.addAttribute("ciudades", ciudadService.getAll());
		    model.addAttribute("tiposVuelo", TipoVuelo.obtenerTodosLosTipos());
			return "vuelosBuscar";
		}
		
		if ("Cancelar".equals(action)) {

			return "redirect:/";
		}
		
		model.addAttribute("ciudades", ciudadService.getAll());
	    model.addAttribute("tiposVuelo", TipoVuelo.obtenerTodosLosTipos());
	    
	    return "vuelosBuscar";
		

	}

}
