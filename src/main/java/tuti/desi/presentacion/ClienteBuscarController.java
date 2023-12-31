package tuti.desi.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tuti.desi.entidades.Cliente;
import tuti.desi.servicios.ClienteService;

@Controller
@RequestMapping("/clienteBuscar")
public class ClienteBuscarController {

	@Autowired
	private ClienteService servCliente;
	
	@GetMapping
	public String formCliente (Model modelo) {
		Cliente cliente = new Cliente();
		modelo.addAttribute("cliente", cliente);
		
		return "clienteBuscar";
	}
		
	@PostMapping
	public String submit (@ModelAttribute Cliente cliente, BindingResult result, ModelMap modelo, @RequestParam String action, RedirectAttributes redir) {
		
    	if(action.equals("Buscar"))
    	{
    		
    		try {
    			cliente=servCliente.buscarPorDNI(cliente.getDni());
    			modelo.addAttribute("encontrado", true);
    			modelo.addAttribute("cliente", cliente);
    			
			} catch (Exception e) {
				ObjectError error = new ObjectError("globalError", "El DNI es incorrecto o no está registrado en el sistema");
	            result.addError(error);
			}
     		
        	return "clienteBuscar";

    	} else if(action.equals("Cancelar"))

    	{
    		modelo.clear();
    		return "redirect:/";
    	}
    	
    		
    	else if (action.equals("Iniciar venta"))
    	{
    		redir.addAttribute("cliente", cliente);
    		return "redirect:/pasajeVender";
    	}
    	
    	else return "redirect:/";
    	   
	}
	
}

