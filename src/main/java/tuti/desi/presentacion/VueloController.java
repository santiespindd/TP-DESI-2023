package tuti.desi.presentacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
        List<Ciudad> ciudades = ciudadService.getAll();
        model.addAttribute("ciudades", ciudades);
        List<Avion> aviones = avionService.obtenerTodosLosAviones();
        model.addAttribute("aviones", aviones);
        return "vueloProgramar";
    }

    @PostMapping
    public ResponseEntity<String> submit(@ModelAttribute("formBean") @Valid VueloForm formBean, BindingResult result,
            ModelMap model, @RequestParam String action) throws Excepcion {
    	
    	  formBean.setEstado((EstadoVuelo.NORMAL).getEstado());

        if (result.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            for (ObjectError error : result.getAllErrors()) {
                errors.append(error.getDefaultMessage()).append("\n");
            }
            return ResponseEntity.badRequest().body(errors.toString());
        }

        if (!ciudadService.existeCiudad(formBean.getOrigen().getId()) || !ciudadService.existeCiudad(formBean.getDestino().getId())) {
            return ResponseEntity.badRequest().body("El origen o destino seleccionado no existe");
        }

        if (vueloService.existeVueloParaMismoDia(formBean.getFechaPartida(), formBean.getAvion().getId())) {
            return ResponseEntity.badRequest().body("Ya existe un vuelo programado para el mismo día para el avión seleccionado");
        }
        
        Vuelo vuelo = new Vuelo(formBean.getId(), formBean.getNumeroVuelo(), formBean.getOrigen(), formBean.getDestino(),
                formBean.getTipoVuelo(), formBean.getPrecio(), formBean.getFechaPartida(), formBean.getHoraPartida(), formBean.getAvion(),
                formBean.getEstado());
        
        System.out.println(formBean.getEstado());
        vueloService.programarVuelo(vuelo);
        return ResponseEntity.ok("Vuelo programado exitosamente");
    }
    
}