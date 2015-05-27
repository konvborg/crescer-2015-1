package filmator.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import filmator.dao.UsuarioDao;
import filmator.model.Usuario;

@Controller
public class ListaUsuarioController {

	@Inject
	private UsuarioDao dao;
	
	@RequestMapping(value = "/listausuario", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		Usuario usuariologado = (Usuario) session.getAttribute("usuariologado");
		if(usuariologado!=null){
			model.addAttribute("listaUsuarios", dao.lista());
			return "listausuario";
		}else{
			return "redirect:/erro";
		}
	}
}