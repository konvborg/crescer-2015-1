package filmator.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.AvaliacaoDao;
import filmator.dao.FilmeDao;
import filmator.model.Avaliacao;
import filmator.model.Filme;
import filmator.model.TipoUsuario;
import filmator.model.Usuario;

@Controller
public class ListaController {

	@Inject
	private FilmeDao filmeDao;
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public String lista(Model model, HttpSession session) {
		Usuario usuariologado = (Usuario) session.getAttribute("usuariologado");
		if(usuariologado!=null){
			model.addAttribute("listaFilmes", filmeDao.lista());
			return "lista";
		}else{
			return "redirect:/erro";
		}
	}
	
	@Inject
	private AvaliacaoDao avaliarDao;
	
	@RequestMapping(value = "/avaliar", method = RequestMethod.POST)
	public String inserir(Avaliacao avaliacao, Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuariologado");
		if(usuario!=null){
			avaliarDao.inserir(avaliacao,usuario.getId());
			return "redirect:/lista";
		}else{
			return "redirect:/error";
		}
	}
}