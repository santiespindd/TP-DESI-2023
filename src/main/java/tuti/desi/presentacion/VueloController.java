package tuti.desi.presentacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import tuti.desi.entidades.Avion;
import tuti.desi.entidades.Ciudad;
import tuti.desi.entidades.EstadoVuelo;
import tuti.desi.entidades.Vuelo;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.servicios.AvionService;
import tuti.desi.servicios.CiudadService;
import tuti.desi.servicios.VueloService;



@Controller
@RequestMapping("/vueloProgramar")
public class VueloController {

    @Autowired
    AvionService avionService;

    @Autowired
    CiudadService ciudadService;

    @Autowired
    VueloService vueloService;

    @GetMapping
    public String preparaForm(Model model) {
        VueloForm form = new VueloForm();
        
      
        model.addAttribute("formBean", form);
       
      
        return "vueloProgramar";
    }
    
    
    @ModelAttribute("ciudades")
    public List<Ciudad> getAllCiudades() {
        return this.ciudadService.getAll();
    }
    @ModelAttribute("aviones")
    public List<Avion> getAllAviones(){
    	
    	return this.avionService.obtenerTodosLosAviones();
    }
    
    
    @PostMapping
    public String submit(@ModelAttribute("formBean") @Valid VueloForm formBean, BindingResult result,
    		 
            Model model, @RequestParam String action) throws Excepcion {
    	
    	  formBean.setEstado((EstadoVuelo.NORMAL).getEstado());
        
    	if("Programar Vuelo".equals(action)) {
    		
    		
    		if (result.hasErrors()) {
    			
				return "/vueloProgramar";
				
			}

    	        if (!ciudadService.existeCiudad(formBean.getOrigen().getId()) || !ciudadService.existeCiudad(formBean.getDestino().getId())) {
    	        	model.addAttribute("error" ,"El origen o destino seleccionado no existe");
    	        	
    	        }

    	        if (vueloService.existeVueloParaMismoDia(formBean.getFechaPartida(), formBean.getAvion().getId())) {
    	        	
    	            model.addAttribute("error" , "Ya existe un vuelo programado para el mismo día para el avión seleccionado");
    	            
    	          
    	        }
    	        if(vueloService.existsByNumeroVuelo(formBean.getNumeroVuelo())) {
    	        	 model.addAttribute("error" , "Ya existe un vuelo con ese numero de vuelo");
     	            
     	           
    	        }
    	        else {

    	        	int totalAsientos = formBean.getAvion().getAsientosPorFila()*formBean.getAvion().getCapacidadFilas();
    	        	List <Integer> asientosDisponibles = new ArrayList<Integer>();
    	        	for (int i=1; i<=totalAsientos; i++) {
    	        		asientosDisponibles.add(i);
    	        	}
    	        	
    	        	Vuelo vuelo = new Vuelo(formBean.getId(), formBean.getNumeroVuelo(), formBean.getOrigen(), formBean.getDestino(),
    	    	                formBean.getTipoVuelo(), formBean.getPrecio(), formBean.getFechaPartida(), formBean.getHoraPartida(), formBean.getAvion(),
    	    	                formBean.getEstado(),asientosDisponibles);

    	    	        
    	    	        System.out.println(formBean.getEstado());
    	    	        vueloService.programarVuelo(vuelo);
    	    	        model.addAttribute("alerta" , "Vuelo programado exitosamente");
    	    	        
    	        	
    	        }
    	        
    	        return "/vueloProgramar";
    	       
    	}
      
     
        return "redirect:/";
    }
    
}