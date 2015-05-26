package filmator.controller;


import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;

@Controller
public class ListaController {

	@Inject
	private FilmeDao dao;
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("listaFilmes", dao.lista());
		return "lista";
	}
}