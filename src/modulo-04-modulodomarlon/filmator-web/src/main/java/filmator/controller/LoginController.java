package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.UsuarioDao;
import filmator.model.TipoUsuario;
import filmator.model.Usuario;

@Controller
public class LoginController {
			
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public String login(Model model, HttpSession session) {
			Usuario usuariologado = (Usuario) session.getAttribute("usuariologado");
			if(usuariologado!=null){
				return "redirect:/home";
			}
			
			return "login";
		}
		
		
		@Inject
		private UsuarioDao dao;
		
		@RequestMapping(value = "/autentica", method = RequestMethod.POST)
		public String login(Model model, Usuario usuario, HttpSession session) {
			usuario = dao.validar(usuario.getLogin(), usuario.getSenha());
			if(usuario!=null){
				session.setAttribute("usuariologado", usuario);
				return "redirect:/home";
			}else{
				return "redirect:/";
			}
		}
		
		@RequestMapping(value = "/logoff", method = RequestMethod.GET)
		public String logoff(Model model, Usuario usuario, HttpSession session) {
			session.invalidate();
			return "login";
		}
}