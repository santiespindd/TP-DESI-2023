package tuti.desi.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import tuti.desi.entidades.Tasas;
import tuti.desi.presentacion.TasasForm;
import tuti.desi.servicios.TasasServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/tasas")
public class TasasController {

	@Autowired
	private TasasServiceImpl tasasService;

	@GetMapping("/tasasLista")
	public String list(Model model) {
		List<Tasas> tasasList = tasasService.getAll();
		model.addAttribute("tasasList", tasasList);
		return "tasas/tasasLista";
	}

	@GetMapping("/tasasForm")
	public String showForm(Model model) {
		TasasForm tasasForm = new TasasForm();
		model.addAttribute("tasasForm", tasasForm);
		return "tasas/tasasForm";
	}

	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable Long id, Model model) {
		Tasas tasas = tasasService.getById(id);
		TasasForm tasasForm = new TasasForm(tasas);
		model.addAttribute("tasasForm", tasasForm);
		return "tasas/tasasForm";
	}

	@RequestMapping("/save")
	public String saveTasas(@ModelAttribute("tasasForm") @Valid TasasForm tasasForm, BindingResult result, Model model,
			@RequestParam String action) {

		if (action.equals("Guardar")) {
			Tasas tasas = tasasForm.toPojo();
			if (result.hasErrors()) {
				return "tasas/tasasForm";
			}

			if (tasasService.existeTasasConEstosDatos(tasas)) {
				model.addAttribute("error", "Ya existe una tasa con estos datos. No se puede guardar.");
				return "tasas/tasasForm";
			} else {
				
				tasasService.saveOrUpdate(tasas);
				return "redirect:/tasas/tasasLista";
			}

			
		}

		if ("Cancelar".equals(action)) {

			return "redirect:/tasas/tasasLista";
		}
		
		return "redirect:/";
		
	}
	
}

	