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
public class CadastroUsuarioController {
			
		@RequestMapping(value = "/cadastrousuario", method = RequestMethod.GET)
		public String home(Model model, HttpSession session) {
			Usuario usuariologado = (Usuario) session.getAttribute("usuariologado");
			if(usuariologado!=null&&usuariologado.getTipo()==TipoUsuario.ADMIN){
				return "cadastrousuario";
			}else{
				return "redirect:/error";
			}
		}
		
		@Inject
		private UsuarioDao dao;
		
		@RequestMapping(value = "/cadastrousuario", method = RequestMethod.POST)
		public String inserir(Usuario usuario, Model model, HttpSession session) {
			Usuario usuariologado = (Usuario) session.getAttribute("usuariologado");
			if(usuariologado!=null&&usuariologado.getTipo()==TipoUsuario.ADMIN){
				dao.inserir(usuario);
				return "redirect:/";
			}else{
				return "redirect:/error";
			}
		}
}
