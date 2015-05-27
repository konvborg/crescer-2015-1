package filmator.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import filmator.model.TipoUsuario;
import filmator.model.Usuario;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		Usuario usuariologado = (Usuario) session.getAttribute("usuariologado");
		if(usuariologado!=null){
			boolean isadmin = usuariologado.getTipo()==TipoUsuario.ADMIN;
			model.addAttribute("isadmin", isadmin);
			model.addAttribute("nome",usuariologado.getNome());
			return "home";
		}else{
			return "redirect:/error";
		} 
	}
}
