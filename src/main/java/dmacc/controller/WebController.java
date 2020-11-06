package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.IceCream;
import dmacc.repository.IceCreamRepository;

@Controller
public class WebController {
	@Autowired
	IceCreamRepository repo;
	
	@GetMapping("/viewAll")
	public String viewAll(Model model) {
		model.addAttribute("flavors", repo.findAll());
		return "results";
	}
	
	@GetMapping("/inputFlavor")
	public String inputFlavor(Model model) {
		IceCream c = new IceCream();
		model.addAttribute("newFlavor", c);
		return "input";
	}
	
	@PostMapping("/inputFlavor")
	public String inputFlavor(@ModelAttribute IceCream c, Model model) {
		repo.save(c);
		return viewAll(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateFlavor(@PathVariable("id") long id, Model model) {
		IceCream c = repo.findById(id).orElse(null);
		model.addAttribute("newFlavor", c);
		return "input";
	}
	
	@PostMapping("/update/{id}")
	public String reviseFlavor(IceCream c, Model model) {
		repo.save(c);
		return viewAll(model);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id, Model model) {
		IceCream c = repo.findById(id).orElse(null);
		repo.delete(c);
		return viewAll(model);
	}
}
