package filmator.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Filme;

@Controller
public class CadastroController {
			
		@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
		public String home(Model model) {
			return "cadastro";
		}
		
		@Inject
		private FilmeDao dao;
		
		@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
		public String inserir(Filme filme, Model model) {
			dao.inserir(filme);
			return "redirect:/lista";
		}
}
